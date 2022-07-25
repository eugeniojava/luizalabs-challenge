package com.eugeniojava.wishlistservice.wishlist.application.port.in;

public interface IsProductInWishlistUseCase {
    boolean execute(String customerId, String productId);
}
