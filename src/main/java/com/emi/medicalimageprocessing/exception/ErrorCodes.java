package com.emi.medicalimageprocessing.exception;

public enum ErrorCodes {
    USER_NOT_FOUND(1000),
    USER_NOT_VALID(1001),
    PATIENT_NOT_FOUND(2000),
    ;
    private int code;
    ErrorCodes(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }

}
