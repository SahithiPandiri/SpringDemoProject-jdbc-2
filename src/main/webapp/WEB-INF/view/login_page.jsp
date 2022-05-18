<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginpage.css" type="text/css">
  </head>
  <body>
    <div class="center">
      <h1>Login please</h1>
      <form action="${pageContext.request.contextPath}/authenticateTheUser"<
      						  method="POST">
              <c:if test="${param.error != null}">
                         Invalid username and password.
              </c:if>
              <c:if test="${param.logout != null}">
              You have been logged out.
              </c:if>
        <div class="txt_field">
          <input type="text"  name="username"  required>
          <span></span>
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" name="password"  required>
          <span></span>
          <label>Password</label>
        </div>
        <input type="submit" value="Login">

        						<input type="hidden"
        							   name="${_csrf.parameterName}"
        							   value="${_csrf.token}" />
      </form>
    </div>

  </body>
</html>
