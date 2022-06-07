package com.salcedoFawcett.services.mailService.client;

import com.salcedoFawcett.services.mailService.domain.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-service")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerPartyById(@PathVariable("id") int id);
}
