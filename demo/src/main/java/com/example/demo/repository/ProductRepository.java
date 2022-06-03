package com.example.demo.repository;

import com.example.demo.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    @Query(value = "{call sp_select_product}",nativeQuery = true)
    List<ProductModel> listarProductos();

    @Query(value = "{call sp_select_id_product (:id)}",nativeQuery = true)
    Optional<ProductModel> listarProductosById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "{call sp_delete_product (:id)}",nativeQuery = true)
    void deleteProductById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "{call sp_update_product (:product_id,:product_name,:brand_id,:category_id,:año,:precio)}",nativeQuery = true)
    void updateProduct(@Param("product_id") Integer id,
                       @Param("product_name") String productName,
                       @Param("brand_id") Integer brandId,
                       @Param("category_id") Integer categoryId,
                       @Param("año") Integer año,

                       @Param("precio") Double precio);

    @Transactional
    @Modifying
    @Query(value = "{call sp_insert_product (:product_name,:brand_id,:category_id,:año,:precio)}",nativeQuery = true)
    int insertProduct(@Param("product_name") String productName,
                       @Param("brand_id") Integer brandId,
                       @Param("category_id") Integer categoryId,
                       @Param("año") Integer año,
                       @Param("precio") Double precio);
}
