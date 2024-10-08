package com.coffee.Server;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class MyCoffeeGRPCServer {

    private Server server;

    private final GreetingServiceImpl greetingService;

    @Autowired
    public MyCoffeeGRPCServer(GreetingServiceImpl greetingService) {
        this.greetingService = greetingService;
    }

    @PostConstruct
    public void startServer() {
        new Thread(() -> {
            try {
                server = ServerBuilder
                        .forPort(8088)
                        .addService(greetingService)
                        .build()
                        .start();

                System.out.println("gRPC Server started on port 8088");

                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @PreDestroy
    public void stopServer() {
        if (server != null) {
            server.shutdown();
            System.out.println("gRPC Server stopped");
        }
    }
}
