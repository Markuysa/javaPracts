package com.example.task11;

public class Card {
    private String cardNumber;
    private int code;

    public Card(String cardNumber, int code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCode() {
        return code;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCode(int code) {
        this.code = code;
    }
}