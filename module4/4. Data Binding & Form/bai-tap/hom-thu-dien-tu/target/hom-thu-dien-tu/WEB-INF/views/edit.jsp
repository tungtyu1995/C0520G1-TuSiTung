<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2020
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/email/edit" modelAttribute="email">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td><form:label path="languages">languages:</form:label></td>
            <td><form:select path="languages" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${listPageSize}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter" value="Enable"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="edit"/></td>
            <td>
                <button type="button"/>
                <a href="/email" style="text-decoration: none">Cancel</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>