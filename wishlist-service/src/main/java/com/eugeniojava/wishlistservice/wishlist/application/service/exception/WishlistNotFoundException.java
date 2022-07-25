package com.eugeniojava.wishlistservice.wishlist.application.service.exception;

public class WishlistNotFoundException extends RuntimeException {
    public WishlistNotFoundException(String message) {
        super(message);
    }
}
