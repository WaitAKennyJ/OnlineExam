package bean;

/**
 * Created by kennywzj on 2018/6/26.
 */
public class Questionaire {
    private int ID;
    private String QName;
    private String Major;
    private String ChoiceID;
    private String BlankID;
    private String Creator;


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
}
