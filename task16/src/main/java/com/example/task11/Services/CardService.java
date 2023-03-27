package com.example.task11.Services;

import com.example.task11.Entities.Card;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CardService {

    private Session session;

    public void CardService(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public void add(String cardNumber, int code) {
        Card card = new Card(cardNumber,code);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(card);
        transaction.commit();
    }
    public void delete(String cardNumber) {

        var transaction = session.beginTransaction();
        String hql = "delete from Card where Card.cardNumber = :cardnumber";
        session.createQuery(hql).setParameter("cardnumber",cardNumber);
        transaction.commit();
    }

    public List<Card> getAll() {
        return session.createQuery("select a from Card a",
                Card.class).getResultList();
    }
}
