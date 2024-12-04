package com.personal.e_commerce_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Representa um produto na aplicação e é mapeada como uma entidade no banco de dados;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String category;

    @ManyToMany(mappedBy = "product")
    private List<ShoppingCart> shoppingCart;

}
