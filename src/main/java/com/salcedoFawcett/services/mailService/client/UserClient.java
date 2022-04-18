package com.salcedoFawcett.services.mailService.client;

import com.salcedoFawcett.services.mailService.domain.model.SecureUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/get_by_name/{username}")
    public  ResponseEntity<SecureUser> getUserByusername(@PathVariable("username") String username);
}
