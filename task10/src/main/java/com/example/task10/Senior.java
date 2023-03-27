package com.example.tasks.tenthTask;

import org.springframework.stereotype.Component;

@Component("Senior")
public class Senior implements com.example.tasks.tenthTask.Programmer {
    @Override
    public void doCoding() {
        System.out.println("senior's coding");
    }
}
