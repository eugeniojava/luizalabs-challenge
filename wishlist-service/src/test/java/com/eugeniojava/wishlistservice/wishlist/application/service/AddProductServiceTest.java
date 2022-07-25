//package com.eugeniojava.wishlistservice.wishlist.application.service;
//
//import com.eugeniojava.wishlistservice.wishlist.application.port.out.FindByCustomerIdPort;
//import com.eugeniojava.wishlistservice.wishlist.application.port.out.SavePort;
//import com.eugeniojava.wishlistservice.wishlist.domain.WishlistFactory;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//class AddProductServiceTest {
//    @Mock
//    private FindByCustomerIdPort findByCustomerIdPort;
//
//    @Mock
//    private SavePort savePort;
//
//    @Mock
//    private WishlistFactory wishlistFactory;
//
//    @InjectMocks
//    private AddProductService addProductService;
//
//    @Test
//    void executeShouldAddProductToWishlistWhenTheWishlistAlreadyExistsAndListOfProductsIsNull() {
//        final var customerId = "customer1";
//        final var wishlist = wishlistFactory.create(
//            null,
//            customerId,
//            null
//        );
//        given(findByCustomerIdPort.findByCustomerId(customerId)).willReturn(Optional.of(wishlist));
//        final var productId = "product1";
//
//        addProductService.execute(customerId, productId);
//
//        assertEquals(1, wishlist.getProducts().size());
//    }
//}
