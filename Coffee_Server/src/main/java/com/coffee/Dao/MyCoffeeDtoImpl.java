package com.coffee.Dao;

import com.coffee.CoffeeApplication.CoffeeService;
import com.coffee.Entity.ZernoInfo;

import com.coffee.Server.GreetingServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyCoffeeDtoImpl implements MyCoffeeDtoInterface {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ZernoInfo> getZernoInfo(){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from ZernoInfo");

        List<ZernoInfo> coffeeInfo = query.getResultList();
        return coffeeInfo;
    }

    @Override
    public void saveOrUpdateZernoInfo(ZernoInfo ZernoInfo) {
        entityManager.merge(ZernoInfo);
    }

    @Override
    public void deleteZernoInfo(int id) throws EntityNotFoundException{
        Session session = entityManager.unwrap(Session.class);
        ZernoInfo ZernoInfo = session.get(ZernoInfo.class, id);
        if (ZernoInfo == null) {
            throw new EntityNotFoundException("zerno with id " + id + " not found");
        }
        entityManager.remove(ZernoInfo);
    }

    @Override
    public ZernoInfo getZernoInfoById(int id) {
        ZernoInfo ZernoInfo = entityManager.find(ZernoInfo.class, id);
        return ZernoInfo;
    }

    @Override
    public List<Object[]> getWeightAndId(String country, int sort) {
        Session session = entityManager.unwrap(Session.class);

        Query<Object[]> query = session.createQuery(
                "SELECT z.id, z.weight FROM ZernoInfo z WHERE z.country = :country AND z.sort = :sort",
                Object[].class
        );
        query.setParameter("country", country);
        query.setParameter("sort", sort);

        List<Object[]> result = query.getResultList();
        return result;
    }

    @Override
    public void testings(String country, int sort) {
        Session session = entityManager.unwrap(Session.class);

        Query<Object[]> query = session.createQuery(
                "SELECT z.id, z.weight FROM ZernoInfo z WHERE z.country = :country AND z.sort = :sort",
                Object[].class
        );
        query.setParameter("country", country);
        query.setParameter("sort", sort);

        List<Object[]> result = query.getResultList();

        for (Object[] row : result) {
            Integer id = (Integer) row[0];
            Integer weight = (Integer) row[1];
            System.out.println("ID: " + id + ", Weight: " + weight);
        }
    }



}
