package com.srikar.rest.client.reqres;

import client.ReqresClient;
import client.ReqresClientImpl;
import entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReqresApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReqresApplication.class, args);
        ReqresClient reqresClient = new ReqresClientImpl();
        System.out.println("All users:");
        System.out.println(reqresClient.getAllUsers());
        System.out.println("User with id: 1");
        System.out.println(reqresClient.getUser(1));
    }
}
