package Action;

import Dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by kennywzj on 2018/6/27.
 */
public class SignupAction extends ActionSupport {
    private String SNO;
    private String Email;
    private String Pwd;
    private String RePwd;

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public void setRePwd(String rePwd) {
        RePwd = rePwd;
    }


    public String execute(){
        StudentDao sdao = new StudentDao();
        if(!(Pwd.equals(RePwd))) return ERROR;
        boolean flag = sdao.StudentSignUp(SNO.trim(),Pwd.trim(),Email.trim());
        if (flag) {
            return SUCCESS;
        }
        else return ERROR;
    }


}
