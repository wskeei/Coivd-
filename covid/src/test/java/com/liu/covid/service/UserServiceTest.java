package com.liu.covid.service;

import com.liu.covid.entity.User;
import com.liu.covid.mapper.UserMapper;
import com.liu.covid.service.UserService;
import com.liu.covid.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserMapper userMapper;

    @Test
    public void testLogin() {
        // 模拟数据
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        List<User> userList = new ArrayList<>();
        User dbUser = new User();
        dbUser.setUsername("testUser");
        // 使用MD5加密模拟密码存储
        dbUser.setPassword(DigestUtils.md5DigestAsHex("testPassword".getBytes()));
        userList.add(dbUser);

        Mockito.when(userMapper.selectList(Mockito.any())).thenReturn(userList);

        // 执行方法
        String result = userService.login(user);

        // 验证结果
        System.out.println("测试 login 方法:");

        // 验证结果不为空
        assert result != null : "登录结果不能为空";

        // 输出结果
        System.out.println("登录结果：" + result);
    }

    @Test
    public void testRegister() {
        // 模拟数据
        User user = new User();
        user.setUsername("newUser");
        user.setPassword("newPassword");

        List<User> userList = new ArrayList<>();
        User existingUser = new User();
        existingUser.setUsername("newUser");
        userList.add(existingUser);

        Mockito.when(userMapper.selectList(Mockito.any())).thenReturn(userList);
        Mockito.when(userMapper.insert(Mockito.any())).thenReturn(1); // 模拟插入成功

        // 执行方法
        String result = userService.register(user);

        // 验证结果
        System.out.println("测试 register 方法:");

        // 验证结果不为空
        assert result != null : "注册结果不能为空";

        // 输出结果
        System.out.println("注册结果：" + result);
    }
}
