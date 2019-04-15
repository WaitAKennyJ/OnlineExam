package Dao;

import bean.*;

import javax.xml.namespace.QName;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/6/28.
 */
public class QuestionaireDao {
    public Connection getConnection(){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/OLEXAM?useSSL=true";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url,username,password);
            if (conn != null){
                System.out.println("Connection Success!");
            }else{
                System.out.println("Connection Failed!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }


    public List<Score_paper> ChoosePaper(String SNO,String Major){
        Connection conn = getConnection();
        String sql = "select * from tb_Questionaire WHERE Major=\'"+Major.trim()+"\'";
        String QName = "";
        List<Score_paper> list = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);;
            PreparedStatement pstm2 = null;
            ResultSet rs = pstm.executeQuery();
            ResultSet rs2 = null;
            while (rs.next()){
                Score_paper sp = new Score_paper();
                QName = rs.getString("QName").trim();
                sp.setQName(QName);
                sp.setID(rs.getInt("ID"));
                sp.setCreator(rs.getString("Creator"));
                String sql2 = "select Score from tb_Grades WHERE SNO=\'"+SNO.trim()+"\' AND QName=\'"+QName+"\'";
                pstm2 = conn.prepareStatement(sql2);
                rs2 = pstm2.executeQuery();
                while (rs2.next()){
                    sp.setScore(rs2.getString("Score"));
                }
                rs2.close();
                pstm2.close();
                sp.setSNO(SNO.trim());
                list.add(sp);
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Map<String,String> getQuestionID(int ExamID){
        Map<String,String> map = new HashMap<>();
        Connection conn = getConnection();
        String sql = "select * from tb_Questionaire where ID=\'"+ExamID+"\'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                map.put("ChoiceID",rs.getString("ChoiceID").trim());
                map.put("BlankID",rs.getString("BlankID").trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }


    public List<ChoiceQuestion> getChoiceQuestion(String[] IDs){
        List<ChoiceQuestion> list =new ArrayList<>();

        Connection conn = getConnection();
        String sql = "select * from tb_ChoiceQuestion where ID=?";
        try {
            for (String id : IDs) {
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1, Integer.parseInt(id.trim()));
                ResultSet rs = pstm.executeQuery();
                ChoiceQuestion cQ = new ChoiceQuestion();
                while (rs.next()){
                    cQ.setID(rs.getInt("ID"));
                    cQ.setQuestion(rs.getString("Question"));
                    cQ.setA(rs.getString("A"));
                    cQ.setB(rs.getString("B"));
                    cQ.setC(rs.getString("C"));
                    cQ.setD(rs.getString("D"));
                    cQ.setResult(rs.getString("Result"));
                    cQ.setEasyLevel(rs.getString("EasyLevel"));
                    cQ.setSubject(rs.getString("Subject"));
                    list.add(cQ);
                }
                rs.close();
                pstm.close();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<BlankQuestion> getBlankQuestion(String[] IDs){
        List<BlankQuestion> list =new ArrayList<>();
        Connection conn = getConnection();
        String sql = "select * from tb_BlankQuestion where ID=?";
        try {
            for (String id : IDs) {
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1, Integer.parseInt(id.trim()));
                ResultSet rs = pstm.executeQuery();
                BlankQuestion bQ = new BlankQuestion();
                while (rs.next()){
                    bQ.setID(rs.getInt("ID"));
                    bQ.setQuestion(rs.getString("Question"));
                    bQ.setResult(rs.getString("Result"));
                    bQ.setEasyLevel(rs.getString("EasyLevel"));
                    bQ.setSubject(rs.getString("Subject"));
                    list.add(bQ);
                }
                rs.close();
                pstm.close();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Questionaire> AllQuestionaire(){
        Connection conn = getConnection();
        String sql = "select * from tb_Questionaire";
        List<Questionaire> list = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Questionaire questionaire = new Questionaire();
                questionaire.setID(rs.getInt("ID"));
                questionaire.setBlankID(rs.getString("BlankID"));
                questionaire.setChoiceID(rs.getString("ChoiceID"));
                questionaire.setCreator(rs.getString("Creator"));
                questionaire.setMajor(rs.getString("Major"));
                questionaire.setQName(rs.getString("QName"));
                list.add(questionaire);

            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean deleteQuestionaire(int ID){
        Connection conn = getConnection();
        String sql = "delete from tb_Questionaire where ID=\'"+ID+"\'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean updateQuestionaire(Questionaire paper){
        Connection conn = getConnection();
        String sql = "update tb_Questionaire SET QName=?,ChoiceID=?,BlankID=?,Major=?,Creator=? where ID=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(6,paper.getID());
            pstm.setString(1,paper.getQName().trim());
            pstm.setString(2,paper.getChoiceID().trim());
            pstm.setString(3,paper.getBlankID().trim());
            pstm.setString(4,paper.getMajor().trim());
            pstm.setString(5,paper.getCreator().trim());
            int rows = pstm.executeUpdate();
            if (rows!=1){
                return false;
            }

            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean addQuestionaire(Questionaire paper){
        Connection conn = getConnection();
        String sql = "insert into tb_Questionaire(ID,QName,ChoiceID,BlankID,Major,Creator) values(null,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,paper.getQName().trim());
            pstm.setString(2,paper.getChoiceID().trim());
            pstm.setString(3,paper.getBlankID().trim());
            pstm.setString(4,paper.getMajor().trim());
            pstm.setString(5,paper.getCreator().trim());
            int rows = pstm.executeUpdate();
            if (rows!=1){
                return false;
            }

            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean addGrades(Grades grades) {
        Connection conn = getConnection();
        String sql = "insert into tb_Grades(ID,QName,Major,SNO,Score) values(null,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,grades.getQName().trim());
            pstm.setString(2,grades.getMajor().trim());
            pstm.setString(3,grades.getSNO().trim());
            pstm.setString(4,grades.getScore().trim());
            int rows = pstm.executeUpdate();
            if (rows!=1){
                return false;
            }

            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
