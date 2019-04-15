<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="bean.Questionaire" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.QuestionaireDao" %>
<%@ page import="Dao.QuestionDao" %><%--
  Created by IntelliJ IDEA.
  User: kennywzj
  Date: 2018/7/1
  Time: 下午6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path; //设置路径
%>
<base href="<%=basePath%>">
<%
    QuestionaireDao qDao = new QuestionaireDao();
    List<Questionaire> listP = qDao.AllQuestionaire();
    pageContext.setAttribute("Questionaire",listP);
    QuestionDao questionDao = new QuestionDao();
    int ChoiceCount = questionDao.countChoice();
    int BlankCount = questionDao.countBlank();

%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin</title>
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
            <a href="jsp/admin_home.jsp" class="navbar-brand waves-effect waves-dark"><i class="large material-icons">track_changes</i> <strong>Exam</strong></a>

            <div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li><a class="dropdown-button waves-effect waves-dark" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>admin</b> <i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
    </nav>
    <!-- Dropdown Structure -->
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="../index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
        </li>
    </ul>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                        <a href="Action/adminStudent.action" class="waves-effect waves-dark"><i class="fa fa-dashboard"></i> StudentManagement</a>
                    </li>
                <li>
                    <a class="waves-effect waves-dark"><i class="fa fa-sitemap"></i> Paper Management<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a>Question<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="Action/adminQuestion.action">Manage Question</a>
                                </li>
                                <li>
                                    <a href="jsp/AdminAddChoice.jsp">Add ChoiceQuestion</a>
                                </li>
                                <li>
                                    <a href="jsp/AdminAddBlank.jsp">Add BlankQuestion</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="jsp/admin_PManagement.jsp">Questionaire</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="Action/levelPaper.action" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> Analysis</a>
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
                            <h3>Questionaire List</h3>
                        </div>
                        <div class="card-content">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>QName</th>
                                        <th>ChoiceID</th>
                                        <th>BlankID</th>
                                        <th>Major</th>
                                        <th>Creator</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator var="st" value="#attr.Questionaire" >
                                        <tr>
                                            <td><s:property value="getID()"/></td>
                                            <td><s:property value="getQName().trim()"/></td>
                                            <td><s:property value="getChoiceID().trim()"/></td>
                                            <td><s:property value="getBlankID().trim()"/></td>
                                            <td><s:property value="getMajor().trim()"/></td>
                                            <td><s:property value="getCreator().trim()"/></td>
                                            <s:url var="updatePaper" action="Action/adminUpdatePChain.action">
                                            <s:param name="ID" value="getID()"/>
                                            <s:param name="QName" value="getQName().trim()"/>
                                            <s:param name="ChoiceID" value="getChoiceID().trim()"/>
                                            <s:param name="BlankID" value="getBlankID().trim()"/>
                                            <s:param name="Major" value="getMajor().trim()"/>
                                            <s:param name="Creator" value="getCreator().trim()"/>
                                            </s:url>
                                            <td><a href="${updatePaper}">修改</a></td>
                                            <s:url var="deletePaper" action="Action/adminDeletePaper.action">
                                                <s:param name="ID" value="getID()"/>
                                            </s:url>
                                            <td><a href="${deletePaper}">删除</a></td>
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

            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-content">
                            <form action="Action/adminRandomPaper.action" method="post" onsubmit="return CheckForm()">
                                <div class="row">
                                    <div class="input-field col s6">
                                    <h3><label>自动生成</label></h3>
                                    </div>
                                </div>
                                <br>
                                <br>
                                <div class="row">
                                    <div class="input-field col s2">
                                        <h5><label>ChoiceNum:(共<%=ChoiceCount%>道选择)</label></h5>
                                    </div>
                                    <div class="input-field col s4">
                                        <input value="0" id="ChoiceNum" name="ChoiceNum" type="text" class="validate">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s2">
                                        <h5><label>BlankNum:(共<%=BlankCount%>道填空)</label></h5>
                                    </div>
                                    <div class="input-field col s4">
                                        <input value="0" id="BlankNum" name="BlankNum" type="text" class="validate">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <input type="submit" value="submit" class="btn btn-primary">
                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
    </div>

</div>
<!-- JS Scripts-->
<!-- jQuery Js -->
<script>
    function CheckForm(){
        var choiceNum = document.getElementById("ChoiceNum").value;
        var blankNum = document.getElementById("BlankNum").value;
        if(choiceNum><%=ChoiceCount%>){
            alert("超出数量!");
            return false;
        }
        if(blankNum><%=BlankCount%>){
            alert("超出数量!");
            return false;
        }
        if(blankNum==0 && choiceNum==0){
            alert("不能选择为0!")
            return false;
        }
        return true;
    }
</script>
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

