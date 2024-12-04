package com.personal.e_commerce_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Representa uma lista com produtos e é mapeada como uma entidade no banco de dados;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_cart")
@Data
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Double total;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user; // representa o usuário dono do carrinho de compras;

    @ManyToMany
    @JoinTable(
            name = "shopping_cart_product",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product; // representa uma lista de produtos que estão no carrinho de compras;
}
