package com.example.demo4.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 此类为工具类 主要是为了分页查询
 */
@ApiModel
public class UserQuery {
    /**
     * 分页参数
     */
    @ApiModelProperty(value = "当前页")
   private Integer pageNum=1;//当前页 默认为1
    @ApiModelProperty(value = "每页条数")
    private  Integer pageSize=5;//每页多少条数据 默认5
    /**
     * 查询条件
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;//查询参数 用户名

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
