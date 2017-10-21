<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Entry Management - Admin Page</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<%@ include file="fragment/header.html"  %>

<form action="entryadmin" method="post">
    Entry Name: <input type="text" name="entryName" id="entryName">
    Number FPP: <input type="number" name="noFPP" id="noFPP">
    Number MPP: <input type="number" name="noMPP" id="noMPP">
    Number OPT FPP: <input type="number" name="noOPTFPP", id="noOPTFPP" value=0>
    Number OPT MPP: <input type="number" name="noOPTMPP" id="noOPTMPP" value=0>
    Number US Residence: <input type="number" name="noOfUSRes" id="noOfUSRes" value=0>
    <input type="submit" value="Submit">
  </form>
  
<form action="entryadmin" method="get">

<table style="border: 2px solid;">
    <tr>
        <td><c:out value="Entry Name" /></td>
        <td><c:out value="Number FPP" /></td>
        <td><c:out value="Number MPP" /></td>
        <td><c:out value="Number OPT FPP" /></td>
        <td><c:out value="Number OPT MPP" /></td>
        <td><c:out value="Number US Residence" /></td>
        <td><c:out value="Total" /></td>
        
    </tr>
    <c:forEach items="${entries}" var="entry">
        <tr>
            <td><c:out value="${entry.entryName}" /></td>
            <td><c:out value="${entry.noFPP}" /></td>
            <td><c:out value="${entry.noMPP}" /></td>
            <td><c:out value="${entry.noOPTFPP}" /></td>
            <td><c:out value="${entry.noOPTMPP}" /></td>
            <td><c:out value="${entry.noOfUSRes}" /></td>
            <td><c:out value="${entry.noOfUSRes + entry.noFPP + entry.noMPP + entry.noOPTFPP + entry.noOPTMPP}" /></td>
        </tr>
    </c:forEach>
</table>

</form>


<%@ include file="fragment/footer.html"%>
 </body>
</html>