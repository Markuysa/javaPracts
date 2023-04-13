package com.example.task11;


import com.example.task11.Services.SchedulerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class SchedulerServiceTest {

    @Mock
    private SchedulerService service;

    @Test
    public void runScheduler() {
        try {
            service.doScheduledTask();

        }
        catch (IOException ex) {
            System.out.println("Something wrong...");
        }
    }
}
