<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Block Management</title>
</head>
<body>


<%@ include file="../fragment/header.html"  %>

<spring:url value="/admin/add_course" var="addCourseURL"/>
<a href="${addCourseURL}">Add New Course</a>

<table width = 100% border="1">
	<tr>
		<td>Course Code: </td>
		<td>Course Name: </td>
		<td>Course Description: </td>

		<td colspan="2">Action</td>
	</tr>
	<c:forEach items="${course_list}" var="course">
	<tr>
		<td>${course.courseCode} </td>
		<td>${course.courseName} </td>
		<td>${course.courseDescription} </td>

 		<td>
			<spring:url value="/admin/update_course/${course.course_id}" var="updateCourseURL" />
			<a href="${updateCourseURL}">Update</a>
		</td>
		<td>
			<spring:url value="/admin/delete_course/${course.course_id}" var="deleteCourseURL" />
			<a href="${deleteCourseURL}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

<%@ include file="../fragment/footer.html"%>
 </body>
</html>