package com.product.management.productmanagement.service;

import com.product.management.productmanagement.dto.request.CurrentUser;
import com.product.management.productmanagement.entity.support.ActionLog;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.MapKeyColumn;
import java.io.Serializable;

@Getter
public abstract class AbstractService<E, K extends Serializable> implements IAbstractService<E, K>  {

    protected final JpaRepository<E, K> jpaRepository;
    protected final ModelMapper mapper = new ModelMapper();
    protected final ILogService<ActionLog, String> logRepository;

    public AbstractService(JpaRepository<E, K> jpaRepository,ILogService<ActionLog, String> logRepository) {
        this.jpaRepository = jpaRepository;
        this.logRepository = logRepository;
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    public CurrentUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (CurrentUser) authentication.getPrincipal();
    }
}
