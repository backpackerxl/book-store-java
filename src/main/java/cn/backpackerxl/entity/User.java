package cn.backpackerxl.entity;


/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: User
 **/

public class User {
    private int id;
    private String name;
    private String passwd;
    private String email;
    private String phone;
    private String info;
    private String userImg;
    private double userMoney;

    public User() {
    }

    public User(int id, String name, String passwd, String email, String phone, String info, String userImg, double userMoney) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.email = email;
        this.phone = phone;
        this.info = info;
        this.userImg = userImg;
        this.userMoney = userMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        this.userMoney = userMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userMoney=" + userMoney +
                '}';
    }
}
