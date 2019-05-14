package com.srikar.rest.client.reqres.client;

import com.srikar.rest.client.reqres.entities.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReqresClientImpl implements ReqresClient {

    private RestTemplate rest = new RestTemplate();

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0");
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<UserPage> response = rest.exchange("https://reqres.in/api/users?page={page_num}",
                HttpMethod.GET,
                httpEntity,
                UserPage.class, 1);
        UserPage userPage = response.getBody();
        int nextUserPage = userPage.getPage() + 1;
        int totalPages = userPage.getTotal_pages();
        allUsers.addAll(userPage.getData());
        for(int i = nextUserPage; i <= totalPages; i++){
            response = rest.exchange("https://reqres.in/api/users?page={i}",
                    HttpMethod.GET,
                    httpEntity,
                    UserPage.class, i);
            allUsers.addAll(response.getBody().getData());
        }
        return allUsers;
    }

    @Override
    public User getUser(int id) {
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add(HttpHeaders.ACCEPT, "application/json, application/*+json");
        headerMap.add(HttpHeaders.HOST, "reqres.in");
        headerMap.add(HttpHeaders.CONNECTION, "keep-alive");
        headerMap.add(HttpHeaders.USER_AGENT, "Mozilla/5.0");

        HttpEntity<?> httpEntity = new HttpEntity<Object>(headerMap);
        ResponseEntity<UserWrapper> response = rest.exchange("https://reqres.in/api/users/{id}", HttpMethod.GET, httpEntity, UserWrapper.class, id);
        //System.out.println(response);
        return response.getBody().getData();
    }

    @Override
    public User PostUser(User user) {
        user = rest.postForObject("https://reqres.in/api/users/", user, User.class);
        return user;
    }
}
