package com.rodrigogqueiroz.repositories;

import com.rodrigogqueiroz.domain.Product;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProductRepository extends PanacheMongoRepository<Product> {

}
