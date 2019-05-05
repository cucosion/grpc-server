package com.ing.ipa.grpc.client;

import com.github.kristofa.brave.grpc.BraveGrpcClientInterceptor;
import com.ing.ipa.grpc.Constant;
import com.ing.ipa.person.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import me.dinowernli.grpc.prometheus.Configuration;
import me.dinowernli.grpc.prometheus.MonitoringClientInterceptor;

import javax.net.ssl.SSLException;

public class PersonClient {

    public static void main(String[] args) throws SSLException {
        System.out.println("Hello I'm a gRPC client");

        PersonClient main = new PersonClient();
        main.run();
    }

    private void run() throws SSLException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .intercept(new BraveGrpcClientInterceptor(Constant.brave("client-example")))
                .intercept(MonitoringClientInterceptor.create(Configuration.allMetrics()))
                .build();


        // With server authentication SSL/TLS; custom CA root certificates; not on Android
//        ManagedChannel secureChannel = NettyChannelBuilder.forAddress("localhost", 50051)
//                .sslContext(GrpcSslContexts.forClient().trustManager(new File("ssl/ca.crt")).build())
//                .build();
        doUnaryCallPUT(channel);

        doUnaryCallGET(channel);

        doUnaryCallDELETE(channel);



//        doUnaryCallGET(secureChannel);

        System.out.println("Shutting down channel");
        channel.shutdown();

    }


    private void doUnaryCallPUT(ManagedChannel channel) {
        // created a  service client (blocking - synchronous)

        PersonServiceGrpc.PersonServiceBlockingStub personClient = PersonServiceGrpc.newBlockingStub(channel);

        Person person = Person.newBuilder().setId(2l).setResume("aaaaa").setOrgId(1l).setFirstName("Ion2").setLastName("Cucos").setSalary(1d).build();


        // Unary
        // created a protocol buffer grpc message

        PersonSetRequest personRequest = PersonSetRequest.newBuilder().setPerson(person).build();

        // call the RPC and get back a PersonResponse (protocol buffers)
        PersonSetResponse personResponse = personClient.setPerson(personRequest);

        System.out.println("PUT Response------->" + personResponse.toString());

    }

    private void doUnaryCallGET(ManagedChannel channel) {
        // created a  service client (blocking - synchronous)

        PersonServiceGrpc.PersonServiceBlockingStub personClient = PersonServiceGrpc.newBlockingStub(channel);

        // Unary
        // created a protocol buffer grpc message

        PersonGetRequest personRequest = PersonGetRequest.newBuilder().setFirstName("Ion2").build();

        // call the RPC and get back a PersonResponse (protocol buffers)
        PersonGetResponse personResponse = personClient.getPerson(personRequest);

        System.out.println("GET Response------->" + personResponse.toString());

    }

    private void doUnaryCallDELETE(ManagedChannel channel) {
        // created a  service client (blocking - synchronous)

        PersonServiceGrpc.PersonServiceBlockingStub personClient = PersonServiceGrpc.newBlockingStub(channel);

        // Unary
        // created a protocol buffer grpc message
        PersonDeleteRequest personDeleteRequest = PersonDeleteRequest.newBuilder().setId("2").build();

        PersonDeleteResponse personDeleteResponse = personClient.deletePerson(personDeleteRequest);

        System.out.println("Delete Response----------->"+personDeleteResponse.toString());
    }

}
