<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="Dao.StudentDao" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kennywzj
  Date: 2018/6/27
  Time: 下午7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<%  Student st = (Student)session.getAttribute("AdminUpdateSt");
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
            <a href="jsp/admin_home.jsp" class="navbar-brand waves-effect waves-dark"><i class="large material-icons">track_changes</i> <strong>Exam</strong></a>

            <div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li><a class="dropdown-button waves-effect waves-dark" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>admin</b> <i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
    </nav>
    <!-- Dropdown Structure -->
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="../index.jsp"><i class="fa fa-sign-out fa-fw"></i>Logout</a>
        </li>
    </ul>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a class="waves-effect waves-dark" href="jsp/admin_student.jsp"><i class="fa fa-dashboard"></i> Back</a>
                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->

    <div id="page-wrapper">
        <div class="header">
            <h1 class="page-header">
                Update The Profile
            </h1>
        </div>
        <div id="page-inner">
            <form action="adminUpdate.action" class="col s12" method="post">
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>SNO</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input readonly value=<%=st.getSNO()%> id="SNO" name="SNO" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Name</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getName()%> id="Name" name="Name" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Pwd</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getPwd()%> id="Pwd" name="Pwd" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Sex</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getSex()%> id="Sex" name="Sex" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Major</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getMajor()%> id="Major" name="Major" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Class</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getClasses()%> id="Classes" name="Classes" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Email</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getEmail()%> id="Email" name="Email" type="email" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s1">
                        <h3><label>Mobile</label></h3>
                    </div>
                    <div class="input-field col s6">
                        <input value=<%=st.getMobiles()%> id="Mobiles" name="Mobiles" type="text" class="validate">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s2">
                        <input type="submit" value="submit" class="btn btn-primary">
                    </div>

                </div>
            </form>

        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
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
