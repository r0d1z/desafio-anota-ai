package com.rodrigogqueiroz.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.rodrigogqueiroz.domain.Category.Category;
import com.rodrigogqueiroz.domain.Category.CategoryDTO;
import com.rodrigogqueiroz.repositories.CategoryRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.rodrigogqueiroz.domain.Category.exceptions.CategoryNotFoundException;

@ApplicationScoped
public class CategoryService {

    @Inject
    private CategoryRepository repository;

    public Category insert(CategoryDTO categoryData) {
        Category category = new Category(categoryData);
        this.repository.persist(category);
        return category;
    }

    public List<Category> retrieveAllFromOwner(ObjectId ownerID) {
        return this.repository.find("ownerId", ownerID).list();
    }

    public Category retrieveById(ObjectId id) {
        return this.repository.findById(id);
    }   

    public List<Category> retrieveAll() {
        return this.repository.listAll();
    }

    public Category update(ObjectId id, CategoryDTO categoryData) {
        Category category = this.repository.findById(id);

        if (category == null) {
            throw new CategoryNotFoundException();
        }

        if (!categoryData.title().isEmpty())
            category.setTitle(categoryData.title());

        if (!categoryData.description().isEmpty())
            category.setDescription(categoryData.description());

        this.repository.persist(category);
        return category;
    }

    public void delete(ObjectId id) {

        Category category = this.repository.findById(id);

        if (category == null) {
            throw new CategoryNotFoundException();
        }

        this.repository.deleteById(id);
    }
}
