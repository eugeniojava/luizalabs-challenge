package com.eugeniojava.wishlistservice.wishlist.adapter.out.persistence;

import com.eugeniojava.wishlistservice.common.annotation.PersistenceAdapter;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.ExistsByCustomerIdAndProductsIdPort;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.FindByCustomerIdPort;
import com.eugeniojava.wishlistservice.wishlist.application.port.out.SavePort;
import com.eugeniojava.wishlistservice.wishlist.domain.Wishlist;
import lombok.AllArgsConstructor;
import java.util.Optional;

@PersistenceAdapter
@AllArgsConstructor
class WishlistPersistence implements ExistsByCustomerIdAndProductsIdPort, FindByCustomerIdPort, SavePort {
    private final WishlistSpringDataMongoRepository wishlistRepository;
    private final WishlistMapper wishlistMapper;

    @Override
    public boolean existsByCustomerIdAndProductsId(String customerId, String productId) {
        return wishlistRepository.existsByCustomerIdAndProductsId(customerId, productId);
    }

    @Override
    public Optional<Wishlist> findByCustomerId(String customerId) {
        return wishlistRepository.findByCustomerId(customerId)
            .map(wishlistMapper::mapToDomainEntity);
    }

    @Override
    public Wishlist save(Wishlist wishlist) {
        var wishlistMongodbDocument = wishlistRepository.save(wishlistMapper.mapToMongodbDocument(wishlist));
        return wishlistMapper.mapToDomainEntity(wishlistMongodbDocument);
    }
}
