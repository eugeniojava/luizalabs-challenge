package com.eugeniojava.wishlistservice.wishlist.application.port.out;

public interface ExistsByCustomerIdAndProductsIdPort {
    boolean existsByCustomerIdAndProductsId(String customerId, String productId);
}
