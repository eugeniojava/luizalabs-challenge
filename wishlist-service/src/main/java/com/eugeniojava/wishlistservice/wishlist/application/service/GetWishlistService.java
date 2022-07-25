package com.eugeniojava.wishlistservice.wishlist.application.service;

import com.eugeniojava.wishlistservice.common.annotation.UseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.GetWishlistUseCase;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.dto.GetWishlistResponse;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.FindByCustomerIdPort;
import com.eugeniojava.wishlistservice.wishlist.application.service.exception.WishlistNotFoundException;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
class GetWishlistService implements GetWishlistUseCase {
    private final FindByCustomerIdPort findByCustomerIdPort;

    @Override
    public GetWishlistResponse execute(String customerId) {
        var wishlist = findByCustomerIdPort.findByCustomerId(customerId)
            .orElseThrow(() -> new WishlistNotFoundException("Wishlist not found for customer with ID " + customerId));
        return new GetWishlistResponse(wishlist.getId(), wishlist.getCustomerId(), wishlist.getProducts());
    }
}
