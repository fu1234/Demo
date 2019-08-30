<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table width="700" align="center" border="1">
    <tr>
        <td>用户名:</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>用户密码:</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td>用户昵称:</td>
        <td>${user.nickname}</td>
    </tr>
    <tr>
        <td>用户组:</td>
        <td>
            ${user.group.groupname}
        </td>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="返回" onclick="javascript:history.back(-1)"/>
            <input type="button" value="返回" onclick="window.history.go(-1)"/>
        </td>
    </tr>
</table>

</body>
</html>