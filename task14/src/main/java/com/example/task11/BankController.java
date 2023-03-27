package com.example.task11;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    private List<Bank> banks = new ArrayList<>();

    @PostMapping()
    @ResponseBody
    public void createCard(@RequestParam String name,@RequestParam String address) {
        banks.add(new Bank(name,address));
    }
    @PostMapping("/json")
    @ResponseBody
    public void createCardJSON(@RequestParam String json) {

        banks.add(new Bank("json","object"));
    }

    @DeleteMapping("/{name}")
    public void deleteBank(@PathVariable String name) {
        banks.removeIf(bank -> bank.getName().equals(name));
    }

    @GetMapping()
    public List<Bank> getAllBanks() {
        return banks;
    }


}