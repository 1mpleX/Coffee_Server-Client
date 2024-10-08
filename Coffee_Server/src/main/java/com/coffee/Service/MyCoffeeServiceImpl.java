package com.coffee.Service;

import com.coffee.Dao.MyCoffeeDtoImpl;
import com.coffee.Entity.ZernoInfo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyCoffeeServiceImpl implements MyCoffeeService{

    @Autowired
    private MyCoffeeDtoImpl coffeeDto;

    @Override
    @Transactional
    public List<ZernoInfo> getZernoInfo() {
        return coffeeDto.getZernoInfo();
    }

    @Override
    @Transactional
    public void saveOrUpdateZernoInfo(ZernoInfo ZernoInfo) {
        coffeeDto.saveOrUpdateZernoInfo(ZernoInfo);
    }

    @Override
    @Transactional
    public void deleteZernoInfo(int id) throws EntityNotFoundException {
        coffeeDto.deleteZernoInfo(id);
    }

    @Override
    @Transactional
    public ZernoInfo getZernoInfoById(int id) {
        return coffeeDto.getZernoInfoById(id);
    }

    @Override
    @Transactional
    public List<Object[]> getWeightAndId(String country, int weight){
        return coffeeDto.getWeightAndId(country,weight);
    }
}
