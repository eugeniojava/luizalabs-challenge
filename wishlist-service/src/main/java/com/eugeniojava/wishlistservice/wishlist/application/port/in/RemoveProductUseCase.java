package com.eugeniojava.wishlistservice.wishlist.application.port.in;

public interface RemoveProductUseCase {
    void execute(String customerId, String productId);
}
