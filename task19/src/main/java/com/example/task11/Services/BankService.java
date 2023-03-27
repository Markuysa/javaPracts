package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Repository.BankRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BankService implements BankServiceInterface{

    @Autowired
    private BankRepository bankRepos;
    public BankService(BankRepository bankRepos) {
        this.bankRepos = bankRepos;
    }

    public void add(String name, String address) {
        bankRepos.save(new Bank(name,address));
    }
    @Transactional
    public void delete(String name) {
        bankRepos.deleteByName(name);
    }

    public List<Bank> getAll() {
        return bankRepos.findAll();
    }
    public List<String> filterByName(){
        return bankRepos.findAllBankNames();
    }
    public List<String> filterByAddress(){
        return bankRepos.findAllBankAddresses();
    }
}
