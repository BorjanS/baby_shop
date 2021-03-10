package com.baby_shop.baby_shop.presentation.controller;

import com.baby_shop.baby_shop.model.Role;
import com.baby_shop.baby_shop.model.User;
import com.baby_shop.baby_shop.repository.RoleRepository;
import com.baby_shop.baby_shop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping(path = "")
    public String grandRoles(Model model){
        Role admin = roleRepository.findById(1).orElseThrow();
        Role user = roleRepository.findById(2).orElseThrow();

        User borjan = userRepository.findById("borjan").orElseThrow();
        User martin = userRepository.findById("martin").orElseThrow();

        borjan.setRoles((List<Role>) admin);
        martin.setRoles((List<Role>) user);

        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "Users";
    }
}
