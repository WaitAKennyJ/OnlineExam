package bean;

/**
 * Created by kennywzj on 2018/6/26.
 */
public class ChoiceQuestion {
    private int ID;
    private String Question;
    private String EasyLevel;
    private String A;
    private String B;
    private String C;
    private String D;
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

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
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
        return "ChoiceQuestion{" +
                "ID=" + ID +
                ", Question='" + Question + '\'' +
                ", EasyLevel='" + EasyLevel + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", Result='" + Result + '\'' +
                ", Subject='" + Subject + '\'' +
                '}';
    }
}
