package com.eugeniojava.wishlistservice.wishlist.domain;

import java.util.ArrayList;
import java.util.List;

class CommonWishlist implements Wishlist {
    private final String id;

    private final String customerId;

    private List<Product> products;

    public CommonWishlist(String id, String customerId, List<Product> products) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    @Override
    public void removeProduct(String productId) {
        if (products == null) {
            return;
        }
        products.removeIf(p -> p.id().equals(productId));
    }

    @Override
    public boolean containsProduct(String productId) {
        if (products == null) {
            return false;
        }
        return products.stream()
            .anyMatch(p -> p.id().equals(productId));
    }
}
