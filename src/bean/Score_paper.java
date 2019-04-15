package bean;

/**
 * Created by kennywzj on 2018/6/28.
 */
public class Score_paper {
    private String SNO="";
    private String Score="";
    private String QName="";
    private String Creator="";
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getQName() {
        return QName;
    }

    public void setQName(String QName) {
        this.QName = QName;
    }

    @Override
    public String toString() {
        return "Score_paper{" +
                "SNO='" + SNO + '\'' +
                ", Score='" + Score + '\'' +
                ", QName='" + QName + '\'' +
                ", Creator='" + Creator + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
