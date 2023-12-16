package dev.carlosezpereira.restwithspringbootandjavaerudio.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String messager;
    private String details;

    public ExceptionResponse(Date timestamp, String messager, String details) {
        this.timestamp = timestamp;
        this.messager = messager;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
