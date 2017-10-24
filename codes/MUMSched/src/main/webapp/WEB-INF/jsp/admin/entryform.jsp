<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Entry Management</title>
</head>
<body>
<spring:url value="/admin/save_entry" var="saveEntryURL"/>


<%@ include file="../fragment/header.html"  %>

<form:form action="${saveEntryURL}" method="POST" modelAttribute ="entryForm">
	<form:hidden path = "entry_id"/>
	<table>
		<tr>
			<td>Entry Name: </td>
			<td><form:input path="entryName"/>
		</tr>
		<tr>
			<td>Number FPP: </td>
			<td><form:input type="number" path="noFPP"/>
		</tr>
		<tr>
			<td>Number MPP: </td>
			<td><form:input type="number" path="noMPP"/>
		</tr>		
		<tr>
			<td>Number OPT FPP: </td>
			<td><form:input type="number" path="noOPTFPP"/>
		</tr>
		<tr>
			<td>Number OPT MPP: </td>
			<td><form:input type="number" path="noOPTMPP"/>
		</tr>		
		<tr>
			<td>Number US Resident: </td>
			<td><form:input type="number" path="noOfUSRes"/>
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