<%--
  Created by IntelliJ IDEA.
  User: qg
  Date: 2021/3/21
  Time: 9:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
</head>
<body>
<%--<a href="manager/login">登录</a>--%>
<%--<input type="text" id = "username" name="username" placeholder="请输入用户名"/>--%>
<%--<input type = "password" id = "password" name="password" placeholder="请输入密码"/>--%>
<%--<button type="button" name="loginButton">登录</button>--%>
<%--<button type = "button" name = "registerButton">注册</button>--%>
<form action="login.do" method="post">
    用户名:<input type="text" name = "username"/>
    密码：<input type = "text" name = "password" />
    <input type="submit" name = "提交">
</form>


<a href="jumptoRegister.do">注册</a>

<%--<form action="manager/jumptoRegister" method = "get">--%>
<%--    注册:<input type="submit" name="注册"/>--%>
<%--</form>--%>
<%--<form action="text/hello" method = "get">--%>
<%--    注册:<input type="submit" name="注册"/>--%>
<%--</form>--%>


</body>
</html>
