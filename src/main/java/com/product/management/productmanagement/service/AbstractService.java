package com.product.management.productmanagement.service;

import com.product.management.productmanagement.dto.ActionLogDto;
import com.product.management.productmanagement.entity.support.ActionLog;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

@Getter
public abstract class AbstractService<D, K extends Serializable, E> implements IAbstractService<D, K>  {

    protected final JpaRepository<E, K> jpaRepository;
    protected final ModelMapper mapper = new ModelMapper();
    protected final ILogService<ActionLogDto, String, ActionLog> logRepository;

    public AbstractService(JpaRepository<E, K> jpaRepository,ILogService<ActionLogDto, String, ActionLog> logRepository) {
        this.jpaRepository = jpaRepository;
        this.logRepository = logRepository;
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }
}
