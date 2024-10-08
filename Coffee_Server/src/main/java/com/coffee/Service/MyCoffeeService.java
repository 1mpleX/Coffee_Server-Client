package com.coffee.Service;

import com.coffee.Entity.ZernoInfo;

import java.util.List;

public interface MyCoffeeService {
    List<ZernoInfo> getZernoInfo();
    void saveOrUpdateZernoInfo(ZernoInfo ZernoInfo);
    void deleteZernoInfo(int id);
    ZernoInfo getZernoInfoById(int id);
    List<Object[]> getWeightAndId(String county, int sort);
}
