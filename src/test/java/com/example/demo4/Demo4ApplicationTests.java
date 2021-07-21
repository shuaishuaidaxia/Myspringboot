package com.example.demo4;

import com.example.Demo4Application;
import com.example.demo4.Service.UserService;
import com.example.demo4.po.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Demo4Application.class})
class Demo4ApplicationTests {
     @Resource
    private UserService userService;

    /**
     * 单元测试前执行
     */
    @Before
     public void before()
     {
         System.out.println("单元测试前执行");
     }
    /**
     * 单元测试
     *
     */
    @Test
    public void testQueryUserById()
     {
         User user=userService.querUserById(3);
         System.out.println(user);
     }
   @Test
   public void testQueryUserByName()
   {
       User user=userService.queryUserByName("ss");
       System.out.println(user.toString());
   }
     @After
     public void after()
     {
         System.out.println("单元测试后执行");
     }

}
