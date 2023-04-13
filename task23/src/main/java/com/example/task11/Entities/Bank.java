package com.example.task11.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bank")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Bank implements Serializable {


    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @JsonManagedReference
    @OneToMany(mappedBy = "bank")
    private List<Card> cards;
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private Long id;

    public Bank(String name, String address) {
        this.name=name;
        this.address=address;
    }

    public Bank() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}