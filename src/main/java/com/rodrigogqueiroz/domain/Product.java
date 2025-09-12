package com.rodrigogqueiroz.domain;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@MongoEntity(collection = "products")
public class Product {

    private ObjectId id;
    private String title;
    private String ownerId;
    private Category category;
    private Integer price;
    private String description;

}
