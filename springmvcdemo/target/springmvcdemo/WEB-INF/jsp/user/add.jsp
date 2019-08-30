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

<sf:form method="post" modelAttribute="user">
    <table width="700" align="center" border="1">
        <tr>
            <td>用户名:</td>
            <td><sf:input path="username"/>
            </td>
        </tr>
        <tr>
            <td>用户密码:</td>
            <td><sf:password path="password"/></td>
        </tr>
        <tr>
            <td>用户昵称:</td>
            <td><sf:input path="nickname"/></td>
        </tr>

        <tr>
            <td>用户组</td>
            <td>
                <sf:select path="group.id">
                    <c:forEach var="g" items="${groups}">
                        <sf:option value="${g.id}">${g.groupname}</sf:option>
                    </c:forEach>
                </sf:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="用户添加"/>
            </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
