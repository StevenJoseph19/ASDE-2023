package com.acme.books.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {

    private String getUsername() {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((User)principle).getUsername();
    }
}
