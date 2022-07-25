package com.eugeniojava.wishlistservice.wishlist.application.service;

import com.eugeniojava.wishlistservice.common.annotation.UseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.IsProductInWishlistUseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.ExistsByCustomerIdAndProductsIdPort;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
class IsProductInWishlistService implements IsProductInWishlistUseCase {
    private final ExistsByCustomerIdAndProductsIdPort existsByCustomerIdAndProductsIdPort;

    @Override
    public boolean execute(String customerId, String productId) {
        return existsByCustomerIdAndProductsIdPort.existsByCustomerIdAndProductsId(customerId, productId);
    }
}
