package com.baby_shop.baby_shop.service;

import com.baby_shop.baby_shop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findById(String userId);
    User registerUser(User user);
}
