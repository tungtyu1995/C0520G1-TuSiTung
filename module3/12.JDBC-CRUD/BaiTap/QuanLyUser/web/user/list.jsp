<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2020
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <a href="/user?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/user" >
        <input type="hidden" name="action" value="find">
        <input type="text" name="name" id="name">
        <input type="submit" value="search by name">
    </form>
</div>
<div align="center">
    <table style="border-collapse: collapse" border="1" cellpadding="5" >
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><a href="/user?action=edit&id=${user.id}"><c:out value="${user.name}"/></a></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/user?action=edit&id=${user.id}">Edit</a>
                    <a href="/user?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>