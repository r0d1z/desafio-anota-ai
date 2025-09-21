package com.rodrigogqueiroz.domain.product;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
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

    @Override
    public String toString() {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()
                .add("id", this.id.toString())
                .add("title", this.title)
                .add("ownerId", this.ownerId)
                .add("categoryId", this.categoryId.toString())
                .add("price", this.price)
                .add("description", this.description)
                .add("type", "product");

        return jsonBuilder.build().toString();
    }

}
