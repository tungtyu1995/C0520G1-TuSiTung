
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 9/9/2020--%>
<%--  Time: 3:52 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="user?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table style="border-collapse: collapse" border="1" cellpadding="5">
            <caption>
                <h2>
                    Delete User
                </h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${user.country}' />"
                    />
                </td>
            </tr>
            <tr>
            <tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="user?action=users"><input type="button" value="Done"></a>
                    <input type="submit" value="Delete"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>