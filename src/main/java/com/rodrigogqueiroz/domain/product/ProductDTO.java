package com.rodrigogqueiroz.domain.product;

import org.bson.types.ObjectId;

public record ProductDTO(String title, String ownerId, ObjectId categoryId, Integer price, String description) {

}
