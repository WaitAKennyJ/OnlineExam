package Action;

import Dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/1.
 */
public class AdminDeleteAction extends ActionSupport{
    private String SNO;

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String execute(){
        AdminDao aDao = new AdminDao();
        aDao.DeleteStudent(SNO.trim());
        return SUCCESS;
    }
}
