<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Entry Management</title>
</head>
<body>
<spring:url value="/admin/add" var="addURL"/>
<a href="${addURL }">Add New Entry</a>

<%@ include file="fragment/header.html"  %>

<table width = 100% border="1">
	<tr>
		<td>Entry Name: </td>
		<td>Number FPP: </td>
		<td>Number MPP: </td>
		<td>Number OPT FPP: </td>
		<td>Number OPT MPP: </td>
		<td>Number US Residence: </td>
	</tr>
	<c:forEach items="${entries}" var="entry">
		<td>${entry.entryName } </td>
		<td>${entry.noFPP} </td>
		<td>${entry.noMPP} </td>
		<td>${entry.noOPTFPP} </td>
		<td>${entry.noOPTMPP} </td>
		<td>${entry.noOfUSRes} </td>
		<td>${entry.noOfUSRes + entry.noFPP + entry.noMPP + entry.noOPTFPP + entry.noOPTMPP} </td>
		<td>
			<spring:url value="/admin/update/${entry.entry_id }" var="updateURL" />
			<a href="${updateURL }" >Update</a>
		</td>
		<td>
			<spring:url value="/admin/delete/${entry.entry_id }" var="deleteURL" />
			<a href="${deleteURL }" >Delete</a>
		</td>		
	</c:forEach>
	
</table>

<%@ include file="fragment/footer.html"%>
 </body>
</html>