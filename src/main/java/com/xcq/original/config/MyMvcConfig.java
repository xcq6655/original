//package com.xcq.original.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//
//    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //springboot1已经做好了静态资源映射了，可以访问到
//        registry.addInterceptor(new MyLoginHandlerlnterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/xcq/login","/css/**","/js/**","/img/**","/webjars/**");
//    }
//}
