package com.example.task11.Controllers;


import com.example.task11.Entities.Card;
import com.example.task11.Services.CardService;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping()
    @ResponseBody
    public void createCard(@RequestParam String number,@RequestParam int code) {

        cardService.add(number,code);
    }

    @DeleteMapping("/{cardNumber}")
    public void deleteCard(@PathVariable String cardNumber) {
        cardService.delete(cardNumber);
    }

    @GetMapping()
    public List<Card> getAllCards() {

        return cardService.getAll();
    }
}
