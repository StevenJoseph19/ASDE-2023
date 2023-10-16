package com.acme.books.service;

import com.acme.books.model.CustomUser;
import com.acme.books.model.Users;
import com.acme.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = userRepository.findByUsername(username);
        UserDetails user = null;

        if(users != null && users.size() > 0){
            Users u = users.get(0);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            user = new CustomUser(u.getUsername(), u.getPassword(), authorities, u.getId());
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return user;
    }
}
