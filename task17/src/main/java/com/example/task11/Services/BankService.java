package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class BankService {
    private final Session session;
    public BankService(SessionFactory sessionFactory) {

        this.session = sessionFactory.openSession();
    }

    public void add(String name, String address) {
        System.out.println(name+address);
        Bank bank = new Bank(name,address);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(bank);
        transaction.commit();
    }
    public void delete(String name) {

        var transaction = session.beginTransaction();
        String hql = "delete from Bank where name= :name";
        session.createQuery(hql).setParameter("name", name).executeUpdate();
        transaction.commit();
    }

    public List<Bank> getAll() {
        return session.createQuery("select b from Bank b",
                Bank.class).getResultList();
    }
    public List<Bank> filterByName(){
        StringBuilder query = new StringBuilder("select name from Bank");
        Query result = session.createQuery(query.toString());
        return result.list();
    }
    public List<Bank> filterByAddress(){
        StringBuilder query = new StringBuilder("select address from Bank");
        Query result = session.createQuery(query.toString());
        return result.list();
    }
}
