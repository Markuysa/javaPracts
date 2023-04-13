package com.example.task11.Services;

import javax.management.DynamicMBean;
import java.io.IOException;

public interface SchedulerServiceInterface extends DynamicMBean {
    void doScheduledTask() throws IOException;}
