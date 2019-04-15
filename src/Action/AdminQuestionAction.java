package Action;

import Dao.AdminDao;
import Dao.QuestionDao;
import bean.BlankQuestion;
import bean.ChoiceQuestion;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class AdminQuestionAction extends ActionSupport {
    public int choiceCurr=1;
    public int blankCurr=1;

    public String execute(){
        QuestionDao questionDao = new QuestionDao();
        int choiceCount = questionDao.countChoice();
        int blankCount = questionDao.countBlank();
        int choicePages = 0;
        int blankPages = 0;
        List<ChoiceQuestion> list1 = questionDao.QueryAllC(choiceCurr);
        List<BlankQuestion> list2 = questionDao.QueryAllB(blankCurr);
        if (choiceCount%5 ==0){
            choicePages = choiceCount / 5;
        }else{
            choicePages = choiceCount / 5 +1;
        }

        if (blankCount%5 ==0){
            blankPages = blankCount / 5;
        }else{
            blankPages = blankCount / 5 +1;
        }

        StringBuffer blankSb = new StringBuffer();
        for (int i=1; i <= blankPages; i++){
            if (i==blankCurr){
                blankSb.append("<"+i+">");
            }else {
                blankSb.append("[<a href='Action/adminQuestion.action?blankCurr="+i+"&choiceCurr=1'>"+i+"</a>]");
            }
            blankSb.append("  ");
        }

        StringBuffer choiceSb = new StringBuffer();
        for (int i=1; i <= choicePages; i++){
            if (i==choiceCurr){
                choiceSb.append("<"+i+">");
            }else {
                choiceSb.append("[<a href='Action/adminQuestion.action?choiceCurr="+i+"&blankCurr=1'>"+i+"</a>]");
            }
            choiceSb.append("  ");
        }
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("ChoiceList",list1);
        session.put("BlankList",list2);
        session.put("BlankBar",blankSb);
        session.put("ChoiceBar",choiceSb);
        return SUCCESS;
    }
}
