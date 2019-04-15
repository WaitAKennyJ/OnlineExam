<%@ page import="bean.Questionaire" %><%--
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
<% Questionaire qRe = (Questionaire)session.getAttribute("AdminUpdatePaper") ;
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
                    <a href="#" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> Analysis</a>
                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->

    <div id="page-wrapper">

        <div id="page-inner">

            <form action="Action/adminUpdatePaper.action" class="col s12" method="post">
                <div class="row">
                    <div class="input-field col s1">
                        <h4><label>ID</label></h4>
                    </div>
                    <div class="input-field col s6">
                        <input readonly value=<%=qRe.getID()%> id="ID" name="ID" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h4><label>QName</label></h4>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=qRe.getQName()%> id="QName" name="QName" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h4><label>ChoiceID</label></h4>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=qRe.getChoiceID()%> id="ChoiceID" name="ChoiceID" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h4><label>BlankID</label></h4>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=qRe.getBlankID()%> id="BlankID" name="BlankID" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h4><label>Major</label></h4>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=qRe.getMajor()%> id="Major" name="Major" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h4 ><label>Creator</label></h4>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=qRe.getCreator()%> id="Creator" name="Creator" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s2">
                        <input type="submit" value="submit" class="btn btn-primary">
                    </div>

                </div>
            </form>
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
