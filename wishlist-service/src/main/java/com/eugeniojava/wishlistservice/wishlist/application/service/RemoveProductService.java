package com.eugeniojava.wishlistservice.wishlist.application.service;

import com.eugeniojava.wishlistservice.common.annotation.UseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.RemoveProductUseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.FindByCustomerIdPort;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.SavePort;
import com.eugeniojava.wishlistservice.wishlist.application.service.exception.ProductNotInWishlistException;
import com.eugeniojava.wishlistservice.wishlist.application.service.exception.WishlistNotFoundException;
import com.eugeniojava.wishlistservice.wishlist.domain.Wishlist;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@AllArgsConstructor
class RemoveProductService implements RemoveProductUseCase {
    private final FindByCustomerIdPort findByCustomerIdPort;
    private final SavePort savePort;

    @Transactional
    @Override
    public void execute(String customerId, String productId) {
        var wishlist = getWishlistByCustomerId(customerId);
        checkIfProductExists(wishlist, productId);
        wishlist.removeProduct(productId);
        savePort.save(wishlist);
    }

    private Wishlist getWishlistByCustomerId(String customerId) {
        return findByCustomerIdPort.findByCustomerId(customerId)
            .orElseThrow(() -> new WishlistNotFoundException("Wishlist not found for customer with ID " + customerId));
    }

    private void checkIfProductExists(Wishlist wishlist, String productId) {
        if (!wishlist.containsProduct(productId)) {
            throw new ProductNotInWishlistException("Product not found in wishlist");
        }
    }
}
