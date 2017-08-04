package com.itss.vn.common.model;

import com.itss.vn.common.constant.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String message;
    private T value;

    public CommonResponse<T> successfulRespone(T value) {
        this.resultCode = Constants.RESULT_CODE_SUCCESS;
        this.message = Constants.MESSAGE_SUCCESS;
        this.value = value;

        return this;
    }

    public CommonResponse<T> failedRespone(T value) {
        this.resultCode = Constants.RESULT_CODE_FAIL;
        this.message = Constants.MESSAGE_FAIL;
        this.value = value;

        return this;
    }

    public CommonResponse<T> failedRespone(T value, String messageError) {
        this.resultCode = Constants.RESULT_CODE_FAIL;
        this.message = messageError;
        this.value = value;

        return this;
    }
}
