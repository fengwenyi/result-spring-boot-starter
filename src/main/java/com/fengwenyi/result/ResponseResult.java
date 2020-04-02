package com.fengwenyi.result;

import java.lang.annotation.*;

/**
 * Ann，标记返回需要处理
 * @author Erwin Feng
 * @since 2020/4/2 5:14 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface ResponseResult {

}
