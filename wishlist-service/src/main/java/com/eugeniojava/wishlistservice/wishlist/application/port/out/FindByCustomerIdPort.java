package com.eugeniojava.wishlistservice.wishlist.application.port.out;

import com.eugeniojava.wishlistservice.wishlist.domain.Wishlist;
import java.util.Optional;

public interface FindByCustomerIdPort {
    Optional<Wishlist> findByCustomerId(String customerId);
}
