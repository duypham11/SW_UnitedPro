<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Edit Student</title>
</head>
<body>

<%@ include file="fragment/header.html"  %>

<h1>Student ID: ${studentId}</h1>

<form action="editstudent" method="post" var="${student}">
    First Name: <input type="text" name="firstName" id="firstName" value="${student.firstName}">
    Last Name: <input type="text" name="lastName" id="lastName" value="${student.lastName}">
    Date of Birth: <input type="date" name="DOB" id="DOB" value="${student.DOB}">
    Password: <input type="password" name="password", id="password" value="${student.password}">
    Email: <input type="email" name="email" id="email" value="${student.email}">
    <input type="submit" value="Submit">
  </form>


<%@ include file="fragment/footer.html"%>
 </body>
</html>