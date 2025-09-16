package com.rodrigogqueiroz.domain.product;

import org.bson.types.ObjectId;

public record ProductDTO(String title, ObjectId ownerId, ObjectId categoryId, Integer price, String description) {

}
