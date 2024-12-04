package com.personal.e_commerce_api.repositories;

import com.personal.e_commerce_api.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório para a entidade ShoppingCart, responsável por operações de acesso a dados;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
