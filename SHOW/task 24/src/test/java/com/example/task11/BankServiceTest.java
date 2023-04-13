package com.example.task11;


import com.example.task11.Entities.Bank;
import com.example.task11.Repository.BankRepository;
import com.example.task11.Services.BankService;
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

public class BankServiceTest {

    @Captor
    ArgumentCaptor<Bank> captor;

    @Mock
    private BankRepository bankRepository;
    @Mock
    private EmailService emailService;

    @Test
    void addBank() {

        BankService service = new BankService(bankRepository, emailService);
        service.add("Tinkoff","Jupiter");
        Mockito.verify(bankRepository).save(captor.capture());
        Bank captured = captor.getValue();
        Assertions.assertEquals("Tinkoff", captured.getName());
        Assertions.assertEquals("Jupiter", captured.getAddress());
    }

    @Test
    void getAll() {
        BankService service = new BankService(bankRepository, emailService);
        Bank[] massive = new Bank[] {
                new Bank("Tinkoff", "Jupiter"),
                new Bank("Otrkytie", "Venera")
        };
        Mockito.when(bankRepository.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll().size(), 2);
    }

    @Test
    void getFilteredByName() {
        BankService service = new BankService(bankRepository, emailService);
        List<String> massive = new ArrayList<String>();
        massive.add("Tinkoff");
        massive.add("Otrkytie");
        Mockito.when(bankRepository.findAllBankNames()).thenReturn(massive);

        Assertions.assertEquals(service.filterByName(),massive);
    }
    @Test
    void getSortedByAddress() {
        BankService service = new BankService(bankRepository, emailService);
        List<String> massive = new ArrayList<String>();
        massive.add("Jupiter");
        massive.add("Venera");
        Mockito.when(bankRepository.findAllBankAddresses()).thenReturn(massive);

        Assertions.assertEquals(service.filterByAddress(),massive);
    }

}
