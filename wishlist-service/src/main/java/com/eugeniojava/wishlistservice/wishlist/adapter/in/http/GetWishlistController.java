package com.eugeniojava.wishlistservice.wishlist.adapter.in.http;

import com.eugeniojava.wishlistservice.common.annotation.HttpAdapter;
import com.eugeniojava.wishlistservice.wishlist.adapter.in.http.dto.GetWishlistHttpResponse;
import com.eugeniojava.wishlistservice.wishlist.application.port.in.GetWishlistUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@HttpAdapter(path = "/api/wishlists")
@AllArgsConstructor
class GetWishlistController {
    private final GetWishlistUseCase getWishlistUseCase;

    @GetMapping("/customer/{customerId}")
    public GetWishlistHttpResponse execute(@PathVariable("customerId") String customerId) {
        return GetWishlistHttpResponse.fromDomain(getWishlistUseCase.execute(customerId));
    }
}
