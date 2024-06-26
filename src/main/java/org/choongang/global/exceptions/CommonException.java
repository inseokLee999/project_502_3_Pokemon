package org.choongang.global.exceptions;

public class CommonException extends RuntimeException {
    private int status;

    public CommonException(String message){
        super(message);
    }
    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
}
