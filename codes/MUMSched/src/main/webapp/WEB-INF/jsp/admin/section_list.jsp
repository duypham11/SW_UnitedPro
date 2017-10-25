<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Section Management</title>
</head>
<body>


<%@ include file="../fragment/header.html"  %>

<spring:url value="/admin/add_section" var="addSectionURL"/>
<a href="${addSectionURL}">Add New Section</a>

<table width = 100% border="1">
	<tr>
		<td>Section Name: </td>
		<td>Room: </td>
		<td>Available Seats: </td>
		<td>Course: </td>
		<td>Block: </td>

		<td colspan="2">Action</td>
	</tr>
	<c:forEach items="${section_list}" var="section">
	<tr>
		<td>${section.sectionName} </td>
		<%-- <td>${section.facultys.firstName} + " " ${section.facultys.lastName}</td> --%>
		<td>${section.roomNo} </td>
		<td>${section.availableSeats}</td>
		<td>${section.course.courseName}</td>
		<td>${section.block.blockName}</td>

 		<td>
			<spring:url value="/admin/update_section/${section.section_id}" var="updateSectionURL" />
			<a href="${updateSectionURL}">Update</a>
		</td>
		<td>
			<spring:url value="/admin/delete_section/${section.section_id}" var="deleteSectionURL" />
			<a href="${deleteSectionURL}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

<%@ include file="../fragment/footer.html"%>
 </body>
</html>