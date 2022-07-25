package com.eugeniojava.wishlistservice.wishlist.adapter.in.http;

import com.eugeniojava.wishlistservice.common.annotation.HttpAdapter;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.AddProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@HttpAdapter(path = "/api/wishlists")
@AllArgsConstructor
class AddProductController {
    private final AddProductUseCase addProductUseCase;

    @PostMapping("/customer/{customerId}/product/{productId}")
    public void execute(
        @PathVariable("customerId") String customerId,
        @PathVariable("productId") String productId
    ) {
        addProductUseCase.execute(customerId, productId);
    }
}
