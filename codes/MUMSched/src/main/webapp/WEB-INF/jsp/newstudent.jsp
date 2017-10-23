<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Create new Student</title>
</head>
<body>

<%@ include file="fragment/header.html"  %>

<form action="savestudent" method="post">
    First Name: <input type="text" name="firstName" id="firstName">
    Last Name: <input type="text" name="lastName" id="lastName">
    Date of Birth: <input type="date" name="DOB" id="DOB">
    Password: <input type="password" name="password", id="password">
    Email: <input type="email" name="email" id="email">
    <input type="submit" value="Submit">
  </form>


<%@ include file="fragment/footer.html"%>
 </body>
</html>