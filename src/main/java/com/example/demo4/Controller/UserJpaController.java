package com.example.demo4.Controller;

import com.example.demo4.Service.UserServiceJpa;
import com.example.demo4.po.UserJpa;
import com.example.demo4.po.UserRoledao;
import com.example.demo4.utlil.PermissionsAnnotation;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
public class UserJpaController {
    @Resource
    UserServiceJpa userServiceJpa;

    @GetMapping("userjpa/getalluserrole")
    @ResponseBody
    //@PermissionsAnnotation()
    public List<UserRoledao> getAllUserRole(){
        return  userServiceJpa.getAllUserRole();
    }
    @PostMapping("userjpa/deleteuser")
    @ResponseBody
    public Map<String,Object> deleteuser(@RequestParam Integer id){
     Integer u =  userServiceJpa.deleteuserbyid(id);
        Map<String,Object> MSG = new HashMap<>();
        MSG.put("msg",200);
        MSG.put("userid",id );
        return MSG;
    }
    @PostMapping("userjpa/adduser")
    @ResponseBody
    public Map<String,Object> adduser(@RequestBody UserJpa userJpa)throws Exception{
        UserJpa u =  userServiceJpa.adduser(userJpa);
        Map<String,Object> MSG = new HashMap<>();
        MSG.put("code",200);
        MSG.put("msg","添加成功!");
        MSG.put("userid",u );
        return MSG;
    }
}
