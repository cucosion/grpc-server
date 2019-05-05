package com.ing.ipa.grpc.server;

import com.ing.ipa.person.*;
import com.ing.ipa.person.PersonServiceGrpc.PersonServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.binary.BinaryObjectBuilder;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.cache.QueryEntity;
import org.apache.ignite.cache.QueryIndex;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.lang.IgniteBiPredicate;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import java.util.*;
import java.util.concurrent.Semaphore;

public class PersonServiceImpl extends PersonServiceImplBase {
    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);


    private static final Ignite igniteClient;
    private static final IgniteCache<Long, BinaryObject> cache;

    static {
        Ignition.setClientMode(true);
        igniteClient = Ignition.start("grpc-server/src/main/resources/ignite-configuration.xml");

        String cacheName = "Person_Cache";
        String objectName = "Person";

        // Listing query fields.
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();

        fields.put("id", Long.class.getName());
        fields.put("orgId", Long.class.getName());
        fields.put("firstName", String.class.getName());
        fields.put("lastName", String.class.getName());
        fields.put("resume", String.class.getName());
        fields.put("salary", Double.class.getName());

        List<String> listIndexes = Arrays.asList("id", "orgId", "salary");
        CacheConfiguration cacheCfg = getCacheConfiguration(cacheName, objectName, fields, listIndexes);

        cache = igniteClient.getOrCreateCache(cacheCfg).withKeepBinary();
    }

    private final Semaphore semaphore = new Semaphore(5);



    @Override
    public void setPerson(PersonSetRequest request, StreamObserver<PersonSetResponse> responseObserver) {
        Person person = request.getPerson();

        BinaryObjectBuilder builder = Ignition.ignite().binary().builder("Person");

        builder.setField("id", person.getId());
        builder.setField("orgId", person.getOrgId());
        builder.setField("firstName", person.getFirstName());
        builder.setField("lastName", person.getLastName());
        builder.setField("resume", person.getResume());
        builder.setField("salary", person.getSalary());

        BinaryObject binaryObj = builder.build();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cache.putIfAbsent(1L, binaryObj);

        //use igniteClient
        semaphore.release();

        System.out.println("---------------------->Person Added");


        PersonSetResponse personSetResponse = PersonSetResponse.newBuilder().setFirstName("Ion").build();
        // send the response
        responseObserver.onNext(personSetResponse);

        // complete the RPC call
        responseObserver.onCompleted();


    }

    @NotNull
    private static CacheConfiguration getCacheConfiguration(String cacheName, String objectType, LinkedHashMap<String, String> fields, List<String> listIndexes) {
        CacheConfiguration<Long, BinaryObject> cacheCfg = new CacheConfiguration<>(cacheName);
        cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        cacheCfg.setBackups(1);
        cacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);

        // Setting up query entity.
        QueryEntity queryEntity = new QueryEntity();

        queryEntity.setKeyType(Long.class.getName());
        queryEntity.setValueType(objectType);

        queryEntity.setFields(fields);

        // Listing indexes.
        Collection<QueryIndex> indexes = new ArrayList<>(3);

        listIndexes.forEach(s -> indexes.add(new QueryIndex(s)));

        queryEntity.setIndexes(indexes);

        cacheCfg.setQueryEntities(Collections.singletonList(queryEntity));
        return cacheCfg;
    }

    @Override
    public void getPerson(PersonGetRequest request, StreamObserver<PersonGetResponse> responseObserver) {
        String firstName = request.getFirstName();


        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Run SQL without explicitly calling to loadCache().
        List<List<?>> cur = cache.query(new SqlFieldsQuery("select * from Person where firstName like ?").setArgs(firstName)).getAll();

        List<?> personAsList = cur.get(0);
        System.out.println("SQL Result: " + cur);

        Person person = Person.newBuilder()
                .setId((long)(Object)personAsList.get(0))
                .setOrgId((long)(Object)personAsList.get(1))
                .setFirstName((String)(Object)personAsList.get(2))
                .setLastName((String) (Object)personAsList.get(3))
                .setResume((String)(Object)personAsList.get(4))
                .setSalary((double)(Object)personAsList.get(5))
                .build();

        List<List<?>> all = cache.query(new SqlFieldsQuery("SELECT _key from Person where firstName like ?").setArgs(firstName)).getAll();

        System.out.println("get key by select"+all);
        // Run get() without explicitly calling to loadCache().
        cache.forEach(longBinaryObjectEntry -> System.out.println(longBinaryObjectEntry.getKey()+""+longBinaryObjectEntry));

//        System.out.println("Scan by address");
//
//        ScanQuery<Long, BinaryObject> scanAddress = new ScanQuery<>((aLong, binaryObject) -> binaryObject.<String>field("firstName").startsWith(firstName));
//
//        ScanQuery<Long, BinaryObject> scanAddress = new ScanQuery<>(
//                new IgniteBiPredicate<Long, BinaryObject>() {
//                    @Override
//                    public boolean apply(Long aLong, BinaryObject binaryObject) {
//                        return binaryObject.<String>field("firstName").startsWith(firstName);
//                    }
//                }
//        );
//
//        List<Cache.Entry<Long, BinaryObject>> result = cache.query(scanAddress).getAll();
//        System.out.println("result: " + result.size());
//        result.stream().forEach(longBinaryObjectEntry -> System.out.println(longBinaryObjectEntry.getValue().deserialize().toString()));
//
//        BinaryObject obj=result.get(0).getValue();
//        BinaryObject obj = cache.get((long) 1);
        //use igniteClient
        semaphore.release();

//        System.out.println("GET Result: " + obj);
//
//        Person person = Person.newBuilder()
//                .setId(obj.field("id"))
//                .setResume(obj.field("resume"))
//                .setOrgId(obj.field("orgId"))
//                .setFirstName(obj.field("firstName"))
//                .setLastName(obj.field("lastName"))
//                .setSalary(obj.field("salary"))
//                .build();

        PersonGetResponse personGetResponse = PersonGetResponse.newBuilder().setPerson(person).build();

        // send the response
        responseObserver.onNext(personGetResponse);

        // complete the RPC call
        responseObserver.onCompleted();


    }

    @Override
    public void deletePerson(PersonDeleteRequest request, StreamObserver<PersonDeleteResponse> responseObserver) {
        String id = request.getId();
        String sql = "delete from Person where id = ?";

        List<List<?>> all = cache.query(new SqlFieldsQuery(sql).setArgs(id)).getAll();
        System.out.println("result after delete"+all);

//        cache.remove((long) 1);
        PersonDeleteResponse personDeleteResponse = PersonDeleteResponse.newBuilder().setId(id).build();
        responseObserver.onNext(personDeleteResponse);
        responseObserver.onCompleted();

    }
}
