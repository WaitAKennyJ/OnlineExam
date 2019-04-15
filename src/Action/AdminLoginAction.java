package Action;

import Dao.AdminDao;
import bean.Admin;
import com.opensymphony.xwork2.ActionSupport;

import java.lang.reflect.AccessibleObject;

/**
 * Created by kennywzj on 2018/7/1.
 */
public class AdminLoginAction extends ActionSupport {
    private String Name="";
    private String Pwd="";

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


    public String execute(){
        if ((Name.trim().equals(""))||(Pwd.trim().equals(""))) return ERROR;
        AdminDao adao = new AdminDao();
        boolean flag = adao.AdminLogin(Name,Pwd);
        if (flag) {
            return SUCCESS;
        }else return ERROR;
    }
}
