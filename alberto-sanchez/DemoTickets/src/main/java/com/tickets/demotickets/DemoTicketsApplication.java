package com.tickets.demotickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTicketsApplication.class, args);
    }

}
