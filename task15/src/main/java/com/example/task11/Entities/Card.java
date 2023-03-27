package com.example.task11.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cardnumber")
    private String cardnumber;
    @Column(name = "code")
    private int code;


    public Card(String cardnumber, int code) {
        this.cardnumber = cardnumber;
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