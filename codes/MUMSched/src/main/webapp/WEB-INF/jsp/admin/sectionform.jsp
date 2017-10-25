<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Section Management</title>
</head>
<body>
<spring:url value="/admin/save_section" var="saveSectionURL"/>


<%@ include file="../fragment/header.html"  %>

<form:form action="${saveSectionURL}" method="POST" modelAttribute ="sectionForm">
	<form:hidden path = "section_id"/>
	<table>
			<tr>
			<td>Course: </td> 
 			<td>
			<form:select path="course" modelAttribute ="course">
			<form:option value="0 "> --SELECT--</form:option>
			<form:options items="${courseList}" itemValue="course_id" itemLabel="courseName"/>
			</form:select>
			</td>	
		</tr>
		<tr>
			<td>Section Name: </td>
			<td><form:input path="sectionName"/>
		</tr>
		<tr>
			<td>Room: </td>
			<td><form:input type="text" path="roomNo"/>
		</tr>
		<tr>
			<td>Available Seats: </td>
			<td><form:input type="number" path="availableSeats"/>
		</tr>		
		<tr>
			<td>Block: </td> 
 			<td>
			<form:select path="block" modelAttribute ="block">
			<form:option value="0 "> --SELECT--</form:option>
			<form:options items="${blockList}" itemValue="block_id" itemLabel="blockName"/>
			</form:select>
			</td>	
		</tr>
		<tr>
			<td> </td>
			<td><button type="submit">Save</button>
		</tr>
	
	</table>
</form:form>
	

<%@ include file="../fragment/footer.html"%>
 </body>
</html>