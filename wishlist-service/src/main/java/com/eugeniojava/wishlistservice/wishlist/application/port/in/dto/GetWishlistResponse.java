package com.eugeniojava.wishlistservice.wishlist.application.port.in.dto;

import com.eugeniojava.wishlistservice.wishlist.domain.Product;
import java.util.List;

public record GetWishlistResponse(String id, String customerId, List<Product> products) {
}
