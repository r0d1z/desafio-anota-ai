package com.rodrigogqueiroz.repositories;

import com.rodrigogqueiroz.domain.product.Product;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheMongoRepository<Product> {

}
