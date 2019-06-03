package com.xcq.original.service.imp;

import com.xcq.original.entity.User;
import com.xcq.original.mapper.UserMapper;
import com.xcq.original.service.IUserService;
import com.xcq.original.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Object login(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        subject.login(usernamePasswordToken);
        System.out.println("登录成功！");
        System.out.println("用户是否有admin角色： "+subject.hasRole("admin"));
        return ResultUtil.createSuccess("登录成功",null);
    }

    @Override
    public User getUserByName(String name){
        //int a = 1/0;
        List<User> users = userMapper.selectUserByUsername(name);
        return users.get(0);
    }
}
