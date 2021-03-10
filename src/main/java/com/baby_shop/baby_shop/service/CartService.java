package com.baby_shop.baby_shop.service;

import com.baby_shop.baby_shop.model.Cart;
import com.baby_shop.baby_shop.model.CartItem;
import com.baby_shop.baby_shop.model.dto.ChargeRequest;

import java.util.List;

public interface CartService {

//    Cart findActiveShoppingCartByUsername(String userId);

    List<Cart> findAllByUsername(String userId);

    Cart createNewShoppingCart(String userId);

    Cart findById(int shoppingCartId);
    CartItem addProductToShoppingCart(String userId, int productId);

    List<CartItem>  removeProductFromShoppingCart(String userId, int productId);

    Cart createShoppingCart(String userId);

    Cart checkoutShoppingCartStripe(String userId, ChargeRequest chargeRequest);

    Cart cancelActiveShoppingCart(String userId);

    Cart checkoutShoppingCart(String userId);

    Float getFullPrice(int shoppingCartId);

    List<CartItem> findShoppingCartItems(int shoppingCartId);

    Cart getActiveShoppingCartOrCreateOne(String userId);
}
