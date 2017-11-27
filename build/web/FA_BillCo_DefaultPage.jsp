

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BillingDao" %>
<%@page import="model.Billing,dao.BillingDao,dao.dbconnect,java.util.ArrayList" %>
<%
ArrayList<Billing>bill=BillingDao.getBillingByStatus("Pending");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
 <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f2f3f3}
</style>
<br>
<br>
<br>
<% if(msg != null){ %>
<div class="row">
	<div class="col-lg-12">
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><i class="fa fa-info-circle"></i>  <strong><%= msg %></strong>
		</div>
	</div>
</div><!-- /.row -->
<% } %>
<center><h1>Welcome User!</h1></center>
    <center>  <h2>Today is:  <h2 id=date></h2><h2 id="time"></h2></h2></center>
   <center><h1>Pending Bills</h1></center>
    
    <script>
        function filters()
        {
            var input,filter,interest, filter2,total;
            input=document.getElementById("amt").value;
            //filter =input.value;
            interest=document.getElementById("inter").value;
            //filter2=interest.value;
            total=document.getElementById("totalamt");
            total.value=parseFloat(input);
          //  total.value=parseFloat(input)+parseFloat(interest);
            
            
        }
        
    </script>
    <div>
    <table>
  <tr>
   <th><center>Block Number</th>
      <th><center>Lot Number</th>    
   <th><center>Description</th>
   <th><center>Amount</th>
   <th><center>Status</th> 
   <th><center></th>

  </tr>
  <tr>
<%  for(Billing b:bill){    %>
<td><center><%=b.getBlockNum()%></td>
<td><center><%=b.getLotNum()%></td>
<td><center><%=b.getDesc()%></td>
<td><center><%=b.getTotalDue()%></td>
<td><center><%=b.getStatus()%><%=b.getID()%></td>
<td><center><a href="viewBills?id=<%=b.getID()%>"><input type="button" class="btn btn-primary" value="View"></a></td>
</tr>
<%}%>
  </table>
</div>
</body>

<script type="text/javascript">
        /*n =  new Date();
		y = n.getFullYear();
		m = n.getMonth() + 1;
		d = n.getDate();
		document.getElementById("date").innerHTML = m + "/" + d + "/" + y;
		*/
		var d = new Date();
		document.getElementById("date").innerHTML = d.toDateString();
		
		(function () {
    function checkTime(i) {
        return (i < 10) ? "0" + i : i;
    }

    function startTime() {
        var today = new Date(),
            h = checkTime(today.getHours()),
            m = checkTime(today.getMinutes()),
            s = checkTime(today.getSeconds());
        document.getElementById('time').innerHTML = h + ":" + m + ":" + s;
        t = setTimeout(function () {
            startTime()
        }, 500);
    }
    startTime();
})();
	</script>
</html>
