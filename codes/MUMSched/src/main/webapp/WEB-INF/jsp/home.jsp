<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Spring Security 3 JSP Taglibs- This is a secure page</title>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1251">
	<style>
		.dropbtn {
			background-color: #4CAF50;
			color: white;
			padding: 16px;
			font-size: 16px;
			border: none;
			cursor: pointer;
			width: 170px;
			text-align: center;
		}
		
		.dropdown {
			position: relative;
			display: inline-block;
		}
		
		.dropdown-content {
			display: none;
			position: absolute;
			background-color: #f9f9f9;
			min-width: 160px;
			box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
			z-index: 1;
		}
		
		.dropdown-content a {
			color: black;
			padding: 12px 16px;
			text-decoration: none;
			display: block;
		}
		
		.dropdown-content a:hover {
			background-color: #f1f1f1
		}
		
		.dropdown:hover .dropdown-content {
			display: block;
		}
		
		.dropdown:hover .dropbtn {
			background-color: #3e8e41;
		}
	</style>	
</head>
<body>
	<h1>Welcome to Maharishi University of Management</h1>
	<br />
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="dropdown">
		  <button class="dropbtn">USER PROFILE</button>
		  <div class="dropdown-content">
		    <a href="#">Create</a>
		    <a href="#">Read</a>
		    <a href="#">Update</a>
		    <a href="#">Delete</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">Course Admin</button>
		  <div class="dropdown-content">
		    <a href="#">Create</a>
		    <a href="#">View</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">Entry Admin</button>
		  <div class="dropdown-content">
		    <a href="/admin/add_entry">New Entry</a>
		    <a href="/admin/entry_list">View Entries</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">Block Admin</button>
		  <div class="dropdown-content">
		    <a href="/admin/add_block">New Block</a>
		    <a href="/admin/block_list">View Blocks</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">Section Admin</button>
		  <div class="dropdown-content">
		    <a href="/admin/add_section">New Section</a>
		    <a href="/admin/section_list">View Sections</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">GEN SCHEDULE</button>
		  <div class="dropdown-content">
		    <a href="#">Generate Schedule</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">SCHEDULE CRUD</button>
		  <div class="dropdown-content">
		    <a href="#">Create</a>
		    <a href="#">Read</a>
		    <a href="#">Update</a>
		    <a href="#">Delete</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">VIEW SCHEDULE</button>
		  <div class="dropdown-content">
		    <a href="#">View Schedule</a>
		  </div>
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_FACULTY')">
		<div class="dropdown">
		  <button class="dropbtn">PROFILE</button>
		  <div class="dropdown-content">
		    <a href="#">READ</a>
		    <a href="#">EDIT</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">VIEW SCHEDULE</button>
		  <div class="dropdown-content">
		    <a href="#">View Schedule</a>
		  </div>
		</div>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_STUDENT')">
		<div class="dropdown">
		  <button class="dropbtn">PROFILE</button>
		  <div class="dropdown-content">
		    <a href="editstudent">VIEW</a>
		  </div>
		</div>

		<div class="dropdown">
		  <button class="dropbtn">VIEW SCHEDULE</button>
		  <div class="dropdown-content">
		    <a href="#">View Schedule</a>
		  </div>
		</div>
		<div class="dropdown">
		  <button class="dropbtn">REG SECTION</button>
		  <div class="dropdown-content">
		    <a href="registersection">Register Section</a>
		  </div>
		</div>
	</sec:authorize>
	<br /><br /><br /><br />
	<div>
		<form action="/logout" method="post">
            <div style="padding-top: 30px;">
                     <span sec:authorize="isAuthenticated()">
                    <input type="submit" value="Sign Out" />
                               </span>
            </div>
        </form>	
	</div>
</body>
</html>
