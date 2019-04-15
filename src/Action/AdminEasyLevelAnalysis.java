package Action;

import Dao.QuestionaireDao;
import bean.BlankQuestion;
import bean.ChoiceQuestion;
import bean.PaperEasyLevel;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/7/4.
 */
public class AdminEasyLevelAnalysis extends ActionSupport {
    public String execute() {
        QuestionaireDao qDao = new QuestionaireDao();
        List<Questionaire> listP = qDao.AllQuestionaire();
        List<PaperEasyLevel> levelPaper = new ArrayList<>();
        int level=0;
        int count=0;
        for (Questionaire paper : listP){
            List<ChoiceQuestion> choiceQuestions = qDao.getChoiceQuestion(paper.getChoiceID().trim().split(","));
            List<BlankQuestion> blankQuestions = qDao.getBlankQuestion(paper.getBlankID().trim().split(","));
            PaperEasyLevel newPaper = new PaperEasyLevel();
            newPaper.setMajor(paper.getMajor().trim());
            newPaper.setQName(paper.getQName().trim());
            newPaper.setCreator(paper.getCreator().trim());
            newPaper.setID(paper.getID());

            for (ChoiceQuestion choice : choiceQuestions){
                level += Integer.parseInt(choice.getEasyLevel().trim());
                count++;
            }

            for (BlankQuestion blank : blankQuestions){
                level += Integer.parseInt(blank.getEasyLevel().trim());
                count++;
            }
            newPaper.setEasyLevel((int)((double)level/(double)count));
            newPaper.setLevel((double)level/(double)count);
            levelPaper.add(newPaper);
        }

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("levelPaper",levelPaper);
        return SUCCESS;
    }
}