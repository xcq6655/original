package com.xcq.original;

import com.xcq.original.entity.User;
import com.xcq.original.mapper.UserMapper;
import com.xcq.original.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OriginalApplicationTests {

    @Autowired
    private IUserService userServiceImp;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User xcq = userMapper.selectUserByUsername("xcq").get(0);
        System.out.println(xcq.toString());

    }


}
