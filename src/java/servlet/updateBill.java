/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BillingDao;
import dao.TransactionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BillingDetails;
import model.PaymentDetails;
import model.Transaction_Journal;
import model.TrxList;

/**
 *
 * @author eabiii
 */
@WebServlet(name = "updateBill", urlPatterns = {"/updateBill"})
public class updateBill extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
      
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int billID=Integer.parseInt(request.getParameter("billId"));
        int trxID=Integer.parseInt(request.getParameter("trxId"));
        String status=request.getParameter("status");
        double amount=Double.parseDouble(request.getParameter("amount")); 
        double interest=Double.parseDouble(request.getParameter("interest")); 
        double total=Double.parseDouble(request.getParameter("totalAmount")); 
        BillingDetails bi=null;
        Calendar cal = Calendar.getInstance();
                cal.clear(Calendar.HOUR_OF_DAY);
                cal.clear(Calendar.AM_PM);
                cal.clear(Calendar.MINUTE);
                cal.clear(Calendar.SECOND);
                cal.clear(Calendar.MILLISECOND);
                Date d=cal.getTime();
        if(status=="Pending")
        {
            
        }
        else if(BillingDao.updateBill(billID, total, interest, status))
        {
            BillingDao.updateDetails(status, billID, trxID);
            Transaction_Journal tj=new Transaction_Journal(TransactionDao.getMaxTJID()+1,d,total,total,status);
            TransactionDao.addTrxJournal(tj);
            TrxList tl=new TrxList(tj.getJournalID(),trxID,total,status);
            TransactionDao.addTrxList(tl);
            PaymentDetails pd=new PaymentDetails(billID,tj.getJournalID(),trxID,status);
            BillingDao.addPaymentDetails(billID, tj.getJournalID(), trxID, status);
            if(TransactionDao.updateTransactionReference(trxID, total, interest))
            {
             request.getRequestDispatcher("FA_BillCo_DefaultPage.jsp").forward(request, response);

            }
            

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
