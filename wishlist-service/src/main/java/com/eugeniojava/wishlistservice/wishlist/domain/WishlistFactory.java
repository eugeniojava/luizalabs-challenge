package com.eugeniojava.wishlistservice.wishlist.domain;

import java.util.List;

public interface WishlistFactory {
    Wishlist create(String id, String customerId, List<Product> products);
}
