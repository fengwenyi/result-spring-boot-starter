package com.fengwenyi.result;

/**
 * 错误返回
 * @author Erwin Feng
 * @since 2020/4/2
 */
public class ErrorResult {

    /** 错误信息 */
    private String message;

    /**
     * 构造方法
     * @param message message
     */
    public ErrorResult(String message) {
        this.message = message;
    }

    /**
     * get message
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * set message
     * @param message message
     * @return {@link ErrorResult}
     */
    public ErrorResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
