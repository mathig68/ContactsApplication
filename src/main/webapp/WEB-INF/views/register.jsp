<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div id="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<jsp:include page="include/leftbar.jsp"></jsp:include>
			</div>
			<div class="col-sm-8 text-left">
				<div class="container-fluid text-center">
					<form:form id="regForm" modelAttribute="user"
						action="registerProcess" method="post">
						<table>
							<tr>
								<td><form:label class="form-group" path="firstname">First Name</form:label></td>
								<td><form:input class="form-control" path="firstname"
										name="firstname" id="firstname"	placeholder="John" /></td>

							</tr>
							<tr>
								<td><form:label class="form-group" path="lastname">LastName</form:label></td>
								<td><form:input class="form-control" path="lastname"
								name="lastname" placeholder="Doe" id="lastname" /></td>
							</tr>
							<tr>
								<td><form:label class="form-group" path="username">User Name</form:label></td>
								<td><form:input class="form-control" path="username"
										name="username" id="username" /></td>
							</tr>
							<tr>
								<td><form:label class="form-group" path="password">Password</form:label></td>
								<td><form:password path="password" name="password"
										id="password" /></td>
							</tr>
							<tr>
								<td><form:label class="form-group" path="email">Email</form:label></td>
								<td><form:input class="form-control" path="email" placeholder="email@example.com"
										name="email" id="email" /></td>
							</tr>
							<tr>
								<td><form:label path="address">Address</form:label></td>
								<td><form:input path="address" name="address" id="address" />
								</td>
							</tr>
							<tr>
								<td><form:label class="form-group" path="phone">Phone</form:label></td>
								<td><form:input class="form-control" path="phone"
										name="phone" id="phone" /></td>
							</tr>
							<tr>
								<td><form:label class="form-group" path="loginStatus">Login Status</form:label></td>
								<td><form:input class="form-control" path="loginStatus"
										name="loginStatus" id="loginStatus" /></td>
							</tr>
							<tr>
								<td><form:label class="form-group" path="role">Role</form:label></td>
								<td><form:input class="form-control" path="role"
										name="role" id="role" /></td>
							</tr>
							<tr>
								<td></td>
								<td><form:button class="btn btn-primary" id="register"
										name="register">Register</form:button></td>
							</tr>
							<tr></tr>
							<tr>
								<td></td>
								<td><a href="home">Home</a></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<div id="rightbar" class="col-sm-2 sidenav">
				<div class="well">
					<jsp:include page="include/rightbar.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	<div id="footer" class="footer">
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>