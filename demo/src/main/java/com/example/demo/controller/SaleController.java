package com.example.demo.controller;

import com.example.demo.dto.ResponseDto;
import com.example.demo.model.BrandModel;
import com.example.demo.model.CategoryModel;
import com.example.demo.model.ProductModel;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sales")
public class SaleController {
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final ProductService productService;

    public SaleController(CategoryService categoryService, BrandService brandService, ProductService productService) {
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.productService = productService;
    }

    @GetMapping("/categories")
    public List<CategoryModel> categoryModelList() {
        return categoryService.ListCategories();
    }

    @GetMapping("/categories/{id}")
    public Optional<CategoryModel> categoryModelListById(@PathVariable("id") Integer id) {
        return categoryService.ListCategoriesById(id);
    }

    @DeleteMapping("/categories/{id}/delete")
    public ResponseEntity<ResponseDto> deleteCategory(@PathVariable("id") Integer id) {
        if (categoryService.deleteCategory(id)) {
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResponseDto.error(), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/categories/create")
    public ResponseEntity<ResponseDto> createCategory(@RequestBody CategoryModel categoryModel) {
        categoryService.createCategory(categoryModel);
        return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}/update")
    public ResponseEntity<ResponseDto> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryModel categoryModel) {
        categoryService.updateCategory(id, categoryModel);
        return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
    }

    @GetMapping("/brands")
    public List<BrandModel> BrandModelList() {
        return brandService.ListBrands();
    }

    @GetMapping("/brands/{id}")
    public Optional<BrandModel> BrandModelListById(@PathVariable("id") Integer id) {
        return brandService.ListBrandsById(id);
    }

    @DeleteMapping("/brands/{id}/delete")
    public ResponseEntity<ResponseDto> deleteBrand(@PathVariable("id") Integer id) {
        if (brandService.deleteBrand(id)) {
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/brands/create")
    public ResponseEntity<ResponseDto> createBrand(@RequestBody BrandModel brandModel) {
        if (brandService.createBrand(brandModel)){
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ResponseDto.error(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/brands/{id}/update")
    public ResponseEntity<ResponseDto> updateBrand(@PathVariable("id") Integer id, @RequestBody BrandModel brandModel) {
        if (brandService.updateBrand(id,brandModel)){
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResponseDto.error(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/products")
    public List<ProductModel> productModels(){
        return productService.listProductos();
    }

    @GetMapping("/products/{id}")
    public Optional<ProductModel> productModel(@PathVariable("id") Integer id){
        return productService.listarProductosById(id);
    }

    @DeleteMapping("/products/{id}/delete")
    public ResponseEntity<ResponseDto> deleteProduct(@PathVariable("id") Integer id) {
        if (productService.deleteProduct(id)) {
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/products/create")
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductModel brandModel) {
        if (productService.createProduct(brandModel)){
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ResponseDto.error(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/products/{id}/update")
    public ResponseEntity<ResponseDto> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductModel brandModel) {
        if (productService.updateProduct(id, brandModel)){
            return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResponseDto.error(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
