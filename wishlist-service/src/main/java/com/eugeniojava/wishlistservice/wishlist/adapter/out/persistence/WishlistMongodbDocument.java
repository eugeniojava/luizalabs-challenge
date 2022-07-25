package com.eugeniojava.wishlistservice.wishlist.adapter.out.persistence;

import com.eugeniojava.wishlistservice.wishlist.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "wishlist")
@AllArgsConstructor
@Getter
@Setter
class WishlistMongodbDocument {
    @Id
    private String id;

    @Indexed(unique = true)
    private String customerId;

    private List<Product> products;
}
