package com.example.producer.controller;

import com.example.producer.model.Id;
import com.example.producer.model.Product;
import com.example.producer.repository.Repository;
import com.example.producer.service.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1")
public class Controller {

    @Autowired
    private Repository repository;
    @Autowired
    private KafkaProducer producer;

    @GetMapping("product")
    public ResponseEntity<String> get(@RequestParam String storeId, @RequestParam String skuSeller) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = repository.findById(new Id(storeId, skuSeller)).get();
        product.setCreatedDate(product.getCreatedDate().toString());
        product.setCreatedDate(product.getCreatedDate().toString());
        String message = objectMapper.writeValueAsString(product);
        producer.send(message);
        return ResponseEntity.ok("Message Received: " + message);
    }

}
