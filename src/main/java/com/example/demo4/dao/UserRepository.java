package com.example.demo4.dao;

import com.example.demo4.po.UserJpa;
import com.example.demo4.po.UserRoledao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*Jpa对应的dao层*/

@Repository
/*<UserJpa,Integer> 实体类 和主键类型*/
public interface UserRepository extends JpaRepository<UserJpa,Integer>{
  UserJpa findByName(String name);

  @Query("select u from UserJpa u where u.name = ?1 ")
  UserJpa findtestbyname(String name);

    @Modifying
    @Transactional
    @Query("delete from UserJpa u where  u.id = ?1 ")
    int testdeletebyid(Integer id);

    @Override
    Page<UserJpa> findAll(Pageable pageable);

    Page<UserJpa> findByName(String name,Pageable pageable);

    @Query(nativeQuery = true,value = "select u.id,u.name,u.password,r.rolename from ta_user as u inner join role as r on u.roleid = r.roleid group by u.id")
    List<UserRoledao> findViewInfo();
}

