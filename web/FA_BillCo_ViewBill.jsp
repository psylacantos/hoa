

<%@page import="model.BillingDetails"%>
<%@page import="model.TrxReferences"%>
<%@page import="dao.TransactionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BillingDao" %>
<%@page import="model.Billing,dao.BillingDao,dao.dbconnect,java.util.ArrayList" %>
<%
ArrayList<Billing>bill=BillingDao.getBilling();
ArrayList<TrxReferences>tx=TransactionDao.getTransactionReferences();
ArrayList<BillingDetails>bd=BillingDao.getDetails();
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
<% if(msg != null){ %>
<div class="row">
	<div class="col-lg-12">
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><i class="fa fa-info-circle"></i>  <strong><%= msg %></strong>
		</div>
	</div>
</div><!-- /.row -->
<% } %>
<center><h1>View Bill User!</h1></center>
  

</div>
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
   
    <table>
  <tr>
   <th><center>Block Number</th>
      <th><center>Lot Number</th>    
   <th><center>Description</th>
   <th><center>Amount</th>
   <th><center>Status</th> 
   <th><center>Date</th> 
   <th><center></th>

  </tr>
  <tr>
<%  for(Billing b:bill){ 
    

       for(TrxReferences t:tx){
           
       for(BillingDetails bi:bd){
           if(b.getID()==bi.getBillingID() &&t.getTrxID()==bi.getTrxID()){
       
%>
<td><center><%=b.getBlockNum()%></td>
<td><center><%=b.getLotNum()%></td>
<td><center><%=b.getDesc()%></td>
<td><center><%=b.getTotalDue()%></td>
<td><center><%=b.getStatus()%></td>
<td><center><%=t.getDate()%></td>
<td><center><a href="viewBills?id=<%=b.getID()%>"><input type="button" class="btn btn-primary" value="View"></a></td>
</tr>
<%}}}}%>
  </table>
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
