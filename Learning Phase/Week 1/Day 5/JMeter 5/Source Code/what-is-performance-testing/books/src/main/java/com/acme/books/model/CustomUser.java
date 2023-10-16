package com.acme.books.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities, Long id) {
        super(username, password, authorities);
        setId(id);
    }
}
