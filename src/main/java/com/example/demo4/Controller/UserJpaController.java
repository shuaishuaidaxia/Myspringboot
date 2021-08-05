package com.example.demo4.Controller;

import com.example.demo4.Service.UserServiceJpa;
import com.example.demo4.po.UserRoledao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
public class UserJpaController {
    @Resource
    UserServiceJpa userServiceJpa;

    @GetMapping("userjpa/getalluserrole")
    @ResponseBody
    public List<UserRoledao> getAllUserRole(){
        return  userServiceJpa.getAllUserRole();
    }
}
