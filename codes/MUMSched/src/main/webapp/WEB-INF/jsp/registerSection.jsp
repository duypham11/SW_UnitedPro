<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Spring Boot JSP</title>
</head>
<body>

<%@ include file="fragment/header.html"  %>

<form action="success" method="post">
    Section ID: <input type="text" name="sectionID" id="sectionID">
    <input type="submit" value="Submit">
  </form>

<h3<c:out value="${sectionId}"></c:out>></h3>

<%@ include file="fragment/footer.html"%>
 </body>
</html>