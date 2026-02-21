package com.guigosandri.demo.repositories;


import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.springframework.Repository;

import com.guigosandri.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    
} 