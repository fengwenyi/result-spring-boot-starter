package com.fengwenyi.result;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 注解，标记返回需要处理
 * 可以用在类和方法上
 * @author Erwin Feng
 * @since 2020/4/2 5:14 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface ResponseResult {

}
