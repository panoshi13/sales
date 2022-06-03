package com.example.demo.service;

import com.example.demo.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> listProductos();
    Optional<ProductModel> listarProductosById(Integer id);
    Boolean createProduct(ProductModel ProductModel);
    Boolean updateProduct(Integer id, ProductModel ProductModel);
    Boolean deleteProduct(Integer id);
}
