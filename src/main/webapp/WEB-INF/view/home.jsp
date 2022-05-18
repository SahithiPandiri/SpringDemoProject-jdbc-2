<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>

<head>
	<title> ZeMoSo Home Page</title>
	<style>
	marquee{
	background-color:Black;
	color:White;
	}
	body{
	text-align:center;
	background-color:LightGrey;
	font-family: Garamond, serif;
	font-size:20px;
	}
	</style>
</head>

<body>
	<h2> ZeMoSo Home Page</h2>
	<hr>
<marquee width="90%" direction="right" height="30px">
  <b>Welcome to the  company home page!</b>
</marquee>
	<hr>
	<h4>
	You are logged in as <security:authentication property="principal.username" var="username" />
	<br>
	<br>
	Your Designations are <security:authentication property="principal.authorities" />
	<br>
	<br>
	<p>${username}</p>
	<security:authorize access="hasRole('EMPLOYEE')">
	 <c:url var="DetailsLink" value="/customer/getMyDetails">
                        <c:param name="user_name" value="${username}"/>
                         </c:url>
                         <a href="${DetailsLink}">Get Details</a>
    	</security:authorize >
	<security:authorize access="hasRole('MANAGER')" >
	<p>To view/update/delete employees </p>
	<br><br>
	<a href="${pageContext.request.contextPath}/customer/list">Click Me</a>
	</security:authorize >
	<security:authorize access="hasRole('ADMIN')" >
	<p>To view/update/delete employees payroll</p>
	<a href="${pageContext.request.contextPath}/payroll/accounts">Click Me</a>
    	</security:authorize >
    	<br><br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="logout"/>
	</form:form>
</body>
</html>