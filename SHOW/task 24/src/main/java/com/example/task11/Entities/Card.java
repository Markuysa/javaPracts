package com.example.task11.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cardswithbank")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Card implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cardnumber")
    private String cardnumber;
    @Column(name = "code")
    private int code;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "bankid")
    public Bank bank;
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