package com.eugeniojava.wishlistservice.wishlist.application.port.in;

import com.eugeniojava.wishlistservice.wishlist.application.port.in.dto.GetWishlistResponse;

public interface GetWishlistUseCase {
    GetWishlistResponse execute(String customerId);
}
