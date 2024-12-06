package com.personal.e_commerce_api.models;

import jakarta.persistence.*;


// Representa um método específico de pagamento associado à uma compra feita por um usuário;

@Entity
@Table(name = "payment_method")
public class PaymentMethod implements Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String details;

    public PaymentMethod() {
    }

    public PaymentMethod(Long id, String type, String details, User user) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
