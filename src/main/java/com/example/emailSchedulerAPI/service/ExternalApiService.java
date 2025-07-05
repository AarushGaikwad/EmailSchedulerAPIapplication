package com.example.emailSchedulerAPI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String fetchData(){
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
