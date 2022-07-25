package com.eugeniojava.wishlistservice.wishlist.domain;

import com.eugeniojava.wishlistservice.common.annotation.Factory;
import java.util.List;

@Factory
class CommonWishlistFactory implements WishlistFactory {
    @Override
    public Wishlist create(String id, String customerId, List<Product> products) {
        return new CommonWishlist(id, customerId, products);
    }
}
