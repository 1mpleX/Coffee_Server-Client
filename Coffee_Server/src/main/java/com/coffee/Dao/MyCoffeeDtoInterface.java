package com.coffee.Dao;

import com.coffee.Entity.ZernoInfo;

import java.util.*;

public interface MyCoffeeDtoInterface {
    List<ZernoInfo> getZernoInfo();
    void saveOrUpdateZernoInfo(ZernoInfo ZernoInfo);
    void deleteZernoInfo(int id);
    ZernoInfo getZernoInfoById(int id);
    List<Object[]> getWeightAndId(String country, int sort);
    void testings(String country, int sort);
}
