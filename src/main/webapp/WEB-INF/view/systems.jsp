<%@ taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html xmlns:c="">
<head>
    <title>list of employees</title>
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
<h2>Your Details</h2>
    </div>
</div>
<div id="container">
    <div id="content">

        <table>
            <tr>
                <th>User_Id</th>
                <th>User_name</th>
                 <th>First Name</th>
                  <th>Last Name</th>
                  <th>Action</th>


            </tr>

                <c:url var="updateLink" value="/customer/getSingleEmployee">
                    <c:param name="user_id" value="${tempAccount.user_id}"/>
                </c:url>

                 <tr>
                     <td>${tempAccount.user_id}</td>
                     <td>${tempAccount.user_name}</td>
                      <td>${tempAccount.first_name}</td>
                        <td>${tempAccount.last_name}</td>
                     <td>
                     <a href="${updateLink}">Update</a>
                     </td>

                 </tr>
        </table>
    </div>
</div>
<br><br>
 <a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>