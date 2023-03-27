package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class CardService {

    private Session session;

    public CardService(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public void add(String cardNumber, int code) {
        Card card = new Card(cardNumber,code);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(card);
        transaction.commit();
    }
    public void delete(String cardnumber) {
        System.out.println(cardnumber);
        var transaction = session.beginTransaction();
        String hql = "delete from Card where cardnumber= :cardnumber";
        session.createQuery(hql).setParameter("cardnumber",cardnumber).executeUpdate();
        transaction.commit();
    }

    public List<Card> getAll() {
        return session.createQuery("select a from Card a",
                Card.class).getResultList();
    }
    public Bank getBankByCard(String cardnumber){
        return session.createQuery("from Card where cardnumber = :cardnumber", Card.class)
                .setParameter("cardnumber",cardnumber).getSingleResult().getBank();
    }
    public List<Card> filterByCardNumber(){
        StringBuilder query = new StringBuilder("select cardnumber from Card");
        Query result = session.createQuery(query.toString());
        return result.list();
    }
    public List<Card> filterByCode(){
        StringBuilder query = new StringBuilder("select code from Card");
        Query result = session.createQuery(query.toString());
        return result.list();
    }

}

