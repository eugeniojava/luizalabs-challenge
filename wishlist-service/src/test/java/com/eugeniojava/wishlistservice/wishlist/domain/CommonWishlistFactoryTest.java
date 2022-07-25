package com.eugeniojava.wishlistservice.wishlist.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CommonWishlistFactoryTest {
    private final WishlistFactory wishlistFactory = new CommonWishlistFactory();

    @Test
    void createShouldReturnAMatchingInstanceOfWishlist() {
        final var id = "1";
        final var customerId = "customerId";
        final var products = List.of(new Product("product1"));

        final var wishlist = wishlistFactory.create(id, customerId, products);

        assertNotNull(wishlist);
        assertEquals(id, wishlist.getId());
        assertEquals(customerId, wishlist.getCustomerId());
        assertEquals(products, wishlist.getProducts());
    }
}
