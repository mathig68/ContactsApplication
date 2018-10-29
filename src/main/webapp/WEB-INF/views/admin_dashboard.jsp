<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Contact Application</title>
</head>
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
					<h1>Admin_Dashboard</h1>
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