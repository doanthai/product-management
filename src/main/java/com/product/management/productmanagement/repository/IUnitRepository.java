package com.product.management.productmanagement.repository;

import com.product.management.productmanagement.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnitRepository extends JpaRepository<Unit, Integer> {
}
