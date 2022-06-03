package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class BrandModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", nullable = false,unique = true)
    private Integer id;
    @Column(name = "brand_name")
    private String brandName;

}
