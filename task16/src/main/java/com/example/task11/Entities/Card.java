package com.example.task11.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {
    @Id
    private Long id;
    @Column(name = "cardnumber")
    private String cardNumber;
    @Column(name = "code")
    private int code;


    public Card(String cardNumber, int code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }

    public Card() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}