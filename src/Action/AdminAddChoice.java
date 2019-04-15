package Action;

import Dao.QuestionDao;
import bean.ChoiceQuestion;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class AdminAddChoice  extends ActionSupport{
    public String Question;
    public String EasyLevel;
    public String A;
    public String B;
    public String C;
    public String D;
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

    public void setA(String a) {
        A = a;
    }

    public void setB(String b) {
        B = b;
    }

    public void setC(String c) {
        C = c;
    }

    public void setD(String d) {
        D = d;
    }

    public void setResult(String result) {
        Result = result;
    }


    public String execute(){
        ChoiceQuestion cq = new ChoiceQuestion();
        cq.setEasyLevel(EasyLevel.trim());
        cq.setSubject(Subject.trim());
        cq.setResult(Result.trim());
        cq.setA(A.trim());
        cq.setB(B.trim());
        cq.setC(C.trim());
        cq.setD(D.trim());
        cq.setQuestion(Question.trim());
        QuestionDao questionDao = new QuestionDao();
        boolean flag = questionDao.addChoice(cq);
        if (flag) {
            return SUCCESS;
        }
        return ERROR;
    }
}
