<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
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
					 <form:form id="loginForm" 
					 action="{pageContext.request.contextPath}/login" method="post">
                <table>
                    <tr>
                        <td>
                            <form:label path="username">User name: </form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button  id="login" name="login">Login</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
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
