package com.example.task11;

import com.example.task11.Services.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private EmailService service;
    @Test
    public void sendEmail() {
        service.sendMessage("markuysa.study@mail.ru", "testing", "test successful");
    }
}
