package com.xcq.original.exception;

import com.xcq.original.utils.ResultUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public Object errorHandler(IncorrectCredentialsException ex) {
        return ResultUtil.createFail(3,"密码错误",ex.getMessage());
    }


    @ExceptionHandler(value = AuthenticationException.class)
    public Object errorHandler(AuthenticationException ex) {
        return ResultUtil.createFail(2,"该用户名没有注册",ex.toString());
    }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception ex) {
        return ResultUtil.createFail(100,"操作失败",ex.toString());
    }

}


