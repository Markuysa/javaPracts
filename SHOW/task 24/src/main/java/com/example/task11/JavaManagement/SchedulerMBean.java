package com.example.task11.JavaManagement;


import com.example.task11.Services.SchedulerService;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;


import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class SchedulerMBean {
   public void registerMBean() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
       MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
       ObjectName name = new ObjectName("com.example.task11.Services:type=SchedulerService");
       SchedulerService mbean = new SchedulerService();
       mbs.registerMBean(mbean, name);
   }
}