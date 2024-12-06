package com.personal.e_commerce_api.models;

import jakarta.persistence.*;


import java.util.List;

// Representa uma lista com produtos e é mapeada como uma entidade no banco de dados;

@Entity
@Table(name = "shopping_cart")

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

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, Integer quantity, Double total, User user, List<Product> product) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
