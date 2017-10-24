<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Block Management</title>
</head>
<body>
<spring:url value="/admin/save_block" var="saveBlockURL"/>


<%@ include file="../fragment/header.html"  %>

<form:form action="${saveBlockURL}" method="POST" modelAttribute ="blockForm">
	<form:hidden path = "block_id"/>
	<table>
		<tr>
			<td>Block Name: </td>
			<td><form:input path="blockName"/>
		</tr>
		<tr>
			<td>Start Date: </td>
			<td><form:input type="date" path="startDate"/>
		</tr>
		<tr>
			<td>End Date: </td>
			<td><form:input type="date" path="endDate"/>
		</tr>		

		<tr>
			<td>Entry: </td> 
 			<td>
			<form:select path="${EntryList.entryName}">
			<form:option value="NONE"> --SELECT--</form:option>
			<form:options items="${EntryList}"></form:options>
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