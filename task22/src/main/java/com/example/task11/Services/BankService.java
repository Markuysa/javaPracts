package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Repository.BankRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankService implements BankServiceInterface{

    @Autowired
    private BankRepository bankRepos;
    @Autowired
    private EmailService emailService;
    public BankService(BankRepository bankRepos, EmailService emailService) {
        this.emailService = emailService;
        this.bankRepos = bankRepos;
    }
    @Transactional
    public void add(String name, String address) {

        log.info("Add bank request received");
        bankRepos.save(new Bank(name,address));
        emailService.sendMessage("markuysa.study@mail.ru",
                                 "Object created",
                                "Object "+ name +" "+ address +" created");
    }
    @Transactional
    public void delete(String name) {
        log.info("Delete bank request received");
        bankRepos.deleteByName(name);
    }
    @Transactional
    public List<Bank> getAll() {
        log.info("Get all banks request received");
        return bankRepos.findAll();
    }
    @Transactional
    public List<String> filterByName(){

        log.info("Filter banks by name request received");
        return bankRepos.findAllBankNames();
    }
    @Transactional
    public List<String> filterByAddress(){
        log.info("Filter banks by address request received");
        return bankRepos.findAllBankAddresses();
    }
}
