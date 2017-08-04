package com.itss.vn.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestException extends RuntimeException {

    private int code;

    private String message;

    public RestException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public RestException(int code) {
        super();
        this.code = code;
    }

    public RestException(String message) {
        super();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private static final long serialVersionUID = 5679860414840273491L;
}
