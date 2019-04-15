package Action;

import Dao.QuestionDao;
import Dao.QuestionaireDao;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kennywzj on 2018/7/3.
 */
public class AdminRandomPaper extends ActionSupport {
    public String ChoiceNum;
    public String BlankNum;

    public void setChoiceNum(String choiceNum) {
        ChoiceNum = choiceNum;
    }

    public void setBlankNum(String blankNum) {
        BlankNum = blankNum;
    }

    public String execute(){
        int ChoiceInt = Integer.parseInt(ChoiceNum);
        int BlankInt = Integer.parseInt(BlankNum);
        QuestionDao questionDao = new QuestionDao();
        QuestionaireDao questionaireDao = new QuestionaireDao();
        Questionaire questionaire = new Questionaire();
        int ChoiceCount = questionDao.countChoice();
        int BlankCount = questionDao.countBlank();
        StringBuffer BlankSb = new StringBuffer();
        StringBuffer ChoiceSb = new StringBuffer();
        List<Integer> BlankArr = new ArrayList<>();
        List<Integer> ChoiceArr = new ArrayList<>();
        for (int i=1;i<=BlankCount;i++){
            BlankArr.add(i);
        }
        for (int i=1;i<=ChoiceCount;i++){
            ChoiceArr.add(i);
        }
        for (int i=1;i<=ChoiceInt;i++){
            int num = (int) (Math.random() * ChoiceCount);
            if (i==1) {
                ChoiceSb.append(ChoiceArr.get(num));
            }else {
                ChoiceSb.append(","+ChoiceArr.get(num));
            }
            ChoiceCount--;
            ChoiceArr.remove(num);
        }
        for (int i=1;i<=BlankInt;i++){
            int num = (int) (Math.random() * BlankCount);
            if (i==1) {
                BlankSb.append(BlankArr.get(num));
            }else {
                BlankSb.append(","+BlankArr.get(num));
            }
            BlankCount--;
            BlankArr.remove(num);
        }
        questionaire.setCreator("Random");
        questionaire.setMajor("软件");
        questionaire.setBlankID(BlankSb.toString());
        questionaire.setChoiceID(ChoiceSb.toString());
        questionaire.setQName("Random");
        boolean flag = questionaireDao.addQuestionaire(questionaire);
        if(flag) {
            return SUCCESS;
        }
        return ERROR;
    }
}
