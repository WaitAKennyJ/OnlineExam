package Action;

import Dao.QuestionDao;
import bean.BlankQuestion;
import bean.ChoiceQuestion;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class AdminAddBlank extends ActionSupport{
    public String Question;
    public String EasyLevel;
    public String Result;
    public String Subject;

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setEasyLevel(String easyLevel) {
        EasyLevel = easyLevel;
    }



    public void setResult(String result) {
        Result = result;
    }


    public String execute(){
        BlankQuestion bq = new BlankQuestion();
        bq.setEasyLevel(EasyLevel.trim());
        bq.setSubject(Subject.trim());
        bq.setResult(Result.trim());
        bq.setQuestion(Question.trim());
        QuestionDao questionDao = new QuestionDao();
        boolean flag = questionDao.addBlank(bq);
        if (flag) {
            return SUCCESS;
        }
        return ERROR;
    }
}
