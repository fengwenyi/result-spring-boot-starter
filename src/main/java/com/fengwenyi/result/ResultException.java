package com.fengwenyi.result;

/**
 * 异常结果
 * @author Erwin Feng
 * @since 2020/4/2
 */
public class ResultException {

    /** 异常信息 */
    private String message;

    /**
     * 无参构造方法
     */
    public ResultException() {
    }

    /**
     * 构造方法
     * @param message message
     */
    public ResultException(String message) {
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
     * @return {@link ResultException}
     */
    public ResultException setMessage(String message) {
        this.message = message;
        return this;
    }
}
