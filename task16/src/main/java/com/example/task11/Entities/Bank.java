package com.example.task11.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank {
    @Id
    @Autowired
    private Long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public Bank(String name, String address) {
    }

    public Bank() {

    }
}