package com.eugeniojava.wishlistservice.wishlist.application.service.exception;

public class ProductNotInWishlistException extends RuntimeException {
    public ProductNotInWishlistException(String message) {
        super(message);
    }
}
