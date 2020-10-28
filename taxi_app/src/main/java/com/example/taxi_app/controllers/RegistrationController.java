package com.example.taxi_app.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String registrationDomain = System.getenv("USER_SERVICE_DOMAIN");

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Map<String, Object> userMap) {
        String url = String.format("http://%s/register", this.registrationDomain);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(userMap, headers);
        ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class);
        return response;
    }
}
