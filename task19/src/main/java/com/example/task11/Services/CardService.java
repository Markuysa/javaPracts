package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import com.example.task11.Repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService implements CardServiceInterface {


    private final CardRepository cardRepos;

    public void add(String cardNumber, int code) {
        log.info("Add card request received");
        cardRepos.save(new Card(cardNumber,code));
    }
    @Transactional
    public void delete(String cardnumber) {
        log.info("Delete card request received");
        cardRepos.deleteByCardnumber(cardnumber);
    }

    public List<Card> getAll() {
        log.info("Get all cards request received");
        return cardRepos.findAll();
    }
    public Bank getBankByCard(String cardnumber){
        log.info("Get bank by card number request received");
        return cardRepos.findBankByCardnumber(cardnumber);
    }
    public List<String> filterByCardNumber(){
        log.info("Filter by card number request received");
        return cardRepos.findAllCardNumbers();
    }
    public List<Integer> filterByCode(){
        log.info("Filter by card code request received");
        return cardRepos.findAllCardCodes();
    }

}

