package com.xcq.original.controller;

import com.xcq.original.entity.User;
import com.xcq.original.service.IUserService;
import com.xcq.original.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userServiceImp;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Object login(User user){
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
//        subject.login(usernamePasswordToken);
//        System.out.println("登录成功！");
//        System.out.println("用户是否有admin角色： "+subject.hasRole("admin"));
//        return ResultUtil.createSuccess("登录成功",null);
        return userServiceImp.login(user);
    }

    @RequestMapping(value = "/xcq",method = RequestMethod.GET)
    public Object xcqTest(String name){
        System.out.println("aaa");
        return userServiceImp.getUserByName(name);
    }
}
