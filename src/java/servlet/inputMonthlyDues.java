package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

import Objects.allProperties;
import Objects.houseMonthlyDues;
import Objects.monthlyDues;
import Objects.refMonthlyDues;
import Objects.trx_References;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kayle Tiu
 */
@WebServlet(urlPatterns = {"/inputMonthlyDues"})
public class inputMonthlyDues extends HttpServlet {

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
        String sDate = request.getParameter("startDate");
        String eDate = request.getParameter("endDate");
        String vMonthlyDues = request.getParameter("mDues");
        double mDues = Double.valueOf(vMonthlyDues);
        
        String stringStartMonth = sDate.substring(5, 7);
        String stringStartYear = sDate.substring(0, 4);
        String stringEndMonth = eDate.substring(5, 7);
        String stringEndYear = eDate.substring(0, 4);
        
        int sMonth = Integer.parseInt(stringStartMonth);
        int sYear =  Integer.parseInt(stringStartYear);
        int eMonth = Integer.parseInt(stringEndMonth);
        int eYear =  Integer.parseInt(stringEndYear);
        
        refMonthlyDues rmd1 = new refMonthlyDues(sMonth, sYear, eMonth, eYear, mDues);
        rmd1.insValues();
        allProperties ap1 = new allProperties();
        int rmdMonths = rmd1.getMonths();
        int vMonth = rmd1.getsMonth();
        int vYear = rmd1.getsYear();
        
        for (int i = 0; i < rmdMonths; i++){
            monthlyDues md = new monthlyDues(vMonth, vYear, rmd1.getAmtAppr(), rmd1.getId());
            md.insValues();
            for (int j = 0; j < ap1.getArpSize(); j++){
                trx_References tf = new trx_References(mDues, 0, mDues, vMonth, vYear);
                tf.insValues();
                houseMonthlyDues hmd = new houseMonthlyDues(ap1.getProperty(j), md.getId(), tf.getId());
                hmd.insValues();
            }
            if (vMonth == 12){
                vMonth = 1;
                vYear += 1;
            }
            else {
                vMonth += 1;
            }
        }
        /*
        request.setAttribute("announcement", a1);
        request.getRequestDispatcher("Homeowner/H_announcementSummary.jsp").forward(request, response);
        */
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
