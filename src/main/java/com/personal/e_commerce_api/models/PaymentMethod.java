package com.personal.e_commerce_api.models;

import jakarta.persistence.*;
import lombok.Data;

// Representa um método específico de pagamento associado à uma compra feita por um usuário;

@Data
@Entity
@Table(name = "payment_method")
public class PaymentMethod implements Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String details;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDetails() {
        return details;
    }

}
