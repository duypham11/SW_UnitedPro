<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duong Truong
  Date: 10/15/2017
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>View Student</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td><c:out value="Student ID" /></td>
        <td><c:out value="First Name" /></td>
        <td><c:out value="Last Name" /></td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.student_id}" /></td>
            <td><c:out value="${student.firstName}" /></td>
            <td><c:out value="${student.lastName}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
