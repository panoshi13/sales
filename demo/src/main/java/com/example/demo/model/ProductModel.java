package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false,unique = true)
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryId;
    @OneToOne
    @JoinColumn(name = "brand_id")
    private BrandModel brandId;
    @Column(name = "model_year")
    private Integer modelYear;
    @Column(name = "list_price")
    private Double price;
}
