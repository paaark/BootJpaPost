package com.example.demo.common.error.code;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_TITLE(400, "P004001", "제목을 입력해주세요."),
    INVALID_CONTENT(400, "P004002", "내용을 입력해주세요."),
    POST_NOT_FOUND(400, "P004003", "해당 게시글이 없습니다.");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
