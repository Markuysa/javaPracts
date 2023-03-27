package com.example.tasks.tenthTask;

import org.springframework.stereotype.Component;

@Component("Middle")
public class Middle implements com.example.tasks.tenthTask.Programmer {
    @Override
    public void doCoding() {
        System.out.println("middle's coding");
    }
}
