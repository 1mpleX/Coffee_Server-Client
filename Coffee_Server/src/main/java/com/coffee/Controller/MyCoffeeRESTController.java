package com.coffee.Controller;

import com.coffee.Entity.ZernoInfo;
import com.coffee.Service.MyCoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MyCoffeeRESTController {

    @Autowired
    private MyCoffeeService coffeeService;

    @GetMapping("/coffee")
    public List<ZernoInfo> getZernoInfo(){
        return coffeeService.getZernoInfo();
    }

    @PutMapping("/coffee")
    public ZernoInfo saveOrUpdateZernoInfo(@RequestBody ZernoInfo ZernoInfo){
        coffeeService.saveOrUpdateZernoInfo(ZernoInfo);
        return ZernoInfo;
    }

    @DeleteMapping("/coffee/{id}")
    public String deleteZernoInfo(@PathVariable int id){
        coffeeService.deleteZernoInfo(id);
        List<ZernoInfo> ZernoInfo = coffeeService.getZernoInfo();
        System.out.println(ZernoInfo);
        return "Zerno with id " + id + " was deleted";
    }

    @GetMapping("coffee/{id}")
    public ZernoInfo getZernoInfoById(@PathVariable int id){
        return coffeeService.getZernoInfoById(id);
    }

    @GetMapping("coffee/{country}/{sort}")
    public List<Object[]> getZernoInfoByCountryAndSort(@PathVariable String country, @PathVariable int sort){

        List<Object[]> zernoInfoList = coffeeService.getWeightAndId(country, sort);
        zernoInfoList.forEach(event -> System.out.println("ID: " + event[0] + ", Weight: " + event[1]));

        return zernoInfoList;
    }
}
