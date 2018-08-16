package com.product.management.productmanagement.service.support;

import com.product.management.productmanagement.entity.Product;
import com.product.management.productmanagement.entity.support.ActionLog;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.DuplicateObjectPmException;
import com.product.management.productmanagement.exception.support.NotFoundObjectPmExcpetion;
import com.product.management.productmanagement.repository.IProductRepository;
import com.product.management.productmanagement.service.AbstractService;
import com.product.management.productmanagement.service.ILogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService extends AbstractService<Product, Integer> {

    public ProductService(JpaRepository<Product, Integer> jpaRepository, ILogService<ActionLog, String> logRepository) {
        super(jpaRepository, logRepository);
    }

    @Override
    public Collection<Product> loadAll() {
        return getProductRepository().findAll();
    }

    @Override
    public Product getOneByKey(Integer key) throws NotFoundObjectPmExcpetion {
        Optional<Product> productOptional = getProductRepository().findById(key);
        if(!productOptional.isPresent())
            throw new NotFoundObjectPmExcpetion(ExceptionCode.NOT_FOUND_PRODUCT_BY_ID.getCode(),
                    ExceptionCode.NOT_FOUND_PRODUCT_BY_ID.getMessage());
        return mapper.map(productOptional.get(), Product.class);
    }

    @Override
    public Product add(Product object) throws DuplicateObjectPmException {
        checkDuplicateDataInsert(object);
        return save(object);
    }

    private void checkDuplicateDataInsert(Product object) throws DuplicateObjectPmException {
        if(getProductRepository().countByProdId(object.getProdId()) > 0)
            throw new DuplicateObjectPmException(ExceptionCode.PRODUCT_ID_EXISTS.getCode(), ExceptionCode.PRODUCT_ID_EXISTS.getMessage());
        if(getProductRepository().countByProdName(object.getProdName()) > 0)
            throw new DuplicateObjectPmException(ExceptionCode.PRODUCT_NAME_EXISTS.getCode(), ExceptionCode.PRODUCT_NAME_EXISTS.getMessage());
    }

    @Override
    public Product edit(Product object) throws NotFoundObjectPmExcpetion, DuplicateObjectPmException {
        Product productDb = getOneByKey(object.getProdId());
        checkNameDuplicate(productDb,object);
        return save(object);
    }

    private void checkNameDuplicate(Product productDb, Product object) throws DuplicateObjectPmException {
        if(!object.getProdName().equals(productDb.getProdName()) && getProductRepository().countByProdName(object.getProdName()) > 0)
            throw new DuplicateObjectPmException(ExceptionCode.PRODUCT_NAME_EXISTS.getCode(), ExceptionCode.PRODUCT_NAME_EXISTS.getMessage());
    }

    @Override
    public Product delete(Integer key) throws NotFoundObjectPmExcpetion {
        Product product = getOneByKey(key);
        getProductRepository().delete(product);
        return product;
    }

    private Product save(Product product) {
        return getProductRepository().save(product);
    }

    private IProductRepository getProductRepository() { return (IProductRepository) getJpaRepository();}
}
