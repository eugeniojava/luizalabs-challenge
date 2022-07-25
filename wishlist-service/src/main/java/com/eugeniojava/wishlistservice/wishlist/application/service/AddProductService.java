package com.eugeniojava.wishlistservice.wishlist.application.service;

import com.eugeniojava.wishlistservice.common.annotation.UseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.AddProductUseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.FindByCustomerIdPort;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.SavePort;
import com.eugeniojava.wishlistservice.wishlist.application.service.exception.ProductAlreadyExistsException;
import com.eugeniojava.wishlistservice.wishlist.application.service.exception.WishlistIsFullException;
import com.eugeniojava.wishlistservice.wishlist.domain.Product;
import com.eugeniojava.wishlistservice.wishlist.domain.Wishlist;
import com.eugeniojava.wishlistservice.wishlist.domain.WishlistFactory;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@AllArgsConstructor
class AddProductService implements AddProductUseCase {
    private static final int WISHLIST_MAX_SIZE = 20;
    private final FindByCustomerIdPort findByCustomerIdPort;
    private final SavePort savePort;
    private final WishlistFactory wishlistFactory;

    @Transactional
    @Override
    public void execute(String customerId, String productId) {
        var wishlist = getWishlistOrCreateByCustomerId(customerId);
        checkSize(wishlist);
        checkIfProductAlreadyExists(wishlist, productId);
        wishlist.addProduct(new Product(productId));
        savePort.save(wishlist);
    }

    private Wishlist getWishlistOrCreateByCustomerId(String customerId) {
        return findByCustomerIdPort.findByCustomerId(customerId)
            .orElseGet(() -> createWishlistWithCustomerId(customerId));
    }

    private Wishlist createWishlistWithCustomerId(String customerId) {
        return savePort.save(wishlistFactory.create(null, customerId, null));
    }

    private void checkIfProductAlreadyExists(Wishlist wishlist, String productId) {
        if (wishlist.containsProduct(productId)) {
            throw new ProductAlreadyExistsException("Product already exists in wishlist");
        }
    }

    private void checkSize(Wishlist wishlist) {
        if (wishlist.getProducts() != null && wishlist.getProducts().size() >= WISHLIST_MAX_SIZE) {
            throw new WishlistIsFullException("Wishlist is full");
        }
    }
}
