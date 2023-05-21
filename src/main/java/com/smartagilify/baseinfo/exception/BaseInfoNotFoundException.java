package com.smartagilify.baseinfo.exception;

public class BaseInfoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BaseInfoNotFoundException() {
        super(ExceptionMessageEnum.BASE_INFO_NOT_FOUND.getMessage());
    }
}
