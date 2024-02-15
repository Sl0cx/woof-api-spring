package com.m2i.woof.service;

import org.springframework.security.core.Authentication;
import com.m2i.woof.model.User;

public interface UserService {
    String login(Authentication authentication);
    User inscription(User user);
}
