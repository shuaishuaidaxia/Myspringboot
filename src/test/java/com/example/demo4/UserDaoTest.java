package com.example.demo4;

import com.example.demo4.dao.UserRepository;
import com.example.demo4.po.UserJpa;
import com.example.demo4.po.UserRoledao;
import net.sf.ehcache.search.Direction;
import org.apache.tomcat.jni.Directory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
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
        userJpa.setName("userjpa06");
        userJpa.setPassword("123456");
        userRepository.save(userJpa);
    }
    @Test
    public void testbyname(){
        UserJpa userJpa=new UserJpa();
        userJpa.setName("userjpa02");
       UserJpa a = userRepository.findByName(userJpa.getName());
        System.out.println(userRepository.findByName(userJpa.getName()));
    }
    @Test
    public void testfindtestbyname(){
        UserJpa userJpa=new UserJpa();
        userJpa.setName("dgd");
        System.out.println(userRepository.findtestbyname(userJpa.getName()));
    }
    @Test
    public void deletebyid(){
        UserJpa userJpa = new UserJpa();
        userJpa.setId(31);
        userRepository.delete(userJpa);
        System.out.println("ddddd");
    }
    @Test
    public void pagefind() throws Exception{
      int page=1,size=10;
        Sort.Order oder = new Sort.Order(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(page,size,Sort.by(oder));
      Page<UserJpa> istt= userRepository.findAll(pageable);
        System.out.println(istt.getContent());
    }
    @Test
    public void pagefindbyname() throws Exception{
        int page=0,size=10;
        Sort.Order oder = new Sort.Order(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(page,size,Sort.by(oder));
        Page<UserJpa> istt= userRepository.findByName("dadadas",pageable);
        System.out.println(istt.getContent());
    }

    @Test
    public void getuserrole() throws Exception{
       List<UserRoledao> list=   userRepository.findViewInfo();
       for (UserRoledao roledao :list){
           System.out.println(roledao.getId()+" name:"+roledao.getName()+" password:"+roledao.getPassword()+" role:"+roledao.getRolename());
       }

    }
    @Test
    public void testLocate(){
        Optional<UserJpa> userJpaOptional = userRepository.findById(77);
        if (userJpaOptional.isPresent()){
             UserJpa userJpa=userJpaOptional.get();
            System.out.println(userJpa.toString());
        }
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testEM(){
     UserJpa userJpa = entityManager.find(UserJpa.class,57);
        System.out.println(userJpa.toString());
    }
}
