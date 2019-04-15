package bean;

/**
 * Created by kennywzj on 2018/6/26.
 */
public class BlankQuestion {
    private int ID;
    private String Question;
    private String EasyLevel;
    private String Result;
    private String Subject;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getEasyLevel() {
        return EasyLevel;
    }

    public void setEasyLevel(String easyLevel) {
        EasyLevel = easyLevel;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    @Override
    public String toString() {
        return "BlankQuestion{" +
                "ID=" + ID +
                ", Question='" + Question + '\'' +
                ", EasyLevel='" + EasyLevel + '\'' +
                ", Result='" + Result + '\'' +
                ", Subject='" + Subject + '\'' +
                '}';
    }
}
