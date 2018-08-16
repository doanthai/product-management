package com.product.management.productmanagement.repository;

import com.product.management.productmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    int countByProdId(int prodId);
    int countByProdName(String productName);
}
