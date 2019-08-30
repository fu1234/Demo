<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>users</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>
<body>
<h1>欢迎您:${loginUser.nickname}</h1>
<table border="1" align="center" width="700">
    <tr>
        <th>ID</th>
        <th>账号</th>
        <th>密码</th>
        <th>昵称</th>
        <th>操作</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td><a href="${u.id}/show">${u.username}</a></td>
            <td>${u.password}</td>
            <td>${u.nickname}</td>
            <td><a href="${u.id}/delete">删除</a></td>
            <td><a href="${u.id}/update">更新</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3" align="center"><a href="/group/groups">用户组展示</a></td>

        <td colspan="2" align="center"><a href="/user/add">添加用户</a></td>
        <td colspan="1" align="center"><a href="/logout">退出</a></td>
    </tr>
</table>
</body>
</html>
