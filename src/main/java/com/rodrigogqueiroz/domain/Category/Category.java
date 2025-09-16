package com.rodrigogqueiroz.domain.Category;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@MongoEntity(collection = "categories")
public class Category {

    private ObjectId id;
    private String title;
    private String ownerId;
    private String description;

    public Category(CategoryDTO categoryData) {
        this.title = categoryData.title();
        this.ownerId = categoryData.ownerId();
        this.description = categoryData.description();
    }
}
