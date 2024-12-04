package com.personal.e_commerce_api.repositories;

import com.personal.e_commerce_api.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositório para a entidade PaymentMethod, responsável por operações de acesso a dados;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
