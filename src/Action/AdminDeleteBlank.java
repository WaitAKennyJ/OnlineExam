package Action;

import Dao.QuestionDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class AdminDeleteBlank extends ActionSupport {
    public int ID;

    public String execute(){
        QuestionDao questionDao = new QuestionDao();
        boolean flag = questionDao.deleteBlank(ID);
        if (flag) {
            return SUCCESS;
        }
        return ERROR;
    }
}
