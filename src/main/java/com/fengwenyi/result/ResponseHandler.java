package com.fengwenyi.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fengwenyi.api_result.helper.ResultHelper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Erwin Feng
 * @since 2020/4/2 5:18 下午
 */
@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        ResponseResult jsonResponseResult = (ResponseResult) request.getAttribute(ConstantConfig.KEY_JSON_RESPONSE_RESULT_ANN);
        return jsonResponseResult != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String
        if (body instanceof String) {
            serverHttpResponse.getHeaders().setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE));
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString(ResultHelper.success("Success", body));
            } catch (JsonProcessingException e) {
                return ResultHelper.error("Object to Json String Exception : " + e.getMessage());
            }
        }
        // exception
        if (body instanceof ResultException) {
            ResultException resultException = (ResultException) body;
            return ResultHelper.error(resultException.getMessage());
        }
        return ResultHelper.success("Success", body);
    }
}
