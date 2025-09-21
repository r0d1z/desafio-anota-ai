package com.rodrigogqueiroz.domain.product;

import org.bson.types.ObjectId;

import com.rodrigogqueiroz.domain.Category.Category;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection = "products")
public class Product {

    private ObjectId id;
    private String title;
    private String ownerId;
    private ObjectId categoryId;
    private Integer price;
    private String description;

    public Product(ProductDTO productData) {
        this.title = productData.title();
        this.ownerId = productData.ownerId();
        this.price = productData.price();
        this.description = productData.description();
        this.categoryId = productData.categoryId();
    }

}
