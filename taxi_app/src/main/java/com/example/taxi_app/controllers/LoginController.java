package com.example.taxi_app.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
@RequestMapping("login")
public class LoginController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String loginDomain = System.getenv("USER_SERVICE_DOMAIN");

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Map<String, Object> userMap) {
        String url = String.format("http://%s/login", this.loginDomain);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(userMap, headers);
        ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class);
        return response;
    }
}
