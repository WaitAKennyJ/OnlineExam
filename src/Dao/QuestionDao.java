package Dao;

import bean.BlankQuestion;
import bean.ChoiceQuestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class QuestionDao {
    //连接数据库取得conn
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

    public List<ChoiceQuestion> allChoiceQuestion(){
        Connection conn = getConnection();
        String sql = "select * from tb_ChoiceQuesiton";
        List<ChoiceQuestion> list = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ChoiceQuestion cQ = new ChoiceQuestion();
                cQ.setID(rs.getInt("ID"));
                cQ.setQuestion(rs.getString("Question").trim());
                cQ.setResult(rs.getString("Resulte").trim());
                cQ.setA(rs.getString("A").trim());
                cQ.setB(rs.getString("B").trim());
                cQ.setC(rs.getString("C").trim());
                cQ.setD(rs.getString("D").trim());
                cQ.setSubject(rs.getString("Subject").trim());
                cQ.setEasyLevel(rs.getString("EasyLevel").trim());
                list.add(cQ);
            }

            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<BlankQuestion> allBlankQuestion(){
        Connection conn = getConnection();
        String sql = "select * from tb_BlankQuesiton";
        List<BlankQuestion> list = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                BlankQuestion bQ = new BlankQuestion();
                bQ.setID(rs.getInt("ID"));
                bQ.setQuestion(rs.getString("Question").trim());
                bQ.setResult(rs.getString("Resulte").trim());
                bQ.setSubject(rs.getString("Subject").trim());
                bQ.setEasyLevel(rs.getString("EasyLevel").trim());
                list.add(bQ);
            }

            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<ChoiceQuestion> QueryAllC(int page){
        List<ChoiceQuestion> list = new ArrayList<>();
        Connection conn = getConnection();

        try{
            String sql = "select * from tb_ChoiceQuestion ORDER by ID limit ?,?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(new Integer(1),(page-1)*5);
            pstm.setInt(new Integer(2),page*5);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                ChoiceQuestion cQ = new ChoiceQuestion();
                cQ.setID(rs.getInt("ID"));
                cQ.setQuestion(rs.getString("Question"));
                cQ.setA(rs.getString("A"));
                cQ.setB(rs.getString("B"));
                cQ.setC(rs.getString("C"));
                cQ.setD(rs.getString("D"));
                cQ.setResult(rs.getString("Result"));
                cQ.setSubject(rs.getString("Subject"));
                cQ.setEasyLevel(rs.getString("EasyLevel"));
                list.add(cQ);
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public List<BlankQuestion> QueryAllB(int page){
        List<BlankQuestion> list = new ArrayList<>();
        Connection conn = getConnection();

        try{
            String sql = "select * from tb_BlankQuestion ORDER by ID limit ?,?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(new Integer(1),(page-1)*5);
            pstm.setInt(new Integer(2),page*5);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                BlankQuestion bQ = new BlankQuestion();
                bQ.setID(rs.getInt("ID"));
                bQ.setQuestion(rs.getString("Question"));
                bQ.setResult(rs.getString("Result"));
                bQ.setSubject(rs.getString("Subject"));
                bQ.setEasyLevel(rs.getString("EasyLevel"));
                list.add(bQ);
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public int countChoice(){
        Connection conn = getConnection();
        int count = 0;
        String sql = "select count(*) from tb_ChoiceQuestion";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int countBlank(){
        Connection conn = getConnection();
        int count = 0;
        String sql = "select count(*) from tb_BlankQuestion";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean deleteChoice(int ID){
        Connection conn = getConnection();
        String sql = "delete from tb_ChoiceQuestion where ID=\'"+ID+"\'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean deleteBlank(int ID){
        Connection conn = getConnection();
        String sql = "delete from tb_BlankQuestion where ID=\'"+ID+"\'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean addChoice(ChoiceQuestion cq){

        Connection conn = getConnection();
        String sql = "insert into tb_ChoiceQuestion(ID,Question,EasyLevel,A,B,C,D,Result,Subject) values(null,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,cq.getQuestion().trim());
            pstm.setString(2,cq.getEasyLevel().trim());
            pstm.setString(3,cq.getA().trim());
            pstm.setString(4,cq.getB().trim());
            pstm.setString(5,cq.getC().trim());
            pstm.setString(6,cq.getD().trim());
            pstm.setString(7,cq.getResult().trim());
            pstm.setString(8,cq.getSubject().trim());
            int row = pstm.executeUpdate();
            if (row!=0){
                pstm.close();
                conn.close();
                return true;
            }
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addBlank(BlankQuestion cq){
        Connection conn = getConnection();
        String sql = "insert into tb_BlankQuestion(ID,Question,EasyLevel,Result,Subject) values(null,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,cq.getQuestion().trim());
            pstm.setString(2,cq.getEasyLevel().trim());
            pstm.setString(3,cq.getResult().trim());
            pstm.setString(4,cq.getSubject().trim());
            int row = pstm.executeUpdate();
            if (row!=0){
                pstm.close();
                conn.close();
                return true;
            }
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
