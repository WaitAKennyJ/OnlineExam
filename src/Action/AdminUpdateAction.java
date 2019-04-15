package Action;

import Dao.StudentDao;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/7/1.
 */
public class AdminUpdateAction extends ActionSupport{
    private String SNO="";
    private String Name="";
    private String Pwd="";
    private String Sex="";
    private String Major="";
    private String Classes="";
    private String Email="";
    private String Mobiles="";

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
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
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Student st = new Student();
        st.setName(Name.trim());
        st.setSex(Sex.trim());
        st.setMobiles(Mobiles.trim());
        st.setMajor(Major.trim());
        st.setClasses(Classes.trim());
        st.setSNO(SNO.trim());
        st.setEmail(Email.trim());
        st.setPwd(Pwd.trim());
        session.put("AdminUpdateSt",st);
        return SUCCESS;
    }


}
