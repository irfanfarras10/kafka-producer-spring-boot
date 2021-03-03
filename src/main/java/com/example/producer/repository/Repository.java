package com.example.producer.repository;

import com.example.producer.model.Id;
import com.example.producer.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Product, Id> {

}
