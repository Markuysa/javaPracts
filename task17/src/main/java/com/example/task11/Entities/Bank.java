package com.example.task11.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bank")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Bank implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private Long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @JsonManagedReference
    @OneToMany(mappedBy = "bank")
    private List<Card> cards;
    public Bank(String name, String address) {
        this.name=name;
        this.address=address;
    }

    public Bank() {

    }
}