package com.baby_shop.baby_shop.service;

import com.baby_shop.baby_shop.model.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    User signUpUser(String username, String password, String repeatedPassword);

}
