package com.personal.e_commerce_api.models;

import jakarta.persistence.*;
import lombok.Data;

// Representa um usuário da aplicação e é mapeada como uma entidade no banco de dados;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ShoppingCart shoppingCart;

}
