package com.eugeniojava.wishlistservice.wishlist.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
interface WishlistSpringDataMongoRepository extends MongoRepository<WishlistMongodbDocument, String> {
    boolean existsByCustomerIdAndProductsId(String customerId, String productId);

    Optional<WishlistMongodbDocument> findByCustomerId(String customerId);
}
