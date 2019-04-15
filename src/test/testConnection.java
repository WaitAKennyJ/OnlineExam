package test;
import Dao.AdminDao;
import Dao.QuestionDao;
import Dao.QuestionaireDao;
import Dao.StudentDao;
import bean.*;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/6/24.
 */
public class testConnection {
    public static void main(String[] args) {
//        StudentDao sdao = new StudentDao();
//        boolean flag = sdao.StudentLogin("151303128","1233456");
//        System.out.print(flag);

//         StudentDao sdao = new StudentDao();
//        String str = sdao.StudentSignUp("151303130","123654","12346@qq.com");
//        System.out.println(str);

//        StudentDao sdao = new StudentDao();
//        String str = sdao.RetrievePwd("459743708@qq.com");
//        System.out.print(str);
//
//        StudentDao sdao = new StudentDao();
//        List<Student> list = sdao.QueryInf("151303140");
//        Student st = list.get(0);
//        st.setSex("Female");
//        System.out.print(st);
//        List<Student> list2 = new ArrayList<>();
//        list2.add(st);
//        sdao.StudentUpdate(list2);


//        QuestionaireDao qDao = new QuestionaireDao();
//        List<Score_paper> list = qDao.ChoosePaper("151303128","软件");
//        for (Score_paper sp :list){
//            System.out.println(sp);
//        }



//        QuestionaireDao qDao = new QuestionaireDao();
//        Map<String,String> map = qDao.getQuestionID(2);
//        String ChoiceID = map.get("ChoiceID");
//        String BlankID = map.get("BlankID");
//        String[] ChoiceList = ChoiceID.split(",");
//        String[] BlankList = BlankID.split(",");
//        for (String s1 : ChoiceList){
//            System.out.println(s1);
//        }
//        for (String s2 : BlankList){
//            System.out.println(s2);
//        }
//        List<ChoiceQuestion> list = qDao.getChoiceQuestion(ChoiceList);
//        for(ChoiceQuestion cq : list){
//            System.out.println(cq);
//        }
//
//        List<BlankQuestion> list2 = qDao.getBlankQuestion(BlankList);
//        for(BlankQuestion bq : list2){
//            System.out.println(bq);
//        }

//        AdminDao aDao = new AdminDao();
//        List<Student> list = aDao.QueryAll();
//        for (Student s : list){
//            System.out.println(s);
//        }
//        AdminDao adao = new AdminDao();
//        adao.DeleteStudent("151303");


//        AdminDao adminDao = new AdminDao();
//        System.out.print(adminDao.countStudent());
//
//        QuestionDao questionDao = new QuestionDao();
//        int choiceCount = questionDao.countChoice();
//        int blankCount = questionDao.countBlank();
//        int choicePages = 0;
//        int blankPages = 0;
//        List<ChoiceQuestion> list1 = questionDao.QueryAllC(2);
//        for (ChoiceQuestion cq : list1){
//            System.out.println(cq);
//        }
            int a =2;
            int b =3;
          System.out.print((int)((float)a*100/b));
    }
}