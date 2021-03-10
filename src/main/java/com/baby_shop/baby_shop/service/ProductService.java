package com.baby_shop.baby_shop.service;

import com.baby_shop.baby_shop.model.CartItem;
import com.baby_shop.baby_shop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
//    List<Product> findAllByManufacturerId(Long manufacturerId);
//    List<Product> findAllSortedByPrice(boolean asc);
    Product findById(int id);
    List<CartItem> findAllByShoppingCart(int shoppingCartId);
//    Product saveProduct(String name, Float price, Integer quantity, Long manufacturerId);
//    Product saveProduct(Product product, MultipartFile image) throws IOException;
//    Product updateProduct(Long id, Product product, MultipartFile image) throws IOException;
//    void deleteById(int id);
}
