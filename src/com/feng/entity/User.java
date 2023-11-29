package com.feng.entity;

/**
 * 用户信息类
 */
public class User {
    private String id;//用户id
    private String name;//用户名
    private String password;//用户密码
    private String sex;//用户性别
    private String birthday;//生日
    private String idenity_code;//扩展字段
    private String email;//电子邮箱
    private String mobile;//联系电话
    private String address;//地址
    private int status;//用户状态 1||2（管理员）

    public User() {
    }

    public User(String id, String name, String password, String sex, String birthday, String idenity_code, String email, String mobile, String address, int status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.idenity_code = idenity_code;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdenity_code() {
        return idenity_code;
    }

    public void setIdenity_code(String idenity_code) {
        this.idenity_code = idenity_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
