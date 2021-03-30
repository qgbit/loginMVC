<%--
  Created by IntelliJ IDEA.
  User: qg
  Date: 2021/3/21
  Time: 11:29 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<input type="text" id = "username" name="username" placeholder="请输入用户名"/>--%>
<%--<input type = "password" id = "password" name="password" placeholder="请输入密码"/>--%>
<%--<input type="text" id = "phonenumber" name = "phonenumber" placeholder="请输入手机号"/>--%>
<%--<button type="button" name="registerButton">注册</button>--%>
<form action="register.do" method="post">
    用户名:<input type="text" name = "username"/>
    密码：<input type = "text" name = "password" />
    手机号:<input type="text" name="phonenumber">
    <input type="submit" name = "注册">
</form>

</body>
</html>
