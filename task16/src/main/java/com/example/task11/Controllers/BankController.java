package com.example.task11.Controllers;


import com.example.task11.Entities.Bank;
import com.example.task11.Services.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService=bankService;
    }

    @PostMapping()
    @ResponseBody
    public void createCard(@RequestParam String name,@RequestParam String address) {
        bankService.add(name,address);

    }

    @DeleteMapping("/{name}")
    public void deleteBank(@PathVariable String name) {
        bankService.delete(name);
    }

    @GetMapping()
    public List<Bank> getAllBanks() {
        return bankService.getAll();
    }
}