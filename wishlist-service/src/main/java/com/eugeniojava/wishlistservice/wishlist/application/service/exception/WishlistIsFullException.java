package com.eugeniojava.wishlistservice.wishlist.application.service.exception;

public class WishlistIsFullException extends RuntimeException {
    public WishlistIsFullException(String message) {
        super(message);
    }
}
