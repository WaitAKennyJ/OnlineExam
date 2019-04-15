package Action;

import bean.BlankQuestion;
import bean.Questionaire;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by kennywzj on 2018/7/3.
 */
public class AdminUpdatePChain extends ActionSupport {
    public int ID;
    public String QName;
    public String Major;
    public String ChoiceID;
    public String BlankID;
    public String Creator;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQName() {
        return QName;
    }

    public void setQName(String QName) {
        this.QName = QName;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getChoiceID() {
        return ChoiceID;
    }

    public void setChoiceID(String choiceID) {
        ChoiceID = choiceID;
    }

    public String getBlankID() {
        return BlankID;
    }

    public void setBlankID(String blankID) {
        BlankID = blankID;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String execute(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Questionaire questionaire = new Questionaire();
        questionaire.setID(ID);
        questionaire.setQName(QName.trim());
        questionaire.setBlankID(BlankID.trim());
        questionaire.setMajor(Major.trim());
        questionaire.setChoiceID(ChoiceID.trim());
        questionaire.setCreator(Creator.trim());
        session.put("AdminUpdatePaper",questionaire);
        return SUCCESS;
    }
}
