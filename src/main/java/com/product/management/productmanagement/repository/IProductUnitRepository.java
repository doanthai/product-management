package com.product.management.productmanagement.repository;

import com.product.management.productmanagement.entity.ProductUnit;
import com.product.management.productmanagement.entity.ProductUnitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductUnitRepository extends JpaRepository<ProductUnit, ProductUnitId> {
}
