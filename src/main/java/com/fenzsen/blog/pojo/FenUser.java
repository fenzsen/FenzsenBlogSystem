package com.fenzsen.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Date: 2020/8/7
 * Description: 用户实体
 */
@Entity     // 数据表实体
@Table(name = "tb_user")    // 映射表名
public class FenUser {

    @Id     // 主键 id
    @Column(name = "id")    // 字段名
    private String id;

    // 用户名
    @Column(name = "user_name")
    private String userName;

    // 密码
    @Column(name = "password")
    private String password;

    // 角色
    @Column(name = "roles")
    private String roles;

    // 头像地址
    @Column(name = "avatar")
    private String avatar;

    // 邮箱
    @Column(name = "email")
    private String email;

    // 签名
    @Column(name = "sign")
    private String sign;

    // 状态(0表示删除，1表示正常)
    @Column(name = "state")
    private String state;

    // 注册ip
    @Column(name = "reg_ip")
    private String regIp;

    // 登录ip
    @Column(name = "login_ip")
    private String loginIp;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;


    // 更新时间
    @Column(name = "update_time")
    private Date updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
