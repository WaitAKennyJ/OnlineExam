package Action;

import Dao.QuestionaireDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by kennywzj on 2018/6/30.
 */
public class TakeExamAction extends ActionSupport {
    public int ExamID;
    public String ExamName;

    public void setExamName(String examName) {
        ExamName = examName;
    }

    public int getExamID() {
        return ExamID;
    }

    public void setExamID(int examID) {
        ExamID = examID;
    }

    public String execute(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        QuestionaireDao qDao = new QuestionaireDao();
        Map<String,String> map = qDao.getQuestionID(ExamID);
        String ChoiceID = map.get("ChoiceID");
        String BlankID = map.get("BlankID");
        String[] ChoiceList = ChoiceID.split(",");
        String[] BlankList = BlankID.split(",");
        session.put("ChoiceList",ChoiceList);
        session.put("BlankList",BlankList);
        session.put("QName",ExamName);
        return SUCCESS;
    }
}
