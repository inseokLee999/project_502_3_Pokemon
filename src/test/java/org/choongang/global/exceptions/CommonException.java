package org.choongang.global.exceptions;

public class CommonException extends RuntimeException {

    private int status; // 응답 코드

    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }

}
