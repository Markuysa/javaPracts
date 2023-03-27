package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import com.example.task11.Repository.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardService implements CardServiceInterface {


    private final CardRepository cardRepos;
    public CardService(CardRepository cardRepos) {

        this.cardRepos = cardRepos;
    }

    public void add(String cardNumber, int code) {
        cardRepos.save(new Card(cardNumber,code));
    }
    @Transactional
    public void delete(String cardnumber) {
        cardRepos.deleteByCardnumber(cardnumber);
    }

    public List<Card> getAll() {
        return cardRepos.findAll();
    }
    public Bank getBankByCard(String cardnumber){
        return cardRepos.findBankByCardnumber(cardnumber);
    }
    public List<String> filterByCardNumber(){
        return cardRepos.findAllCardNumbers();
    }
    public List<Integer> filterByCode(){
        return cardRepos.findAllCardCodes();
    }

}

