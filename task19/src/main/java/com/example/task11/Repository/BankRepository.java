package com.example.task11.Repository;

import com.example.task11.Entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {
    void deleteByName(String name);
    @Query("SELECT u.name FROM Bank u")
    List<String> findAllBankNames();
    @Query("SELECT u.address FROM Bank u")
    List<String> findAllBankAddresses();
}
