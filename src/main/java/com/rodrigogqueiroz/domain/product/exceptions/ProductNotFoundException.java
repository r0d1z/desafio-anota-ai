package com.rodrigogqueiroz.domain.product.exceptions;

import jakarta.ws.rs.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super("Product not found");
    }

}
