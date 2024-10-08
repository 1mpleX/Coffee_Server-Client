package com.coffee.Method;

import com.coffee.CoffeeApplication.CoffeeService;
import com.coffee.Controller.MyCoffeeRESTController;
import com.coffee.Dao.MyCoffeeDtoImpl;
import com.coffee.Service.MyCoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class Testing {

    @Autowired
    @Lazy
    private MyCoffeeDtoImpl myCoffeeDto;

    public void testing(String country, int sort) {
        myCoffeeDto.testings(country, sort);
    }
}
