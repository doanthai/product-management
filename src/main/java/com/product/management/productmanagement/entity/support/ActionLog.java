package com.product.management.productmanagement.entity.support;

import com.product.management.productmanagement.entity.ILog;

import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

public class ActionLog extends ILog {

    @Id
    private String id;
    // username or system
    private String principal;
    private Timestamp time;
    private String message;
    private String type;

    public ActionLog() {
    }

    public ActionLog(String id, String principal, Timestamp time, String message, String type) {
        this.id = id;
        this.principal = principal;
        this.time = time;
        this.message = message;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionLog actionLog = (ActionLog) o;
        return Objects.equals(id, actionLog.id) &&
                Objects.equals(principal, actionLog.principal) &&
                Objects.equals(time, actionLog.time) &&
                Objects.equals(message, actionLog.message) &&
                Objects.equals(type, actionLog.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, principal, time, message, type);
    }

    @Override
    public String toString() {
        return String.format("ActionLog[ id='%s', principal='%s', time='%tD', message='%s', type='%s']",
                id,principal,time,message,type);
    }
}
