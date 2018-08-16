package com.product.management.productmanagement.service;

import com.product.management.productmanagement.exception.support.DuplicateObjectPmException;
import com.product.management.productmanagement.exception.support.NotFoundObjectPmExcpetion;

import java.io.Serializable;
import java.util.Collection;

public interface IAbstractService<E, K extends Serializable> {
    Collection<E> loadAll();
    E getOneByKey(K key) throws NotFoundObjectPmExcpetion;
    E add(E object) throws DuplicateObjectPmException;
    E edit(E object) throws NotFoundObjectPmExcpetion, DuplicateObjectPmException;
    E delete(K key) throws NotFoundObjectPmExcpetion;
}
