package com.coffee.CoffeeApplication.grpc;

import com.coffee.CoffeeApplication.CoffeeService;
import com.coffee.CoffeeApplication.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class ClientGRPC {

    @PostConstruct
    public void startClient(){
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8088")
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        CoffeeService.CoffeeRequest request = CoffeeService
                .CoffeeRequest
                .newBuilder()
                .setCountry("Japan")
                .addSort("50")
                .build();


        CoffeeService.CoffeeResponse resp = stub.greeting(request);
        channel.shutdown();
        System.out.println(resp);
    }
}
