package com.example.demo4.po;

import com.example.demo4.utlil.ActionsLogsAuditListener;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/*jpa对应的实体表*/
@Entity  //声明类为实体或表
@Table(name = "ta_user")  //声明表名
@SQLDelete(sql="update ta_user set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@EntityListeners({ActionsLogsAuditListener.class})
public class UserJpa {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column
    private  String password;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role role;*/

    @Column
    private  Integer roleid;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_deleted")
    private boolean isDel = false;

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

  /*  public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }*/

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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
