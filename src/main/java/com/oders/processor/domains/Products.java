package com.oders.processor.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String productName;
    private int quantity;
    private double price;
    private int status;

    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;
}
