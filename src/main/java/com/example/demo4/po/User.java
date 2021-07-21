package com.example.demo4.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 数据校验不成功时抛出全局异常为 BindException
 */
/*Serializable 序列化 */
    @ApiModel(value = "用户实体类")//文档api
public class User implements Serializable {
    @ApiModelProperty(value = "用户id",example = "0")
    Integer id;
    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "用户姓名不能为空!")
    String name;
    @NotBlank(message = "用户密码不能为空!")
    @ApiModelProperty(value = "用户密码")
    @Length(min = 4,max = 8,message = "密码长度在4-8位")
    String password;

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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
