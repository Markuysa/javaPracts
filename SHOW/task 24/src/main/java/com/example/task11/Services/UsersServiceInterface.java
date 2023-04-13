package com.example.task11.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersServiceInterface extends UserDetailsService {
    boolean addUser(String login, String password);
}
