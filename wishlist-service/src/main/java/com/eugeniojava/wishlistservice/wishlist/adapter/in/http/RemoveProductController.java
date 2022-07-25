package com.eugeniojava.wishlistservice.wishlist.adapter.in.http;

import com.eugeniojava.wishlistservice.common.annotation.HttpAdapter;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.RemoveProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@HttpAdapter(path = "/api/wishlists")
@AllArgsConstructor
class RemoveProductController {
    private final RemoveProductUseCase removeProductUseCase;

    @DeleteMapping("/customer/{customerId}/product/{productId}")
    public void execute(
        @PathVariable("customerId") String customerId,
        @PathVariable("productId") String productId
    ) {
        removeProductUseCase.execute(customerId, productId);
    }
}
