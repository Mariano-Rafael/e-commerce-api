package com.personal.e_commerce_api.repositories;

import com.personal.e_commerce_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repositório para a entidade User, responsável por operações de acesso a dados;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDocument(String document);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
