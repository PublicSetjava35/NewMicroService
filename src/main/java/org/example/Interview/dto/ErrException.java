package org.example.Interview.dto;

public class ErrException {
     private Integer status;
     private String typeError;

     public ErrException(Integer status, String typeError) {
         this.status = status;
         this.typeError = typeError;
     }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTypeError() {
        return typeError;
    }

    public void setTypeError(String typeError) {
        this.typeError = typeError;
    }
}