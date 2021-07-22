package com.example.demo4;

import com.example.demo4.dao.UserRepository;
import com.example.demo4.po.UserJpa;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserRepository userRepository;

    @Before //单元测试之前执行
    public void before(){
        System.out.println("UserjpadaoTest测试开始");
    }

    @Test
    public void testadd(){
        UserJpa userJpa=new UserJpa();
        userJpa.setName("userjpa01");
        userJpa.setPassword("123456");
        userRepository.save(userJpa);
    }

    @Test
    public void testLocate(){
        Optional<UserJpa> userJpaOptional = userRepository.findById(77);
        if (userJpaOptional.isPresent()){
             UserJpa userJpa=userJpaOptional.get();
            System.out.println(userJpa.toString());
        }
    }
}
