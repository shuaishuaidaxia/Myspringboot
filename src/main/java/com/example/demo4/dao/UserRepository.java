package com.example.demo4.dao;

import com.example.demo4.po.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*Jpa对应的dao层*/

@Repository
public interface UserRepository extends JpaRepository<UserJpa,Integer> {


}
