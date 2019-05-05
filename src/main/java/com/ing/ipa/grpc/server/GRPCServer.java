package com.ing.ipa.grpc.server;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.grpc.BraveGrpcClientInterceptor;
import com.github.kristofa.brave.grpc.BraveGrpcServerInterceptor;
import com.ing.ipa.grpc.Constant;
import com.ing.ipa.person.PersonServiceGrpc;
import io.grpc.*;
import io.prometheus.client.Collector;
import io.prometheus.client.CollectorRegistry;
import me.dinowernli.grpc.prometheus.Configuration;
import me.dinowernli.grpc.prometheus.MonitoringServerInterceptor;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {
      Brave brave = Constant.brave("person-service");

        Configuration configuration = Configuration.cheapMetricsOnly();
        MonitoringServerInterceptor monitoringInterceptor =
                MonitoringServerInterceptor.create(configuration);
        // plaintext server
        Server server = ServerBuilder.forPort(50051)
                .addService(ServerInterceptors.intercept(new PersonServiceImpl(),/*new BraveGrpcServerInterceptor(brave),*/monitoringInterceptor))
                .build();

        PrometheusServer prometheusServer = new PrometheusServer(CollectorRegistry.defaultRegistry, 8081);
        prometheusServer.start();

        // secure server
//        Server server = ServerBuilder.forPort(50051)
//                .addService(new PersonServiceImpl())
//                .useTransportSecurity(
//                        new File("ssl/server.crt"),
//                        new File("ssl/server.pem")
//                )
//                .build();


        server.start();

//        Thread.sleep(10000);
//        Collector.MetricFamilySamples metricFamilySamples= RegistryHelper.findRecordedMetricOrThrow("grpc_server_handled_total", configuration.getCollectorRegistry());
//
//        for(Collector.MetricFamilySamples.Sample sample:metricFamilySamples.samples){
//            System.out.println(sample.labelNames+""+sample.labelValues);
//            System.out.println(sample.name+""+sample.value);
//        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            prometheusServer.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        server.awaitTermination();
    }

}
