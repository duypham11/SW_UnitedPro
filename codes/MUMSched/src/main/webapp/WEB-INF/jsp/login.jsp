<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
<title>Login Form</title>
</head>
<body>
	<div style="align: center" class="container">
		<c:if test="${param.error ne null}">
			<div>
				<label style="color: red">Invalid username and password! </br></label>
			</div>
		</c:if>
		<c:if test="${param.logout ne null}">
			<div>
				<label style="color: red"> Logged out successfully! Login again to use service: </br> </label>
			</div>
		</c:if>

		<form action="/login" method="post">

			<table class="table table-striped">
				<tr>
					<td width=100><label> User Name: <input type="text"
							name="username" />
					</label></td>
				</tr>
				<tr>
					<td width=100><label> Password:  <input type="password"
							name="password" />
					</label></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-default">Sign In</button>
					</td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>