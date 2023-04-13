package com.example.task11.Repository;

import com.example.task11.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u where u.login=?1")
    User findUserByName(String name);
}
