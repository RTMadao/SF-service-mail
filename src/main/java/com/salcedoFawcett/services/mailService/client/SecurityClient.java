package com.salcedoFawcett.services.mailService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("auth-service")
public interface SecurityClient {

    @GetMapping("/security/generate_token/{username}")
    public ResponseEntity<String> generateToken(@PathVariable("username") String username);
}
