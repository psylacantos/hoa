package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.UserDAO;
import Model.homemember;

@WebServlet(name = "AddHomememberServlet", urlPatterns = {"/AddHomememberServlet"})
public class AddHomememberServlet extends HttpServlet 
{
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddHomememberServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddHomememberServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        homemember addMember = new homemember(request.getParameter("userid"), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("renting"), request.getParameter("blocknum"),
        request.getParameter("lotnum"), request.getParameter("status"));
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
