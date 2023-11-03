package com.mycompany.conference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.conference.model.User;

import javax.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserRepository userRepository;


//    @Override
//    @Transactional
    public User save(User user) {
		return null;

//        return userRepository.save(user);
    }

}
