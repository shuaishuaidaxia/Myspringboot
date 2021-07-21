package com.example.demo4.Controller;

import com.example.demo4.Service.UserService;
import com.example.demo4.exceptions.ParamsException;
import com.example.demo4.po.User;
import com.example.demo4.query.UserQuery;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@Api(tags = "用户管理模块")
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("user/name/{userName}")
    @ResponseBody
    @ApiOperation(value = "通过用户查询用户对象")
    @ApiImplicitParam(name = "userName",value = "用户名称",required = true,paramType = "path")
    public User queryUserByName(@PathVariable String userName)
    {
        return userService.queryUserByName(userName);
    }


    @GetMapping("user/byid")
    @ResponseBody
    @Cacheable(value = "users",key = "#userId")
    @ApiOperation(value = "通过id查询用户对象")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true,paramType = "path")
    public User queryUserById(@RequestParam Integer userId)
    { System.out.println("根据id查aaaa");
      return userService.querUserById(userId);

    }

    @PostMapping("user/adduser")
    @ResponseBody
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user",value = "用户",required = true,paramType = "from")
    public Map<String,Object>addUser(@RequestBody User user)
    {
        Map<String,Object>map=new HashMap<>();
//        try {
//               userService.addUser(user);
//               map.put("code",200);
//               map.put("msg","添加用户成功！");
//        }catch (ParamsException p)
//        {
//            map.put("code",p.getCode());
//            map.put("msg",p.getMsg());
//            p.printStackTrace();
//        }catch (Exception e)
//        {
//            map.put("code",500);
//            map.put("msg","添加用户失败!");
//            e.printStackTrace();
//        }
        userService.addUser(user);
        User adduser=userService.queryUserByName(user.getName());
        map.put("code",200);
        map.put("msg","添加用户成功！");
        map.put("data",adduser);
        return map;
    }
    @PutMapping("user/update")
    @ResponseBody
    @CachePut(value = "users",key = "#user.id")
    @ApiOperation(value = "修改用户")
    @ApiImplicitParam(name = "user",value = "用户",required = true,paramType = "from")
    public Map<String,Object>updateUser(@RequestBody User user)
    {
        Map<String,Object>map=new HashMap<>();
//        try {
//            userService.updateUser(user);
//            map.put("code",200);
//            map.put("msg","修改用户成功！");
//        }catch (ParamsException p)
//        {
//            map.put("code",p.getCode());
//            map.put("msg",p.getMsg());
//            p.printStackTrace();
//        }catch (Exception e)
//        {
//            map.put("code",500);
//            map.put("msg","修改用户失败!");
//            e.printStackTrace();
//        }
        userService.updateUser(user);
        map.put("code",200);
        map.put("msg","修改成功!");
        map.put("data",user);
        return map;
    }

    @PostMapping("user/delete")
    @ResponseBody
    @CacheEvict(value = "users",key = "#userId")//删除记录后 同步缓存
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "userId",value = "用户Id",required = true,paramType = "path")
    public Map<String,Object>deleteUser(@RequestParam Integer userId)
    {
        Map<String,Object>map=new HashMap<>();
//        try {
//            userService.deleteUser(userId);
//            map.put("code",200);
//            map.put("msg","删除用户成功！");
//        }catch (ParamsException p)
//        {
//            map.put("code",p.getCode());
//            map.put("msg",p.getMsg());
//            p.printStackTrace();
//        }catch (Exception e)
//        {
//            map.put("code",500);
//            map.put("msg","删除用户失败!");
//            e.printStackTrace();
//        }
        userService.deleteUser(userId);
        map.put("code",200);
        map.put("msg","删除成功!");
        map.put("data",userId);
        return map;
    }

    /**
     * 分页条件查询
     * @param userQuery
     * @return
     */
    @GetMapping("user/list")
    @ResponseBody
    //@Cacheable(value = "users",key = "#userQuery.pageSize+'-'+#userQuery.pageNum+'-'+#userQuery.userName")
    @ApiOperation(value = "分页条件查询")
    @ApiImplicitParam(name = "userQuery",value = "用户查询对象",paramType = "path")
    public PageInfo<User>queryUserBypage(UserQuery userQuery)
    {
        return userService.queryUserByparams(userQuery);
    }

    /**
     * 验证数据
     * @param user
     * @return
     */
    @PostMapping("user02")
    @ResponseBody
    public Map<String,Object>addUser02(@Valid User user)
    {
        Map<String,Object>map=new HashMap<>();
        userService.addUser(user);
        map.put("code",200);
        map.put("msg","添加用户成功！");
        return map;
    }

    /**
     *
     * 修改后 缓存同步
     * @param user
     * @return
     */
    @PutMapping("user/update02")
    @ResponseBody
    @CachePut(value = "users",key = "#user.id")
    public User updateUser02(@RequestBody User user)
    {
        userService.updateUser(user);
        return user ;
    }
}
