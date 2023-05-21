package com.smartagilify.baseinfo.exception;

public enum ExceptionMessageEnum {
    BASE_INFO_NOT_FOUND("base info not found."),
    PARENT_NOT_FOUND("parent not found.")
    ;

    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
