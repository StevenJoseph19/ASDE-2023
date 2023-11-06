package com.mycompany.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mycompany.conference.model.User;
import com.mycompany.conference.service.UserService;

import java.util.List;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname") String firstname,
                        @RequestParam(value = "lastname") String lastname,
                        @RequestParam(value = "age") int age) {
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }
    
    @PostMapping("/user")
    public User postUser(User user) {
    	System.out.println("User firstname: "+ user.getFirstname());
    	
    	userService.save(user);
    	
    	return user;
    }

    @GetMapping("/user/{age}")
    public List<User> getUserByAge(@PathVariable int age ) {


        List<User> userByAge =  userService.getUserByAge(age);

        return userByAge;
    }

}
