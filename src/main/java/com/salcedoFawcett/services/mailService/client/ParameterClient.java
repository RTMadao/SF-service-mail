package com.salcedoFawcett.services.mailService.client;

import com.salcedoFawcett.services.mailService.domain.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("parameter-service")
public interface ParameterClient {

    @GetMapping("/contact_data/{id}")
    public ResponseEntity<Contact> getContactDataById(@PathVariable("id") int id);

    @GetMapping("/parameter/identification_document_type/get_name/{id}")
    public  ResponseEntity<String> getIdentificationDocumentTypeNameById(@PathVariable("id") int id);
}
