package com.product.management.productmanagement.service;

import com.product.management.productmanagement.entity.ILog;

import java.sql.Timestamp;
import java.util.Collection;

public interface ILogService<E extends ILog, K extends String> {
    Collection<E> loadAll();
    void addLog(E object);
    void addLog(String username, String message, String type);
    Collection<E> fetchByTime(Timestamp startTime, Timestamp endTime);
}
