package com.example.demo4.po;

/*多表查询关联表User+Role spring会自动代理此接口返回数据*/
public interface  UserRoledao {
 Integer getId();
 String getName();
 String getPassword();
 String getRolename();
}
