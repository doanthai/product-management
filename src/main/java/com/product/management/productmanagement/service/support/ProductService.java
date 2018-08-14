package com.product.management.productmanagement.service.support;

import com.product.management.productmanagement.dto.ActionLogDto;
import com.product.management.productmanagement.dto.ProductDto;
import com.product.management.productmanagement.entity.Product;
import com.product.management.productmanagement.entity.support.ActionLog;
import com.product.management.productmanagement.repository.IProductRepository;
import com.product.management.productmanagement.service.AbstractService;
import com.product.management.productmanagement.service.ILogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class ProductService extends AbstractService<ProductDto, Integer, Product> {

    public ProductService(JpaRepository<Product, Integer> jpaRepository, ILogService<ActionLogDto, String, ActionLog> logRepository) {
        super(jpaRepository, logRepository);
    }

    @Override
    public Collection<ProductDto> loadAll() {
        return null;
    }

    @Override
    public ProductDto getOneByKey(Integer key) {
        return null;
    }

    @Override
    public ProductDto add(ProductDto object) {
        return null;
    }

    @Override
    public ProductDto edit(ProductDto object) {
        return null;
    }

    @Override
    public ProductDto delete(ProductDto object) {
        return null;
    }

    private IProductRepository getProductRepository() { return (IProductRepository) getJpaRepository();}
}
