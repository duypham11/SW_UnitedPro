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
    <title>View Faculty</title>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<%@ include file="fragment/header.html"  %>
<table width = 100% border="1">
    <tr>
        <td><c:out value="Faculty ID" /></td>
        <td><c:out value="First Name" /></td>
        <td><c:out value="Last Name" /></td>
        <td><c:out value="Email" /></td>
    </tr>
    <c:forEach items="${faculties}" var="faculty">
        <tr onclick="myFunction(${faculty.faculty_id})">
            <td ><c:out value="${faculty.faculty_id}" /></td>
            <td><c:out value="${faculty.firstName}" /></td>
            <td><c:out value="${faculty.lastName}" /></td>
            <td><c:out value="${faculty.email}" /></td>
        </tr>

    </c:forEach>

</table>
<%@ include file="fragment/footer.html"%>
<script>
    function myFunction(facultyId) {
        var url = "http://localhost:8080/" + facultyId + "/" + "editfaculty";
        window.location.assign(url)
    }
</script>
</body>
</html>
