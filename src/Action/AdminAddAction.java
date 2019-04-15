package Action;

import Dao.AdminDao;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/1.
 */
public class AdminAddAction extends ActionSupport{
    private String SNO;
    private String Name;
    private String Sex;
    private String Major;
    private String Classes;
    private String Email;
    private String Mobiles;
    private String Pwd;

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public void setClasses(String classes) {
        Classes = classes;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setMobiles(String mobiles) {
        Mobiles = mobiles;
    }

    public String execute(){
        Student st = new Student();
        st.setSNO(SNO.trim());
        st.setEmail(Email.trim());
        st.setClasses(Classes.trim());
        st.setSex(Sex.trim());
        st.setMajor(Major.trim());
        st.setMobiles(Mobiles.trim());
        st.setName(Name.trim());
        st.setPwd(Pwd.trim());
        AdminDao adminDao = new AdminDao();
        if (adminDao.AddStudent(st)){
            return SUCCESS;
        }
        return ERROR;
    }
}
