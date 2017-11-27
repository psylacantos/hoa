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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Billing;
import model.PaymentDetails;
import model.Transaction_Journal;
import model.TrxReferences;

/**
 *
 * @author eabiii
 */
@WebServlet(name = "viewBills", urlPatterns = {"/viewBills"})
public class viewBills extends HttpServlet {

    public viewBills()
    {
        super();
    }
    
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
          System.out.println("done");
        processRequest(request, response);
        int id=Integer.parseInt(request.getParameter("id"));
        Billing bill=null;
        TrxReferences transact=null;
        boolean boo=false;
          System.out.println("id ko"+id);
        
        try{
        for(Billing b:BillingDao.getBilling()){
           // int bal=BillingDao.getBillingID(b.getID());
            //System.out.println("id kao"+ bal);
            if(BillingDao.getBillingID(b.getID())==id)
            {
                 
                bill=b;
                System.out.println("My ID"+bill.getID());
            }
        }
                for(TrxReferences tr:TransactionDao.getTransactionReferences()){
                    System.out.println("trx is "+tr.getTrxID());
                    if(TransactionDao.getTrxID(tr.getTrxID(), bill.getID())==(tr.getTrxID()))
                    {
                        transact=tr;
                         System.out.println("My Rrx ID "+transact.getTrxID());
                         System.out.println("My Bill ID "+bill.getID());
               
                         boo=true;
                         if(boo==true){   
                             
                System.out.println("done23");
                request.setAttribute("bill", bill);
               request.setAttribute("pay",transact);
                request.getRequestDispatcher("FA_BillCo_ViewDetails.jsp").forward(request, response);
         }
                    }
                    
                }
                
                
               // System.out.println("Bill id is"+b.getID());
               
                
            
            
           
      
        
        }catch (Exception e){}
        
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
