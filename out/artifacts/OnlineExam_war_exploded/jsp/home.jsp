<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="Dao.StudentDao" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.QuestionaireDao" %>
<%@ page import="bean.Score_paper" %><%--
  Created by IntelliJ IDEA.
  User: kennywzj
  Date: 2018/6/26
  Time: 下午11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  ActionContext actionContext = ActionContext.getContext();   //取到struts容器
    String SNO = (String) application.getAttribute("SNO");

    StudentDao sDao = new StudentDao();
    List<Student> list = sDao.QueryInf(SNO.trim());
    Student st = list.get(0); //获取该考生信息

    String Major = st.getMajor();
    QuestionaireDao qDao = new QuestionaireDao();
    List<Score_paper> listScore = qDao.ChoosePaper(SNO,Major);
    session.setAttribute("Scorelist",listScore);

%>
<%  String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path; //设置路径
%>
<base href="<%=basePath%>">
<html>
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
        <li><a href="jsp/home_pwd.jsp"><i class="fa fa-gear fa-fw"></i> ResetPwd</a>
        </li>
        <li><a href="../index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
        </li>
    </ul>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a class="active-menu waves-effect waves-dark"><i class="fa fa-dashboard"></i> ChooseExam</a>
                </li>
                <li>
                    <a href="jsp/home_profile.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i> My Profile</a>
                </li>
                <li>
                    <a href="jsp/home_pwd.jsp" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> PassWord</a>
                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->

    <div id="page-wrapper">

        <div id="page-inner">

        <!-- /. ROW  -->
        <div class="row">
            <div class="col-md-12">
                <!--    Striped Rows Table  -->
                <div class="card">
                    <div class="card-action">
                        <h3>Student List</h3>
                    </div>
                    <div class="card-content">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Paper Name</th>
                                    <th>Score</th>
                                    <th>Creator</th>
                                    <th>Take</th>
                                </tr>
                                </thead>
                                <tbody>

                                <%int count=0;
                                %>
                                <s:iterator var="sp" value="#session.Scorelist" >
                                    <tr>
                                    <td><%=++count%></td>
                                    <td><s:property value="getQName().trim()"/></td>
                                    <td><s:property value="getScore().trim()"/></td>
                                    <td><s:property value="getCreator().trim()"/></td>
                                    <s:if test="getScore().trim()!=''">
                                        <td>You Can't Take This Exam</td>
                                    </s:if>
                                    <s:else>
                                        <s:url var="takeExam" action="Action/take.action">
                                            <s:param name="ExamID" value="getID()"/>
                                            <s:param name="ExamName" value="getQName().trim()"/>
                                        </s:url>
                                        <td><a href="${takeExam}">Take!</a> </td>
                                    </s:else>
                                    </tr>
                                </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!--  End  Striped Rows Table  -->

        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
    </div>
</div>
<!-- JS Scripts-->
<!-- jQuery Js -->
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


</body>
</html>
