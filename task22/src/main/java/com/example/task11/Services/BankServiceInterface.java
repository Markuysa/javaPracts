package com.example.task11.Services;

import com.example.task11.Entities.Bank;

import java.util.List;

public interface BankServiceInterface {
    public void add(String name, String address);
    public void delete(String name);
    public List<Bank> getAll();
    public List<String> filterByName();
    public List<String> filterByAddress();
}
