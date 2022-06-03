package com.example.demo.service;

import com.example.demo.model.BrandModel;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<BrandModel> ListBrands();
    Optional<BrandModel> ListBrandsById(Integer id);
    Boolean createBrand(BrandModel categoryModel);
    Boolean updateBrand(Integer id, BrandModel categoryModel);
    Boolean deleteBrand(Integer id);
}
