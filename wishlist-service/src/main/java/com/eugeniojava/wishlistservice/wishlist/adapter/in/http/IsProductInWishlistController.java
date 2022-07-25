package com.eugeniojava.wishlistservice.wishlist.adapter.in.http;

import com.eugeniojava.wishlistservice.common.annotation.HttpAdapter;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.IsProductInWishlistUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@HttpAdapter(path = "/api/wishlists")
@AllArgsConstructor
class IsProductInWishlistController {
    private final IsProductInWishlistUseCase isProductInWishlistUseCase;

    @GetMapping("/customer/{customerId}/product/{productId}")
    public ResponseEntity<Void> execute(
        @PathVariable("customerId") String customerId,
        @PathVariable("productId") String productId
    ) {
        if (isProductInWishlistUseCase.execute(customerId, productId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
