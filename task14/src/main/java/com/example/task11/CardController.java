package com.example.task11;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private List<Card> cards = new ArrayList<>();

    @PostMapping()
    @ResponseBody
    public void createCard(@RequestParam String number,@RequestParam int code) {
        cards.add(new Card(number,code));
    }

    @DeleteMapping("/{cardNumber}")
    public void deleteCard(@PathVariable String cardNumber) {
        cards.removeIf(card -> card.getCardNumber().equals(cardNumber));
    }

    @GetMapping()
    public List<Card> getAllCards() {
        return cards;
    }
}
