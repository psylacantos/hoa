/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.VEHICLES;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BadgerinoTwo
 */
@WebServlet(name = "registerVehicle", urlPatterns = {"/registerVehicle"})
public class registerVehicle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        System.out.println("Start Get Parameter");
        String platenum = request.getParameter("platenum");
        String model = request.getParameter("model");
        String make = request.getParameter("make");
        String year = request.getParameter("year");
        System.out.println("End Get Parameter");
        try{
                    Class.forName("com.mysql.jdbc.Driver");
                    
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root",null);
                    
                    PreparedStatement query = con.prepareStatement("INSERT INTO VEHICLES (platenum, model, make, year, banned) VALUES (?,?,?,?,false)");
                    
                    query.setString(1, platenum);
                    query.setString(2, model);
                    query.setString(3, make);
                    query.setString(4, year);
                    
                    query.executeUpdate();
                    
                    VEHICLES v = new VEHICLES();
                    v.setPlateNum(platenum);
                    v.model = model;
                    v.make = make;
                    
                    DateFormat format =
                            new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
                    Date date = format.parse(year);
                    
                    v.year = date;
                    
                    request.setAttribute("VEHICLES", v);
                    request.getRequestDispatcher("HomeOwner_SecurityPersonnel_Officer/approveRejectVehicle.jsp").forward(request, response);
                    
                    con.close();
                }
                catch(Exception e){
                    System.out.println(e);
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
