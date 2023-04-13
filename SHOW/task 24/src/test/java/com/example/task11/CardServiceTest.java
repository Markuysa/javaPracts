package com.example.task11;


import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import com.example.task11.Repository.BankRepository;
import com.example.task11.Repository.CardRepository;
import com.example.task11.Services.BankService;
import com.example.task11.Services.CardService;
import com.example.task11.Services.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)

public class CardServiceTest {

    @Captor
    ArgumentCaptor<Card> captor;

    @Mock
    private CardRepository cardRepository;
    @Mock
    private EmailService emailService;

    @Test
    void addCard() {

        CardService service = new CardService(cardRepository,emailService);
        service.add("1234",123);
        Mockito.verify(cardRepository).save(captor.capture());
        Card captured = captor.getValue();
        Assertions.assertEquals("1234", captured.getCardnumber());
        Assertions.assertEquals(123, captured.getCode());
    }

    @Test
    void getAll() {
        CardService service = new CardService(cardRepository, emailService);
        Card[] massive = new Card[] {
                new Card("1234", 123),
                new Card("4321", 321)
        };
        Mockito.when(cardRepository.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll().size(), 2);
    }

    @Test
    void getFilteredByCardNumber() {
        CardService service = new CardService(cardRepository, emailService);
        List<String> massive = new ArrayList<String>();
        massive.add("1234");
        massive.add("4321");
        Mockito.when(cardRepository.findAllCardNumbers()).thenReturn(massive);

        Assertions.assertEquals(service.filterByCardNumber(),massive);
    }
    @Test
    void getSortedByCode() {
        CardService service = new CardService(cardRepository, emailService);
        List<Integer> massive = new ArrayList<Integer>();
        massive.add(123);
        massive.add(321);
        Mockito.when(cardRepository.findAllCardCodes()).thenReturn(massive);

        Assertions.assertEquals(service.filterByCode(),massive);
    }

}
