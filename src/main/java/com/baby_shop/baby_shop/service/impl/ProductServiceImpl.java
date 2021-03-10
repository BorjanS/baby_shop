package com.baby_shop.baby_shop.service.impl;

import com.baby_shop.baby_shop.model.Cart;
import com.baby_shop.baby_shop.model.CartItem;
import com.baby_shop.baby_shop.model.Product;
import com.baby_shop.baby_shop.model.exceptions.ProductNotFoundException;
import com.baby_shop.baby_shop.model.exceptions.ShoppingCartIsNotActiveException;
import com.baby_shop.baby_shop.repository.CartItemRepository;
import com.baby_shop.baby_shop.repository.CartRepository;
import com.baby_shop.baby_shop.repository.ProductRepository;
import com.baby_shop.baby_shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public ProductServiceImpl(ProductRepository productRepository, CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public List<CartItem> findAllByShoppingCart(int shoppingCartId) {
        Cart shoppingCart = cartRepository.findById(shoppingCartId).orElseThrow(() -> new ShoppingCartIsNotActiveException("aa"));
        if(shoppingCart != null)
        {
            List<CartItem> items = cartItemRepository.findALlByShoppingCart(shoppingCart);
            return items;
        }
        return null;

    }

}
