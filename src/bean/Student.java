package bean;

import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

/**
 * Created by kennywzj on 2018/6/26.
 */
public class Student {

    private String SNO="";
    private String Name="";
    private String Pwd="";
    private String Sex="";
    private String Major="";
    private String Classes="";
    private String Email="";
    private String Mobiles="";


    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getClasses() {
        return Classes;
    }

    public void setClasses(String classes) {
        Classes = classes;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobiles() {
        return Mobiles;
    }

    public void setMobiles(String mobiles) {
        Mobiles = mobiles;
    }


    public Student getSelf(){return this;}
    @Override
    public String toString() {
        return "SNO:"+SNO+"\nName:"+Name+"\nSex:"+Sex+"\nMajor:"+Major+"\nClasses:"+Classes+"\nEmail:"+Email+"\nMobile:"+Mobiles;
    }
}
