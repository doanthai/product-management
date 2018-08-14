package com.product.management.productmanagement.service;

import com.product.management.productmanagement.entity.ILog;

import java.sql.Timestamp;
import java.util.Collection;

public interface ILogService<D, K extends String, E extends ILog> {
    Collection<D> loadAll();
    void addLog(D object);
    Collection<D> fetchByTime(Timestamp startTime, Timestamp endTime);
}
