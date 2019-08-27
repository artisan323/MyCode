package Work3;

public class User {
    private String userName;
    private String passWorld;
    private int userAge;
    private String userSex;
    private String e_mail;



    public User(){

    }

    public User(String userName, String passWorld, int userAge, String userSex, String e_mail) {
        this.userName = userName;
        this.passWorld = passWorld;
        this.userAge = userAge;
        this.userSex = userSex;
        this.e_mail = e_mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }


    public String toString() {
        return "User{" +
                "用户名='" + userName + '\'' +
                ", 密码='" + passWorld + '\'' +
                ", 年龄=" + userAge +
                ", 性别='" + userSex + '\'' +
                ", 邮箱='" + e_mail + '\'' +
                '}';
    }
}
