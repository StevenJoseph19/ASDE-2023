package com.acme.books.repository;

import com.acme.books.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    List<Users> findByUsername(String username);
}
