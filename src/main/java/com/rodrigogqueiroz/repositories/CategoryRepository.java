package com.rodrigogqueiroz.repositories;

import com.rodrigogqueiroz.domain.Category.Category;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheMongoRepository<Category> {

}
