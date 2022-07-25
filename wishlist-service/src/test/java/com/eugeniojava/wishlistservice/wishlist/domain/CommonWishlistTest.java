package com.eugeniojava.wishlistservice.wishlist.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommonWishlistTest {
    @Test
    void addProductShouldAddProductToWishlistWhenTheListOfProductsIsNull() {
        final var product = new Product("product1");
        final var wishlist = new CommonWishlist("wishlist1", "customer1", null);

        wishlist.addProduct(product);

        assertEquals(List.of(product), wishlist.getProducts());
    }

    @Test
    void addProductShouldAddProductToWishlistWhenThereIsNoProductInTheList() {
        final var product = new Product("product1");
        final var wishlist = new CommonWishlist(
            "wishlist1",
            "customer1",
            new ArrayList<>()
        );

        wishlist.addProduct(product);

        assertEquals(List.of(product), wishlist.getProducts());
    }

    @Test
    void addProductShouldAddProductToWishlistWhenThereIsAlreadyAProductInTheList() {
        final var product1 = new Product("product1");
        final var product2 = new Product("product2");
        final var wishlist = new CommonWishlist(
            "wishlist1",
            "customer1",
            Stream.of(product1).collect(Collectors.toList())
        );

        wishlist.addProduct(product2);

        assertEquals(List.of(product1, product2), wishlist.getProducts());
    }

    @Test
    void removeProductShouldDoNothingWhenTheListOfProductsIsNull() {
        final var wishlist = new CommonWishlist("wishlist1", "customer1", null);

        wishlist.removeProduct("product1");

        assertNull(wishlist.getProducts());
    }

    @Test
    void removeProductShouldDoNothingWhenThereIsNoProductInTheList() {
        final var wishlist = new CommonWishlist("wishlist1", "customer1", new ArrayList<>());

        wishlist.removeProduct("product1");

        assertTrue(wishlist.getProducts().isEmpty());
    }

    @Test
    void removeProductShouldRemoveAProductWhenItIsPresentInTheList() {
        final var product = new Product("product1");
        final var wishlist = new CommonWishlist(
            "wishlist1",
            "customer1",
            Stream.of(product).collect(Collectors.toList())
        );

        wishlist.removeProduct("product1");

        assertTrue(wishlist.getProducts().isEmpty());
    }

    @Test
    void containsProductShouldReturnFalseWhenTheListOfProductsIsNull() {
        final var wishlist = new CommonWishlist("wishlist1", "customer1", null);

        final var result = wishlist.containsProduct("product1");

        assertFalse(result);
    }

    @Test
    void containsProductShouldReturnTrueWhenTheProductIsPresentInTheList() {
        final var product = new Product("product1");
        final var wishlist = new CommonWishlist(
            "wishlist1",
            "customer1",
            Stream.of(product).collect(Collectors.toList())
        );

        final var result = wishlist.containsProduct("product1");

        assertTrue(result);
    }

    @Test
    void containsProductShouldReturnFalseWhenTheProductIsNotPresentInTheList() {
        final var product1 = new Product("product1");
        final var product2 = new Product("product2");
        final var wishlist = new CommonWishlist(
            "wishlist1",
            "customer1",
            Stream.of(product1, product2).collect(Collectors.toList())
        );

        final var result = wishlist.containsProduct("product3");

        assertFalse(result);
    }
}
