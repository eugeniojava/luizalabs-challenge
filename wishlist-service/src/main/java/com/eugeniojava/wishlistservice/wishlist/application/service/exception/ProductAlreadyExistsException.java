package com.eugeniojava.wishlistservice.wishlist.application.service.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
