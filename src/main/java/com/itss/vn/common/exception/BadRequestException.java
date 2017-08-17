package com.itss.vn.common.exception;

import com.itss.vn.common.constant.Errors;

public class BadRequestException extends RestException {

    private static final long serialVersionUID = 6582062068219032459L;

    public BadRequestException() {
        super("BAD_REQUEST");
        this.setCode(Errors.ERROR_BAD_REQUEST_CODE);
    }

    public BadRequestException(String message) {
        super(message);
        this.setCode(Errors.ERROR_BAD_REQUEST_CODE);
    }

}
