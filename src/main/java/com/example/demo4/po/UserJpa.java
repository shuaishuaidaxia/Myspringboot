package com.example.demo4.po;

import com.example.demo4.utlil.ActionsLogsAuditListener;

import javax.persistence.*;

/*jpa对应的实体表*/
@Entity  //声明类为实体或表
@Table(name = "ta_user")  //声明表名
@EntityListeners({ActionsLogsAuditListener.class})
public class UserJpa {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column
    private  String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserJpa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
