package bean;

/**
 * Created by kennywzj on 2018/7/4.
 */
public class PaperEasyLevel {
    private int ID;
    private String QName;
    private int EasyLevel;
    private String Major;
    private String Creator;
    private double Level;

    public double getLevel() {
        return Level;
    }

    public void setLevel(double Level) {
        this.Level = Level;
    }

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

    public int getEasyLevel() {
        return EasyLevel;
    }

    public void setEasyLevel(int easyLevel) {
        EasyLevel = easyLevel;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }
}
