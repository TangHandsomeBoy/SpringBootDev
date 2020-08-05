package com.itcast.demo.domain;

/**
 * @author tzc
 * @date 2020/3/26 9:47
 */
public class User {
    private Long userId;
    private String userName;
    private String phone;
    private String sex;
    private String address;
    private String password;

    public User() {

    }

    public User(Long userId, String userName, String phone, String sex, String address, String password) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
