package com.srikar.rest.client.reqres;

import com.srikar.rest.client.reqres.client.ReqresClient;
import com.srikar.rest.client.reqres.client.ReqresClientImpl;
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
