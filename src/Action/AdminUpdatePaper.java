package Action;

import Dao.QuestionaireDao;
import bean.Questionaire;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by kennywzj on 2018/7/3.
 */
public class AdminUpdatePaper extends ActionSupport {
    public int ID;
    public String QName;
    public String ChoiceID;
    public String BlankID;
    public String Major;
    public String Creator;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQName(String QName) {
        this.QName = QName;
    }

    public void setChoiceID(String choiceID) {
        ChoiceID = choiceID;
    }

    public void setBlankID(String blankID) {
        BlankID = blankID;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String execute(){
        QuestionaireDao qDao = new QuestionaireDao();
        Questionaire questionaire = new Questionaire();
        questionaire.setBlankID(BlankID.trim());
        questionaire.setQName(QName.trim());
        questionaire.setMajor(Major.trim());
        questionaire.setChoiceID(ChoiceID.trim());
        questionaire.setCreator(Creator.trim());
        questionaire.setID(ID);
        boolean flag = qDao.updateQuestionaire(questionaire) ;
        if (flag){
            return SUCCESS;
        }
        return ERROR;
    }
}
