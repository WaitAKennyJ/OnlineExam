<%--
  Created by IntelliJ IDEA.
  User: kennywzj
  Date: 2018/6/27
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    var msg="${requestScope.Message}";
    if(msg=""){
        alert("登录失败!");
    }
</script>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error!</h1>
</body>
</html>
