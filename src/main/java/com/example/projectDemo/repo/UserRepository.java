package com.example.projectDemo.repo;

import com.example.projectDemo.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersModel,Integer> {
    Optional<UsersModel> findByLoginAndPassword(String login,String password);
}
