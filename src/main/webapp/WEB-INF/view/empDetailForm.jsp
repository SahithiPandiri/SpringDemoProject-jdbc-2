<%@ taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html xmlns:c="">
<head>
    <title>list of employees</title>
    <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/css/style.css"/>
    <style>
    table{
        width:82%;
        height:90px;
        	}
        	</style>
</head>
<body>
<div id="wrapper">
    <div id="header">
<h2>Employee Detail</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>




           </tr>
           <tr>
                     <td>${tempCustomer.first_name}</td>
                     <td>${tempCustomer.last_name}</td>


                 </tr>

        </table>
    </div>
</div>
<br><br>
 <p>
         <a href="${pageContext.request.contextPath}/payroll/accounts"/>Back to List</a>
     </p>
</body>
</html>