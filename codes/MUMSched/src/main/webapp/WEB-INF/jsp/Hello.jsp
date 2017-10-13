<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Spring Boot JSP</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<button class="btn btn-success">
    <span class="glyphicon glypicon-ok"></span> OK
</button>

<textarea class="hehe" id="text1" cols="30" rows="10"></textarea>">

</textarea>
 
  <h3> Hello <c:out value="${name}"/>! --- Welcome to Spring Boot with JSP Demo</h3>
 
 </body>
</html>