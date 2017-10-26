<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Block Management</title>
</head>
<body>


<%@ include file="../fragment/header.html"  %>

<spring:url value="/admin/add_block" var="addBlockURL"/>
<a href="${addBlockURL}">Add New Block</a>
	
<table width = 100% border="1">
	<tr>
		<td>Block Name: </td>
		<td>Start Date: </td>
		<td>End Date: </td>
		<td>Entry: </td>
		<td>Number Sections: </td>
		<td>Sections: </td>
		<td colspan="2">Action</td>
	</tr>
	<c:forEach items="${block_list}" var="block">
	<tr>
		<td>${block.blockName} </td>
		<td>${block.startDate} </td>
		<td>${block.endDate} </td>
		<td>${block.entry.entryName}</td>
		<td>${fn:length(block.sections)}</td>
		<td>
		<%! 
			String sections ="";
		%>
		<form:hidden>
		    <c:forEach items="${block.sections}" var="section"> 
		       ${section.sectionName}; 
    		</c:forEach>
		</form:hidden>
		</td>
		
 		<td>
			<spring:url value="/admin/update_block/${block.block_id}" var="updateBlockURL" />
			<a href="${updateBlockURL}">Update</a>
		</td>
		<td>
			<spring:url value="/admin/delete_block/${block.block_id}" var="deleteBlockURL" />
			<a href="${deleteBlockURL}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

<%@ include file="../fragment/footer.html"%>
 </body>
</html>