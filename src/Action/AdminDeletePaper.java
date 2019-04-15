package Action;

import Dao.QuestionaireDao;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/3.
 */
public class AdminDeletePaper extends ActionSupport {
    public int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public String execute(){
        QuestionaireDao qDao = new QuestionaireDao();
        boolean flag = qDao.deleteQuestionaire(ID);
        if (flag){
            return SUCCESS;
        }
        return ERROR;
    }
}
