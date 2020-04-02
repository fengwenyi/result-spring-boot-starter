# result-spring-boot-starter

### 介绍

### 使用步骤

##### 第一步，添加依赖

```xml
<dependency>
    <groupId>com.fengwenyi</groupId>
    <artifactId>result-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### 第二步，注解`@ResponseResult`的使用

可以作用在类上，也可以作用在方法上

```
@RequestMapping("/obj")
@ResponseResult
public User obj() {
    User user = new User();
    user.setS("obj");
    return user;
}
```

#### 第三步，关于异常处理

全局异常处理

```
/**
 * Http Request Method Not Supported
 * HttpRequestMethodNotSupportedException
 * @return {@link ErrorResult}
 */
@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
public ResultException httpRequestMethodNotSupportException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
    return new ResultException("Http Request Method Not Supported");
}
```
