package Action;

import Dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by kennywzj on 2018/6/27.
 */
public class LoginAction extends ActionSupport{
    private String SNO="";
    private String Pwd="";

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String execute(){
        if ((SNO.trim().equals(""))||(Pwd.trim().equals(""))) return ERROR;
        StudentDao sdao = new StudentDao();
        boolean flag = sdao.StudentLogin(SNO,Pwd);
        if (flag) {
            return SUCCESS;
        }else return ERROR;
    }
}
