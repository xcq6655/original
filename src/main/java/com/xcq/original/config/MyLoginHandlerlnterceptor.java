//package com.xcq.original.config;
//
//import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@Configuration
//public class MyLoginHandlerlnterceptor implements HandlerInterceptor {
//
//    //目标方法执行之前
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        Object loginname = request.getSession().getAttribute("loginname");
////        if(loginname==null||loginname.equals("")){
////            //未登录，返回登陆界面
////            request.setAttribute("msg","没有权限，请先登陆");
////            //返回登陆page并且相应
////            // response.sendRedirect("/index.html");
////            request.getRequestDispatcher("/").forward(request,response);
////            return false;
////        }else {
////            //已经登陆,放行
////            return true;
////        }
//
//        return true;
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
