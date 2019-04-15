package Action;

import Dao.QuestionDao;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class AdminDeleteChoice extends ActionSupport {
    public int ID;

    public String execute(){
        QuestionDao questionDao = new QuestionDao();
        boolean flag = questionDao.deleteChoice(ID);
        if (flag) {
            return SUCCESS;
        }
        return ERROR;
    }
}
