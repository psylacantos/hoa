

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BillingDao" %>
<%@page import="servlet.addBills,model.Billing,dao.BillingDao,dao.dbconnect,java.util.ArrayList" %>
<%
ArrayList<Billing>bill=BillingDao.getBilling();
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
  <div style="margin-left:30%;padding:1px 16px;height:500px;">

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

    <div style="padding:1px 16px;height:500px;">
        <h1>Add Bill</h1>
     <form action="addBills" method="POST">
         
        <b><p>Block No:</p></b>
        <input type="number" id="bln" min="1"  name="blockNum" placeholder="Block" required>
        <b><p>Lot No:</p></b>
        <input type="number" id="lno" min="1"  name="lotNum" placeholder="Lot" required>
        <b><p>Description:</b></p>
        <input type="text" name="desc" class="form-control" placeholder="Description" required autofocus>
        <b><p>Amount:</b></p>
        <input type="number" step="any" min="0" id="amt" name="totalDue" placeholder="totalDue" onchange="filters()" required >
      <!--  <b><p>Interest:</b></p>
        <input type="number" step="any" min="0" id="inter" name="inter" placeholder="Interest" onchange="filters()" required >
     
        <b><p>Total Amount:</b></p>
        <input type="number" min="0" id="totalamt" name="totalDue" placeholder="0" autofocus readonly>
        <b><p>Total Paid</b></p>
        <input type="number" min="0" step="any" id="pay" name="totalPaid" placeholder="0" autofocus >
       -->
        <input type="submit" id="addb" value="Add Bill">
        <a href="FA_BillCo_ViewBill.jsp"><input type="button" name="Go Back" value="Go Back"></a>
        </form>
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
