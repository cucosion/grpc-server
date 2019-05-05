package com.ing.ipa.gridgain;

import java.util.*;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.binary.BinaryObjectBuilder;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.cache.QueryEntity;
import org.apache.ignite.cache.QueryIndex;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;


public class BinaryObjectExample {
    private static final String ORG_CACHE = BinaryObjectExample.class.getSimpleName();


    /**
     * @param args Program arguments, ignored.
     * @throws Exception If failed.
     */
    public static void main(String[] args) throws Exception {
        Ignition.setClientMode(true);

        try (Ignite ignite = Ignition.start("grpc-server/src/main/resources/ignite-configuration.xml")) {

            CacheConfiguration cacheCfg = new CacheConfiguration<>(ORG_CACHE);

            cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
            cacheCfg.setBackups(1);
            cacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);

            // Setting up query entity.
            QueryEntity queryEntity = new QueryEntity();

            queryEntity.setKeyType(Long.class.getName());
            queryEntity.setValueType("MyObject");

            // Listing query fields.
            LinkedHashMap<String, String> fields = new LinkedHashMap();

            fields.put("id", Long.class.getName());
            fields.put("orgId", Long.class.getName());
            fields.put("firstName", String.class.getName());
            fields.put("lastName", String.class.getName());
            fields.put("resume", String.class.getName());
            fields.put("salary", Double.class.getName());

            queryEntity.setFields(fields);

            // Listing indexes.
            Collection<QueryIndex> indexes = new ArrayList<>(3);

            indexes.add(new QueryIndex("id"));
            indexes.add(new QueryIndex("orgId"));
            indexes.add(new QueryIndex("salary"));

            queryEntity.setIndexes(indexes);

            cacheCfg.setQueryEntities(Arrays.asList(queryEntity));

            IgniteCache cache = ignite.getOrCreateCache(cacheCfg).withKeepBinary();

            BinaryObjectBuilder builder = Ignition.ignite().binary().builder("MyObject");

            builder.setField("id", 1l);
            builder.setField("orgId", 1l);
            builder.setField("firstName", "Ion");
            builder.setField("lastName", "Cucos");
            builder.setField("resume", "abc");
            builder.setField("salary", 1d);

            BinaryObject binaryObj = builder.build();

            cache.putIfAbsent(1l, binaryObj);


            // Run SQL without explicitly calling to loadCache().
            FieldsQueryCursor cur = cache.query(
                    new SqlFieldsQuery("select * from MyObject where firstName like ?")
                            .setArgs("Ion"));

            System.out.println("SQL Result: " + cur.getAll());

            // Run get() without explicitly calling to loadCache().
            Object obj = cache.get(1l);

            System.out.println("GET Result: " + obj);
        }
    }
}

