package com.huhu.springbootdemo.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huhu.springbootdemo.data.enums.ReturnCode;
import com.huhu.springbootdemo.data.model.ResultData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof String){
            return objectMapper.writeValueAsString(ResultData.success(o));
        }

        if(o instanceof ResultData){
            return o;
        }

        return ResultData.success(o);
    }


    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> validatedBindException(BindException e) {
        //log.error("全局异常信息 ex={}", e.getMessage(), e);

        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = e.getFieldError();
        String message = "[" + e.getAllErrors().get(0).getDefaultMessage()+"]";

        return ResultData.fail(ReturnCode.RC205.getCode(),message);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleException(NoHandlerFoundException e){
        return ResultData.fail(ReturnCode.RC404.getCode(),"不支持" + e.getRequestURL()+"请求");
    }

    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        //log.error("全局异常信息 ex={}", e.getMessage(), e);

        return ResultData.fail(ReturnCode.RC500.getCode(),e.getMessage());
    }

}
