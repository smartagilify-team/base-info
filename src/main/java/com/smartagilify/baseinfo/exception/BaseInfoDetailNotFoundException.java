package com.smartagilify.baseinfo.exception;

public class BaseInfoDetailNotFoundException extends RuntimeException {

    public BaseInfoDetailNotFoundException() {
        super(ExceptionMessageEnum.PARENT_NOT_FOUND.getMessage());
    }
}
