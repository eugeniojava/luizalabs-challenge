package com.eugeniojava.wishlistservice.wishlist.application.port.in;

public interface AddProductUseCase {
    void execute(String customerId, String productId);
}
