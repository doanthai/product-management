package com.product.management.productmanagement.repository;

import com.product.management.productmanagement.entity.support.ActionLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface IActionLogRepository extends MongoRepository<ActionLog, Integer> {
    List<ActionLog> findByTimeBetween(Timestamp startTime, Timestamp endTime);
}
