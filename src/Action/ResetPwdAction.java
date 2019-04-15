package Action;

import Dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/6/28.
 */
public class ResetPwdAction extends ActionSupport{
    private String SNO;
    private String Pwd;

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String execute(){
        StudentDao sDao = new StudentDao();
        boolean flag = sDao.ResetPwd(SNO,Pwd);
        if (flag) {
            return SUCCESS;
        }else return ERROR;
    }
}
