package com.example.demo4.Service;

import com.example.demo4.dao.UserRepository;
import com.example.demo4.po.UserJpa;
import com.example.demo4.po.UserRoledao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/*jpaService层*/

@Service
public class UserServiceJpa {
    @Resource
    UserRepository userRepository;
    /**
     * 返回所有用户及其角色
     * @return list<UserRoledao>
     */
    public List<UserRoledao> getAllUserRole(){
        return userRepository.findViewInfo();
    }

    public Integer deleteuserbyid(Integer id){
        return userRepository.testdeletebyid(id);
    }
    @Transactional
    public UserJpa adduser(UserJpa user) throws Exception  {


        return userRepository.save(user);
    }

}
