package com.eugeniojava.wishlistservice.wishlist.adapter.in.http.dto;

import com.eugeniojava.wishlistservice.wishlist.application.port.in.dto.GetWishlistResponse;
import com.eugeniojava.wishlistservice.wishlist.domain.Product;
import java.util.List;

public record GetWishlistHttpResponse(String id, String customerId, List<Product> products) {
    public static GetWishlistHttpResponse fromDomain(GetWishlistResponse getWishlistResponse) {
        return new GetWishlistHttpResponse(
            getWishlistResponse.id(),
            getWishlistResponse.customerId(),
            getWishlistResponse.products()
        );
    }
}
