package com.example.demo.service;

import com.example.demo.model.BrandModel;
import com.example.demo.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandModel> ListBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<BrandModel> ListBrandsById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public Boolean createBrand(BrandModel brandModel) {
        try {
            brandRepository.save(brandModel);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateBrand(Integer id, BrandModel brandModel) {
        var brandId =  brandRepository.findById(id);
        if (brandId.isPresent()){
            var brand = brandId.get();
            brand.setBrandName(brandModel.getBrandName());
            brandRepository.save(brand);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBrand(Integer id) {
        try{
            brandRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
