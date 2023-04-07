package com.example.AccesaProject.repository;

import com.example.AccesaProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
