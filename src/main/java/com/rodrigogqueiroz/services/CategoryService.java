package com.rodrigogqueiroz.services;

import java.util.List;

import com.rodrigogqueiroz.domain.Category;
import com.rodrigogqueiroz.domain.CategoryDTO;
import com.rodrigogqueiroz.repositories.CategoryRepository;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category category = new Category(categoryData);
        this.repository.persist(category);
        return category;
    }

    public List<Category> retrieveAllFromOwner(String ownerID) {
        return this.repository.find("ownerId", ownerID).list();
    }

    public List<Category> retrieveAll() {
        return this.repository.listAll();
    }
}
