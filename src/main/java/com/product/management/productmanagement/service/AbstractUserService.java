package com.product.management.productmanagement.service;

import com.product.management.productmanagement.entity.support.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public abstract class AbstractUserService<E, K extends Serializable> extends AbstractService<E, K> {
    public AbstractUserService(JpaRepository<E, K> jpaRepository, ILogService<ActionLog, String> logRepository) {
        super(jpaRepository, logRepository);
    }
}
