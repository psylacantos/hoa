/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsersList;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "loginCheck", urlPatterns = {"/loginCheck"})
public class loginCheck extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginCheck</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginCheck at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        UsersList ul = new UsersList();
        String username = request.getParameter("usernameLogin");
        String password = request.getParameter("passwordLogin");
        String usertype = "";
        if (!ul.dbLogin(username).equals("")){
            String pw = ul.dbLogin(username);
            usertype = pw.substring(0, 1);
            pw = pw.substring(1);
            if (pw.equals("inactive")){
                request.setAttribute("login", "Cannot login because account is deactivated.");
                RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
                rd.forward(request, response);
            }
            else if (password.equals(pw)){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("usertype", usertype);
                request.setAttribute("login", usertype);
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            } 
            else{
                //response.sendRedirect("login.jsp");
                request.setAttribute("login", "Incorrect username/ password");
                RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
                rd.forward(request, response);
            }
        }
        else{
            request.setAttribute("login", "Cannot login because either username does not exist or registration request is still being processed.");
            RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
            rd.forward(request, response);
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
