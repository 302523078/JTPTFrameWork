<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
</head>

<body>
登录用户：${user.userName}
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.sysUserId}</td>
            <td>${user.userName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
