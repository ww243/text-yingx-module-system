<%--
  Created by IntelliJ IDEA.
  User: 楠少
  Date: 2020/12/2
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <<div align="center">
        <div style="border: 3px #cad solid;width: 300px;height: 200px" >
            <form method="post" action="${path}/user/login"><br>
                用户名:<input type="text" name="username" /><br><br>
                密&emsp;码:<input type="password" name="password"/><br><br>
                <input type="checkbox" name="rememberme" value="1" >记住我,不然不放过你</input><br><br>
                <input type="submit" value="登陆"/><br><br>
            </form>
        </div>
    </div>
</body>
</html>
