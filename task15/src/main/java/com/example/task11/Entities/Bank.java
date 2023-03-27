package com.example.task11.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private Long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public Bank(String name, String address) {
        this.name=name;
        this.address=address;
    }

    public Bank() {

    }
}