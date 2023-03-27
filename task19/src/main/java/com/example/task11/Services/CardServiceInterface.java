package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;

import java.util.List;

public interface CardServiceInterface {
    public void add(String cardNumber, int code);
    public void delete(String cardnumber);
    public List<Card> getAll();
    public Bank getBankByCard(String cardnumber);
    public List<String> filterByCardNumber();
    public List<Integer> filterByCode();
}
