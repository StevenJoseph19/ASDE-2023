package com.mycompany.conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.conference.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.age = :age")
//    List<User> getUserByAge(int age);

    @Query(value = "SELECT * FROM CONF_USERS u WHERE u.age = :age", nativeQuery = true)
    List<User> getUserByAge(int age);
}