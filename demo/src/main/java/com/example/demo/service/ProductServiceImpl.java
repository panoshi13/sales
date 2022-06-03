package com.example.demo.service;

import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> listProductos() {
        return productRepository.listarProductos();
    }

    @Override
    public Optional<ProductModel> listarProductosById(Integer id) {
        return productRepository.listarProductosById(id);
    }

    @Override
    public Boolean createProduct(ProductModel productModel) {
        try {
            productRepository.insertProduct(productModel.getProductName(),
                    productModel.getBrandId().getId(),
                    productModel.getCategoryId().getId(),
                    productModel.getModelYear(),
                    productModel.getPrice());
            return true;
        } catch (Exception exception) {
            log.info(exception.getMessage());
            return false;
        }

    }

    @Override
    public Boolean updateProduct(Integer id, ProductModel productModel) {
        try {
            var productData = productRepository.listarProductosById(id).get();
            productData.setProductName(productModel.getProductName());
            productData.setBrandId(productModel.getBrandId());
            productData.setPrice(productModel.getPrice());
            productData.setModelYear(productModel.getModelYear());
            productRepository.updateProduct(id,
                    productData.getProductName(),
                    productData.getBrandId().getId(),
                    productData.getCategoryId().getId(),
                    productData.getModelYear(),
                    productData.getPrice());
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

    @Override
    public Boolean deleteProduct(Integer id) {
        try {
            productRepository.deleteProductById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
