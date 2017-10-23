<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Edit Faculty</title>
</head>
<body>

<%@ include file="fragment/header.html"  %>

<h1>Student ID: ${facultyId}</h1>

<form action="editfaculty" method="post" var="${faculty}">
    First Name: <input type="text" name="firstName" id="firstName" value="${faculty.firstName}">
    Last Name: <input type="text" name="lastName" id="lastName" value="${faculty.lastName}">
    Date of Birth: <input type="date" name="DOB" id="DOB" value="${faculty.DOB}">
    Password: <input type="password" name="password", id="password" value="${faculty.password}">
    Email: <input type="email" name="email" id="email" value="${faculty.email}">
    <input type="submit" value="Submit">
  </form>

<button onclick="myFunction(${facultyId})">Delete</button>


<%@ include file="fragment/footer.html"%>

<script>
    function myFunction(facultyId) {
        var url = "http://localhost:8080/" + facultyId + "/" + "deletefaculty";
        window.location.assign(url)
    }
</script>
 </body>
</html>