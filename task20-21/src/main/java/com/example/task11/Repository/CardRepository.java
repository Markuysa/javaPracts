package com.example.task11.Repository;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CardRepository extends JpaRepository<Card,Long> {
    void deleteByCardnumber(String cardnumber);
    @Query("SELECT u.bank FROM Card u WHERE u.cardnumber = ?1")
    Bank findBankByCardnumber(String cardnumber);

    Card findByCardnumber(String cardnumber);
    @Query("SELECT u.code FROM Card u")
    List<Integer> findAllCardCodes();
    @Query("SELECT u.cardnumber FROM Card u")
    List<String> findAllCardNumbers();
}
