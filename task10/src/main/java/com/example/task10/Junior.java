package com.example.tasks.tenthTask;

import org.springframework.stereotype.Component;

@Component("Junior")
public class Junior implements com.example.tasks.tenthTask.Programmer {
    @Override
    public void doCoding() {
        System.out.println("junior's coding");
    }
}
