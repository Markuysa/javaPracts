package com.example.task11;

import com.example.task11.JavaManagement.SchedulerMBean;
import com.example.task11.Services.SchedulerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.*;
import java.lang.management.ManagementFactory;

@SpringBootApplication
public class Task16Application {
	public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.example.task11.Services:type=SchedulerService");
		SchedulerService mbean = new SchedulerService();
		mbs.registerMBean(mbean, name);
		SpringApplication.run(Task16Application.class, args);
	}

}

