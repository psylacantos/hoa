/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BillingDao;
import dao.DuesDao;
import dao.PropertiesDao;
import dao.TransactionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Billing;
import model.TrxReferences;
import java.util.Date;
import model.MonthlyDues;
import model.Ref_Properties;
import model.Transaction_Journal;
/**
 *
 * @author eabiii
 */
@WebServlet(name = "addBills", urlPatterns = {"/addBills"})
public class addBills extends HttpServlet {
private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    /**
     * This will execute the add bill by using the POST method
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //int billID=Integer.parseInt(request.getParameter("billID"));
        int billID=BillingDao.getMaxID()+1;
        int blockNum=Integer.parseInt(request.getParameter("blockNum"));
        int lotNum=Integer.parseInt(request.getParameter("lotNum"));
       // double amount=Double.parseDouble(request.getParameter("amt"));
        //double interest=Double.parseDouble(request.getParameter("inter"));   
        //double totalPaid=Double.parseDouble(request.getParameter("totalPaid"));
        double totalDue=Double.parseDouble(request.getParameter("totalDue"));
        String desc=request.getParameter("desc");
        System.out.println("My desc is" +desc);
           boolean test=false;
         //   request.setAttribute("msg", "Total Paid not equal to Total Amount");
         // request.getRequestDispatcher("FA_BillCo_DefaultPage.jsp").forward(request, response);

        for(Ref_Properties p: PropertiesDao.getRef_Properties())
        {
            if(p.getBlockNum()==blockNum && p.getLotNum()==lotNum)
            {
                test=true;
            }
        }
        int pb=BillingDao.getPrecedentBill(blockNum, lotNum);
        
        if(test==true){
            if (pb==-1){
                Billing bill=new Billing(billID,blockNum,lotNum,billID,totalDue,0,desc,"Pending");
            if(BillingDao.addNewBill(bill))
            {

                Calendar cal = Calendar.getInstance();
                cal.clear(Calendar.HOUR_OF_DAY);
                cal.clear(Calendar.AM_PM);
                cal.clear(Calendar.MINUTE);
                cal.clear(Calendar.SECOND);
                cal.clear(Calendar.MILLISECOND);
                Date d=cal.getTime();
                int id=TransactionDao.getMaxTrxID()+1;
                TrxReferences trx=new TrxReferences(id,totalDue,0,totalDue,d);
                
                
                Transaction_Journal tj= new Transaction_Journal(TransactionDao.getMaxTJID()+1,d,totalDue,0,"Pending");
                if(TransactionDao.addTransactionReference(trx)){
                    TransactionDao.addTrxJournal(tj);
                    if(BillingDao.addBillingDetails(billID, trx.getTrxID(),"Pending")){
                System.out.println("My id is" +id);
                try{
                MonthlyDues md=null;
                for(MonthlyDues m: DuesDao.md())
                {
                    
                }
                }catch(Exception e){
                    
                }
                request.getRequestDispatcher("FA_BillCo_DefaultPage.jsp").forward(request, response);
                    }

                    }
                else
                    {
                        request.setAttribute("msg", "Block Number or Lot Number Does Not Exist!");
                         request.getRequestDispatcher("FA_BillCo_AddBill.jsp").forward(request, response);

                    }
            }
            
        }
            else
            {
                    Billing bill=new Billing(billID,blockNum,lotNum,pb,totalDue,0,desc,"Pending");
            if(BillingDao.addNewBillPB(bill))
            {

                Calendar cal = Calendar.getInstance();
                cal.clear(Calendar.HOUR_OF_DAY);
                cal.clear(Calendar.AM_PM);
                cal.clear(Calendar.MINUTE);
                cal.clear(Calendar.SECOND);
                cal.clear(Calendar.MILLISECOND);
                Date d=cal.getTime();
                int id=TransactionDao.getMaxTrxID()+1;
                TrxReferences trx=new TrxReferences(id,totalDue,0,totalDue,d); 
                Transaction_Journal tj= new Transaction_Journal(TransactionDao.getMaxTJID()+1,d,totalDue,0,"Pending");
                if(TransactionDao.addTransactionReference(trx)){
                    TransactionDao.addTrxJournal(tj);
                    if(BillingDao.addBillingDetails(billID, trx.getTrxID(),"Pending")){
                System.out.println("My id is" +id);
                request.getRequestDispatcher("FA_BillCo_DefaultPage.jsp").forward(request, response);
                    }

                    }
                else
                    {
                        request.setAttribute("msg", "Block Number or Lot Number Does Not Exist!");
                         request.getRequestDispatcher("FA_BillCo_AddBill.jsp").forward(request, response);

                    }
            }
            
            }
            
        }
        else
        {
        request.setAttribute("msg", "Block Number or Lot Number Does Not Exist!");
                         request.getRequestDispatcher("FA_BillCo_AddBill.jsp").forward(request, response);

        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
