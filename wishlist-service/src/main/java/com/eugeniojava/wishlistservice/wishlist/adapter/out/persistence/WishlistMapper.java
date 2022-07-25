package com.eugeniojava.wishlistservice.wishlist.adapter.out.persistence;

import com.eugeniojava.wishlistservice.wishlist.domain.Wishlist;
import com.eugeniojava.wishlistservice.wishlist.domain.WishlistFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class WishlistMapper {
    private final WishlistFactory wishlistFactory;

    public Wishlist mapToDomainEntity(WishlistMongodbDocument wishlistMongodbDocument) {
        return wishlistFactory.create(
            wishlistMongodbDocument.getId(),
            wishlistMongodbDocument.getCustomerId(),
            wishlistMongodbDocument.getProducts()
        );
    }

    public WishlistMongodbDocument mapToMongodbDocument(Wishlist wishlist) {
        return new WishlistMongodbDocument(
            wishlist.getId(),
            wishlist.getCustomerId(),
            wishlist.getProducts()
        );
    }
}
