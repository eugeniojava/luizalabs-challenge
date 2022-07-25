package com.eugeniojava.wishlistservice.wishlist.application.port.out;

import com.eugeniojava.wishlistservice.wishlist.domain.Wishlist;

public interface SavePort {
    Wishlist save(Wishlist wishlist);
}
