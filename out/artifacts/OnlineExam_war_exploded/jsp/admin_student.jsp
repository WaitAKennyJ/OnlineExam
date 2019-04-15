<%@ page import="Dao.AdminDao" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kennywzj
  Date: 2018/7/1
  Time: 下午6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path; //设置路径
%>
<% List<Student> list = (List<Student>)session.getAttribute("AllStudent");
    StringBuffer sb = (StringBuffer)session.getAttribute("StudentBar");
    pageContext.setAttribute("AllStudent",list);

%>

<base href="<%=basePath%>">
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
                    <a class="active-menu waves-effect waves-dark"><i class="fa fa-dashboard"></i> StudentManagement</a>
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
                            <h3>Student List</h3>
                        </div>
                        <div class="card-content">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>SNO</th>
                                        <th>Name</th>
                                        <th>Pwd</th>
                                        <th>Sex</th>
                                        <th>Major</th>
                                        <th>Classes</th>
                                        <th>Email</th>
                                        <th>Mobiles</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%int count=0;
                                    %>
                                    <s:iterator var="st" value='#attr.AllStudent' >
                                        <tr>
                                            <td><%=++count%></td>
                                            <td><s:property value="getSNO().trim()"/></td>
                                            <td><s:property value="getName().trim()"/></td>
                                            <td><s:property value="getPwd().trim()"/></td>
                                            <td><s:property value="getSex().trim()"/></td>
                                            <td><s:property value="getMajor().trim()"/></td>
                                            <td><s:property value="getClasses().trim()"/></td>
                                            <td><s:property value="getEmail().trim()"/></td>
                                            <td><s:property value="getMobiles().trim()"/></td>
                                            <s:url var="updateStudent" action="Action/adminUpdateRedirect.action">
                                                <s:param name="SNO" value="getSNO().trim()"/>
                                                <s:param name="Name" value="getName().trim()"/>
                                                <s:param name="Pwd" value="getPwd().trim()"/>
                                                <s:param name="Sex" value="getSex().trim()"/>
                                                <s:param name="Major" value="getMajor().trim()"/>
                                                <s:param name="Classes" value="getClasses().trim()"/>
                                                <s:param name="Email" value="getEmail().trim()"/>
                                                <s:param name="Mobiles" value="getMobiles().trim()"/>
                                            </s:url>
                                            <td><a href="${updateStudent}">修改</a></td>
                                            <s:url var="deleteStudent" action="Action/deleteStudent.action">
                                                <s:param name="SNO" value="getSNO().trim()"/>
                                            </s:url>
                                            <td><a href="${deleteStudent}">删除</a></td>
                                        </tr>
                                    </s:iterator>

                                    </tbody>
                                    <tr><%=sb%></tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--  End  Striped Rows Table  -->
                </div>
                <!-- /. PAGE INNER  -->
            </div>

            <div class="card">
                <div class="card-action">
                    <h3><strong>Add A Student</strong></h3>
                </div>
                <div class="card-content">
                    <form action="adminAdd.action" class="col s12" method="post">
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>SNO</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="SNO" name="SNO" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Name</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Name" name="Name" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Pwd</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Pwd" name="Pwd" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Sex</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Sex" name="Sex" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Major</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Major" name="Major" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Class</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Classes" name="Classes" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Email</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Email" name="Email" type="email" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s1">
                                <h3><label>Mobile</label></h3>
                            </div>
                            <div class="input-field col s6">
                                <input value="" id="Mobiles" name="Mobiles" type="text" class="validate">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s2">
                                <input type="submit" value="submit" class="btn btn-primary">
                            </div>

                        </div>
                    </form>
                </div>
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
