package Dao;

import bean.BlankQuestion;
import bean.ChoiceQuestion;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by kennywzj on 2018/7/1.
 */
public class AdminDao {
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

    //登录
    public boolean AdminLogin(String Name,String Pwd){
        if (Name==null||Pwd==null){
            return false;
        }
        Connection conn = getConnection();
        String PassWord = "";
        String sql = "select * from tb_Admin where Name=\'"+Name.trim()+"\'";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                PassWord = rs.getString("Pwd");

            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(PassWord.trim().equals(Pwd.trim())){
            return true;
        }else
        {
            return false;
        }

    }


    public List<Student> QueryAllS(int page){
        List<Student> list = new ArrayList<>();
        Connection conn = getConnection();

        try{
            String sql = "select * from tb_student ORDER by ID limit ?,?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(new Integer(1),(page-1)*5);
            pstm.setInt(new Integer(2),page*5);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Student st = new Student();
                st.setSNO(rs.getString("SNO"));
                st.setName(rs.getString("Name"));
                st.setPwd(rs.getString("Pwd"));
                st.setSex(rs.getString("Sex"));
                st.setMajor(rs.getString("Major"));
                st.setClasses(rs.getString("Classes"));
                st.setEmail(rs.getString("Email"));
                st.setMobiles(rs.getString("Mobiles"));
                list.add(st);
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }



    public int countStudent(){

        Connection conn = getConnection();
        int count = 0;
        String sql = "select count(*) from tb_Student";
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

    public boolean DeleteStudent(String SNO){
        Connection conn = getConnection();
        String sql = "delete from tb_Student where SNO=\'"+SNO.trim()+"\'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean AddStudent(Student st){
        Connection conn = getConnection();
        String sql = "insert into tb_Student(ID,SNO,Name,Pwd,Sex,Major,Classes,Email,Mobiles) values(null,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,st.getSNO().trim());
            pstm.setString(2,st.getName().trim());
            pstm.setString(3,st.getPwd().trim());
            pstm.setString(4,st.getSex().trim());
            pstm.setString(5,st.getMajor().trim());
            pstm.setString(6,st.getClasses().trim());
            pstm.setString(7,st.getEmail().trim());
            pstm.setString(8,st.getMobiles().trim());
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


    public boolean AdminUpdateS(List<Student> list){
        try {
            Connection conn = getConnection();
            String sql = "update tb_Student SET Name=?,Sex=?,Major=?,Classes=?,Email=?,Mobiles=?,Pwd=? where SNO=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            for(Student st : list){
                pstm.setString(1,st.getName().trim());
                pstm.setString(2,st.getSex().trim());
                pstm.setString(3,st.getMajor().trim());
                pstm.setString(4,st.getClasses().trim());
                pstm.setString(5,st.getEmail().trim());
                pstm.setString(6,st.getMobiles().trim());
                pstm.setString(7,st.getPwd().trim());
                pstm.setString(8,st.getSNO().trim());
                int rows = pstm.executeUpdate();
                if (rows!=1){
                    return false;
                }
            }
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
