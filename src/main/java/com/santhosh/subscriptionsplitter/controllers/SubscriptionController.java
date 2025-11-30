package com.santhosh.subscriptionsplitter.controllers;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/subscriptions")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SubscriptionController {

    @GetMapping("/test")
    public String testSubscription() {
        return "Subscription API working!";
    }
}

