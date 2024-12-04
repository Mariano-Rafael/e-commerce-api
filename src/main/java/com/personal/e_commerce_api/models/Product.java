package com.personal.e_commerce_api.models;

import jakarta.persistence.*;
import lombok.Data;

// Representa um produto na aplicação e é mapeada como uma entidade no banco de dados;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

}
