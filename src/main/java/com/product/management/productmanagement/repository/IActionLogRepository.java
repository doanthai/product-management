package com.product.management.productmanagement.repository;

import com.product.management.productmanagement.entity.support.ActionLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActionLogRepository extends MongoRepository<ActionLog, Integer> {
}
