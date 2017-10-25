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

<table width = 100% border="1">
    <tr>
        <td><c:out value="Section ID" /></td>
        <td><c:out value="Section Name" /></td>
        <td><c:out value="Course" /></td>
        <td><c:out value="Block" /></td>
    </tr>
    <c:forEach items="${sections}" var="section">
        <tr>
            <td ><c:out value="${section.section_id}" /></td>
            <td><c:out value="${section.sectionName}" /></td>
            <td><c:out value="${section.course}" /></td>
            <td><c:out value="${section.block}" /></td>
        </tr>

    </c:forEach>

</table>
<%@ include file="fragment/footer.html"%>
</body>
</html>