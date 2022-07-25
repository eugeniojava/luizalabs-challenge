package com.eugeniojava.wishlistservice.wishlist.domain;

import java.util.List;

public interface Wishlist {
    String getId();

    String getCustomerId();

    List<Product> getProducts();

    void addProduct(Product product);

    void removeProduct(String productId);

    boolean containsProduct(String productId);
}
