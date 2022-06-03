package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class CategoryModel implements Serializable {
    private static final long serialVersionUID = -274414352968552715L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false,unique = true)
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;

}
