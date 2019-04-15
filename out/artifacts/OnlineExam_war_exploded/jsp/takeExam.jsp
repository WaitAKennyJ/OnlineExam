<%@ page import="bean.ChoiceQuestion" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.BlankQuestion" %>
<%@ page import="Dao.QuestionaireDao" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="Dao.StudentDao" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kennywzj
  Date: 2018/6/28
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ActionContext actionContext = ActionContext.getContext();   //取到struts容器
    String SNO = (String) application.getAttribute("SNO");

    StudentDao sDao = new StudentDao();
    List<Student> list = sDao.QueryInf(SNO.trim());
    Student st = list.get(0); //获取该考生信息

    QuestionaireDao qDao = new QuestionaireDao();
    String[] ChoiceList = (String[])session.getAttribute("ChoiceList");
    String[] BlankList = (String[])session.getAttribute("BlankList");

    List<ChoiceQuestion> list2 = qDao.getChoiceQuestion(ChoiceList);
    List<BlankQuestion> list3 = qDao.getBlankQuestion(BlankList);
    List<String> choiceAnswer = new ArrayList<>();
    List<String> blankAnswer = new ArrayList<>();
    for (ChoiceQuestion cq : list2){
        choiceAnswer.add(cq.getResult().trim());
    }
    for (BlankQuestion bq : list3){
        blankAnswer.add(bq.getResult().trim());
    }
    session.setAttribute("SNO",SNO.trim());
    session.setAttribute("choiceAnswer",choiceAnswer);
    session.setAttribute("blankAnswer",blankAnswer);
    int ChoiceSize = list2.size();
    int BlankSize = list3.size();
%>
<%  String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path; //设置路径
%>
<base href="<%=basePath%>">
<script type='text/javascript'>

    var s=20;
    var m=10;
    function getTime(){
        document.getElementById('second').innerHTML="<font color='red'>"+s+"</font>";
        document.getElementById('minute').innerHTML="<font color='red'>"+m+"</font>";
        s-=1;
        //1000毫秒=1秒
        var x=setTimeout('getTime()',1000)
        if(m<0){
            clearTimeout(x);
            window.location.href = "jsp/home.jsp"
        }else{

            if(s<=0){
                s=10;
                m--;
            }
        }

    }
    window.onload=getTime;//开始执行倒计时i

</script>

<style type="text/css">
    #left{
        float: left;
        width: 50%}
    #right{
        float: right;width: 10%;}
</style>
<html>
<head>
    <title>Taking an Exam!</title>
</head>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Exam System</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="../assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="../assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="../assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="../assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="../assets/js/Lightweight-Chart/cssCharts.css">
</head>

<body>

<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand waves-effect waves-dark"><i class="large material-icons">track_changes</i> <strong>Exam</strong></a>

            <div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li><a class="dropdown-button waves-effect waves-dark" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b><%=st.getName()%></b> <i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
    </nav>
    <!-- Dropdown Structure -->
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="jsp/home_profile.jsp"><i class="fa fa-user fa-fw"></i> My Profile</a>
        </li>
        <li><a><i class="fa fa-gear fa-fw"></i>ResetPwd</a>
        </li>
        <li><a href="../index.jsp"><i class="fa fa-sign-out fa-fw"></i>Logout</a>
        </li>
    </ul>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a class="active-menu waves-effect waves-dark"><i class="fa fa-dashboard"></i> 交卷</a>
                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div class="header">
            <h3 class="page-header">
                <div class="alert alert-danger">
                    <div> <strong>Time: 60 Min</strong> </div>
                    <div> <strong>Rest Time: <span id="minute">60</span> M : <span id="second">60</span> s</strong> </div>
                </div>
            </h3>
        </div>
        <div id="page-inner">
            <form action="Action/checkPaper.action" method="post">
            <%--选择--%>
            <%int count=0;%>
            <% for (ChoiceQuestion cq : list2){

            %>
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-title">
                            <div class="alert alert-warning">
                                <div class="row">
                                    <div class="input-field col s6">
                                        <h3><label><%=++count%><%="."%><%=cq.getQuestion()%></label></h3>
                                    </div>
                                    <div class="input-field col s3">
                                        <input type="text" name="ChoiceAnswer" maxlength="1">
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="card-content">
                            <div class="alert alert-info">
                                <strong>A.</strong> <%=cq.getA()%>
                            </div>
                            <div class="alert alert-info">
                                <strong>B.</strong> <%=cq.getB()%>
                            </div>
                            <div class="alert alert-info">
                                <strong>C.</strong> <%=cq.getC()%>
                            </div>
                            <div class="alert alert-info">
                                <strong>D.</strong> <%=cq.getD()%>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /. PAGE INNER  -->
            </div>

            <%}%>

            <%--填空--%>
            <% for (BlankQuestion bq : list3){

            %>
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-title">
                            <div class="alert alert-warning"><%=++count%><%="."%><%=bq.getQuestion()%></div>
                        </div>
                        <div class="card-content">
                            <div class="alert alert-info">
                                <input name="BlankAnswer" id=<%=count%> type="text" value="">
                            </div>

                        </div>

                    </div>
                </div>

            </div>

            <%}%>


                            <div class="row">
                                <div class="input-field col s2">
                                    <input type="submit" value="submit" class="btn btn-primary">
                                </div>

                            </div>
                        </form>

        <!-- /. PAGE INNER  -->

    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
</div>
<script src="../assets/js/jquery-1.10.2.js"></script>

<!-- Bootstrap Js -->
<script src="../assets/js/bootstrap.min.js"></script>

<script src="../assets/materialize/js/materialize.min.js"></script>

<!-- Metis Menu Js -->
<script src="../assets/js/jquery.metisMenu.js"></script>
<!-- Morris Chart Js -->
<script src="../assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="../assets/js/morris/morris.js"></script>


<script src="../assets/js/easypiechart.js"></script>
<script src="../assets/js/easypiechart-data.js"></script>

<script src="../assets/js/Lightweight-Chart/jquery.chart.js"></script>

<!-- Custom Js -->
<script src="../assets/js/custom-scripts.js"></script>

<
</body>
</html>
