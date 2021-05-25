package com.example.demo.common.error.exception;

import com.example.demo.common.error.code.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

}
