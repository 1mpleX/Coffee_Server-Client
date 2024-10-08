package com.coffee.Server;

import com.coffee.CoffeeApplication.CoffeeService;
import com.coffee.CoffeeApplication.GreetingServiceGrpc;
import com.coffee.Dao.MyCoffeeDtoImpl;
import com.coffee.Entity.ZernoInfo;
import com.coffee.Method.Testing;
import com.coffee.Service.MyCoffeeServiceImpl;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    private final Testing test;

    @Autowired
    public GreetingServiceImpl(Testing test) {
        this.test = test;
    }

    @Override
    public void greeting(CoffeeService.CoffeeRequest request,
                         StreamObserver<CoffeeService.CoffeeResponse> responseObserver) {
        System.out.println(request);

        int sort = Integer.parseInt(request.getSortList().getFirst());

        CoffeeService.CoffeeResponse response = CoffeeService
                .CoffeeResponse
                .newBuilder()
                .setGreeting(request.getCountry() + " "+ sort)
                .build();
        responseObserver.onNext(response);

        test.testing(request.getCountry(), sort);

        responseObserver.onCompleted();
    }
}
