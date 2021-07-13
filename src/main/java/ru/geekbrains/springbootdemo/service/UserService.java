package ru.geekbrains.springbootdemo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.geekbrains.springbootdemo.entities.SystemUser;
import ru.geekbrains.springbootdemo.entities.User;

public interface UserService extends UserDetailsService {
    User findByUsername(String userName);
    void save(SystemUser systemUser);
}
