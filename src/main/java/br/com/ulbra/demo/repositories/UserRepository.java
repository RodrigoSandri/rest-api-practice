package br.com.ulbra.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ulbra.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}