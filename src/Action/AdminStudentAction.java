package Action;

import Dao.AdminDao;
import bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by kennywzj on 2018/7/2.
 */
public class AdminStudentAction extends ActionSupport {
    public int currPage =1;
    public String execute(){
        AdminDao aDao = new AdminDao();
        List<Student> list = aDao.QueryAllS(currPage);
        int count = aDao.countStudent();
        int pages = 0;
        StringBuffer sb = new StringBuffer();
        if (count%5 ==0){
            pages = count / 5;
        }else{
            pages = count /5 +1;
        }
        for (int i=1; i <= pages; i++){
            if (i==currPage){
                sb.append("<"+i+">");
            }else {
                sb.append("[<a href='Action/adminStudent.action?currPage="+i+"'>"+i+"</a>]");
            }
            sb.append("  ");
        }
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("AllStudent",list);
        session.put("StudentBar",sb);
        return SUCCESS;
    }
}
