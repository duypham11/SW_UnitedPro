<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Register Section</title>
</head>
<body>

<%@ include file="fragment/header.html"  %>

<form action="register" method="post">
    Section ID: <input type="text" name="sectionId" id="sectionId">
    <input type="submit" value="Submit">
</form>


<%@ include file="fragment/footer.html"%>
</body>
</html>