

<%@page import="dao.TransactionDao"%>
<%@page import="model.MonthlyDues"%>
<%@page import="model.HouseMonthlyDues"%>
<%@page import="dao.PropertiesDao"%>
<%@page import="model.Ref_Properties"%>
<%@page import="model.TrxReferences"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BillingDao" %>
<%@page import="dao.DuesDao,model.Billing,model.PaymentDetails,dao.BillingDao,dao.dbconnect,java.util.ArrayList" %>
<%
    ArrayList<Ref_Properties>ref=PropertiesDao.getRef_Properties();
ArrayList<HouseMonthlyDues>house=DuesDao.hmd();    
ArrayList<MonthlyDues>monthly=DuesDao.md(); 
ArrayList<TrxReferences>trx=TransactionDao.getTransactionReferences();
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
 <div style="padding:1px 16px;height:500px;">
     <center><h1>Monthly Dues</h1></center>
  <form action="viewBill" method="post">
      
 </form>
<div>
    <table>
  <tr>
   <th><center>Block Number</th>
      <th><center>Lot Number</th>    
   <th><center>Amount</th>
   <th><center>Transaction Date</th>
   <th><center></th>

  </tr>
  <tr>
<%  for(Ref_Properties r:ref){  
        for(HouseMonthlyDues hm:house){
            
        
        for(MonthlyDues m:monthly){    
        if(r.getBlockNum()==hm.getBlockNum()&&r.getLotNum()==hm.getLotNum()&&hm.getMdID()==m.getMdID()){

%>
<td><center><%=r.getBlockNum()%></td>
<td><center><%=r.getLotNum()%></td>
<td><center><%=m.getAmount()%></td>
<td><center><%=m.getMonth()%> <%=m.getYear()%></td>
<td><center><a href="viewMonthly?id=<%=hm.getTrxID()%>"><input type="button" class="btn btn-primary" value="View"></a></td>
</tr>
<%}}}}%>
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
