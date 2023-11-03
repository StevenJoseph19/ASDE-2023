package com.mycompany.conference.service;

import com.mycompany.conference.model.User;

import java.util.List;

public interface UserService {

	User save(User user);


	List<User> getUserByAge(int age);
}