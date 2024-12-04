package com.personal.e_commerce_api.repositories;

import com.personal.e_commerce_api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repositório para a entidade Product, responsável por operações de acesso a dados;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    Optional<Product> findByCategory(String category);

}
