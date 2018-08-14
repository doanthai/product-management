package com.product.management.productmanagement.service;

import java.io.Serializable;
import java.util.Collection;

public interface IAbstractService<D, K extends Serializable> {
    Collection<D> loadAll();
    D getOneByKey(K key);
    D add(D object);
    D edit(D object);
    D delete(D object);
}
