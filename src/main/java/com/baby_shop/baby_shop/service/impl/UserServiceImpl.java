package com.baby_shop.baby_shop.service.impl;

import com.baby_shop.baby_shop.model.User;
import com.baby_shop.baby_shop.model.exceptions.UserAlreadyExistsException;
import com.baby_shop.baby_shop.model.exceptions.UserNotFoundException;
import com.baby_shop.baby_shop.repository.UserRepository;
import com.baby_shop.baby_shop.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User registerUser(User user) {
        if (this.userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistsException(user.getUsername());
        }
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) this.userRepository.findById(s)
                .orElseThrow(() -> new UsernameNotFoundException(s));
    }


}
