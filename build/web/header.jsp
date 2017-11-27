

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SW-ENGG</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
<body>
 
    
 <ul>
    
  <li><a href="Login.html">Log Out</a></li>

  <li style="float:left"><a href="logo">Logo</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Billing</a>
    <div class="dropdown-content">
        		<a href="FA_BillCo_AddBill.jsp">Add Bill</a>
                        <a href="FA_BillCo_ViewBill.jsp">View Bill</a>
                         <a href="FA_BillCo_ViewDetailsDone.jsp">View Monthly Bill</a>

                        
    </div>
  </li>
  <li><a href="FA_BillCo_DefaultPage.jsp">Dashboard</a></li>
</ul>

</body>
</html>
