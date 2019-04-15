package Dao;

import bean.Student;
import com.opensymphony.xwork2.ActionContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/6/26.
 */
public class StudentDao {
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
    public boolean StudentLogin(String SNO,String Pwd){
        if (SNO==null||Pwd==null){
            return false;
        }
        Connection conn = getConnection();
        String PassWord = "";
        String name = "";
        String sql = "select * from tb_Student where SNO=\'"+SNO.trim()+"\'";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                PassWord = rs.getString("Pwd");
                name = rs.getString("Name");

            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(PassWord.trim().equals(Pwd.trim())){
            ActionContext actionContext = ActionContext.getContext();   //取到struts容器
            Map application = actionContext.getApplication();
            application.put("SNO",SNO);

            return true;
        }else
        {
            return false;
        }

    }

    public boolean StudentSignUp(String SNO,String Pwd,String Email){
        Connection conn = getConnection();
        boolean hasSNO = true;
        String sql = "select * from tb_Student where SNO="+SNO.trim();
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                System.out.print(rs.getString(2));
              hasSNO = true;
            }else {
                hasSNO = false;
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (hasSNO ==true){
            return false;
        } else{
            String insertSql = "insert into tb_Student(ID,SNO,Name,Pwd,Sex,Major,Classes,Email,Mobiles) values(null,?,?,?,?,?,?,?,?)";
            try{
                PreparedStatement pstm = conn.prepareStatement(insertSql);
                pstm.setString(1,SNO);
                pstm.setString(2,"N/A");
                pstm.setString(3,Pwd);
                pstm.setString(4,"N/A");
                pstm.setString(5,"N/A");
                pstm.setString(6,"N/A");
                pstm.setString(7,Email);
                pstm.setString(8,"N/A");
                int row = pstm.executeUpdate();
                if (row!=0){
                    ActionContext actionContext = ActionContext.getContext();   //取到struts容器
                    Map applicaton = actionContext.getApplication();
                    applicaton.put("SNO",SNO);
                    pstm.close();
                    conn.close();
                    return true;
                }
                pstm.close();
                conn.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

           return false;
    }

    public String RetrievePwd(String Email){
        Connection conn = getConnection();
        String SNO=null,Pwd=null;
        String sql = "select * from tb_Student where Email=\'"+Email.trim()+"\'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                SNO = rs.getString("SNO").trim();
                Pwd = rs.getString("Pwd").trim();
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (SNO!=null && Pwd!=null)
            return "Your SNO is "+SNO+" and your PassWord is "+Pwd;
        else return "Wrong Email Address!";

    }

    public List<Student> QueryInf(String SNO){
        List<Student> list = new ArrayList<>();
        Connection conn = getConnection();
        String sql = "select * from tb_student where SNO=\'"+SNO.trim()+"\'";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
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

    public boolean StudentUpdate(List<Student> list){
        try {
            Connection conn = getConnection();
            String sql = "update tb_Student SET Name=?,Sex=?,Major=?,Classes=?,Email=?,Mobiles=? where SNO=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            for(Student st : list){
                pstm.setString(1,st.getName().trim());
                pstm.setString(2,st.getSex().trim());
                pstm.setString(3,st.getMajor().trim());
                pstm.setString(4,st.getClasses().trim());
                pstm.setString(5,st.getEmail().trim());
                pstm.setString(6,st.getMobiles().trim());
                pstm.setString(7,st.getSNO().trim());
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

    public boolean ResetPwd(String SNO,String Pwd){
        try {
            Connection conn = getConnection();
            String sql = "update tb_Student SET Pwd=? where SNO=?";
            PreparedStatement pstm = conn.prepareStatement(sql);

                pstm.setString(1,Pwd.trim());
                pstm.setString(2,SNO.trim());
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


