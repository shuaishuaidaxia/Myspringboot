package com.example.demo4.Service;

import com.example.demo4.dao.UserMapper;
import com.example.demo4.po.User;
import com.example.demo4.query.UserQuery;
import com.example.demo4.utlil.AssertUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

@Service
public class UserService {

        @Resource
    private UserMapper userMapper;

    /**
     * 通过用户名查找用户
     * @param userName
     * @return User
     */
    public User queryUserByName(String userName)
        {
          return   userMapper.queryUserByName(userName);
        }

    /**
     * 通过id查找用户 返回用户
     * @param UserId
     * @return
     */
    public User querUserById(Integer UserId)
    {
        return userMapper.queryUserById(UserId);
    }

    /**
     * 添加用户并检查值是否为空
     * @param user
     */
    public void addUser(User user)
    {
        //判断是否为空
        /*StringUtils.isBlank(str)判断字符串是否为空*/
        //判断用户姓名是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getName()),"用户名不能为空!");
        //判断用户密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()),"用户密码不能为空!");
        //判断用户名是否存在
        User tmp=userMapper.queryUserByName(user.getName());
        AssertUtil.isTrue(tmp!=null,"用户名已存在");
        //判断添加操受影响的行数
        AssertUtil.isTrue(userMapper.addUser(user)<1,"添加失败！");
    }

    /**
     * 修改用户判断校验用户名密码是否为空
     * 判断用户名是否存在
     * 判断受影响的行数
     * @param user
     */
   @Transactional(propagation = Propagation.REQUIRED)/*事务回滚*/
    public void updateUser(User user)
    {
        /*StringUtils.isBlank(str)判断字符串是否为空*/
        AssertUtil.isTrue(user.getId()==null,"数据异常!");
        //判断用户姓名是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getName()),"用户名不能为空!");
        //判断用户密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()),"用户密码不能为空!");
        //判断用户名是否存在
        User tmp=userMapper.queryUserByName(user.getName());
        AssertUtil.isTrue(tmp!=null&&!user.getId().equals(tmp.getId()),"用户名已存在!");
        //判断添加操受影响的行数
        AssertUtil.isTrue(userMapper.updateUser(user)<1,"修改用户失败！");
       /* AssertUtil.isTrue(true,"事务回滚成功!");*/
    }
    /**
     * 删除用户
     * 判断用户id是否存在
     * @param userId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Integer userId)
    {
        /*StringUtils.isBlank(str)判断字符串是否为空*/
        AssertUtil.isTrue(userId==null||userMapper.queryUserById(userId)==null,"删除id不存在!");
        //判断用户名是否存在
        //判断添加操受影响的行数
        AssertUtil.isTrue(userMapper.deleteUser(userId)<1,"删除用户失败！");
    }

    /**
     * 分页查询
     * @param userQuery
     * @return
     */
    public PageInfo<User> queryUserByparams(UserQuery userQuery)
    {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        List<User>userList=userMapper.queryUserByparams(userQuery);
        //开启分页
        PageInfo<User>pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }
}
