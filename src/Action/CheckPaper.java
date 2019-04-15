package Action;

import Dao.QuestionaireDao;
import bean.Grades;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/7/4.
 */
public class CheckPaper extends ActionSupport{
    public String[] BlankAnswer;
    public String[] ChoiceAnswer;

    public void setChoiceAnswer(String[] choiceAnswer) {
        this.ChoiceAnswer = choiceAnswer;
    }

    public void setBlankAnswer(String[] blankAnswer) {
        this.BlankAnswer = blankAnswer;
    }

    public String execute(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Grades grades = new Grades();
        String SNO = (String)session.get("SNO");
        String QName = (String)session.get("QName");
        String Major = "软件";

        grades.setMajor(Major);
        grades.setQName(QName.trim());
        grades.setSNO(SNO.trim());

        List<String> choiceAnswer = (List<String>)session.get("choiceAnswer");
        List<String> blankAnswer = (List<String>)session.get("blankAnswer");
        int choiceCount = choiceAnswer.size(); //选择题数量
        int blankCount = blankAnswer.size(); //填空题数量
        int questionCount = choiceCount + blankCount; //总题目数量
        int rightCount = 0;

        for (int i=0; i<choiceCount ; i++){
            if (ChoiceAnswer[i].equalsIgnoreCase(choiceAnswer.get(i))){
                rightCount++;
            }
        }

        for (int i=0; i<blankCount ; i++){
            if (BlankAnswer[i].equals(blankAnswer.get(i))){
                rightCount++;
            }
        }
        int score=(int)((float)rightCount*100/questionCount);
        grades.setScore(String.valueOf(score));
        QuestionaireDao qDao = new QuestionaireDao();
        qDao.addGrades(grades);
        return SUCCESS;
    }
}
