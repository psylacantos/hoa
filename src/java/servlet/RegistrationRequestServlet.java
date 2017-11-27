package Control;

import Model.Registration_Request;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.UserDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/RegistrationRequestServlet")
public class RegistrationRequestServlet extends HttpServlet {
       
    
    public RegistrationRequestServlet() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("DOGET METHOD PRINT");
                request.getSession().removeAttribute("Error");
                request.getSession().removeAttribute("Success_Request");
                
                request.getRequestDispatcher("create_regrequest.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
            System.out.println("TEST");
                request.getSession().removeAttribute("Error");
                request.getSession().removeAttribute("Success_Request");
                
                //check if user exists
                boolean errors_exist = false;
                UserDAO uDao = new UserDAO();
                String username = request.getParameter("username");
                if(uDao.usernameExists(username))
                {
                    System.out.println("Username exists");
                    //if exists
                    request.getSession().setAttribute("Error", "User exists");
                    errors_exist = true;
                }
                
                if(errors_exist == false)
                {
                    System.out.println("went errors exist = false");
                    request.getSession().setAttribute("Success_Request", "Request sent");
               
                    
                    //insert all data to registration_request table
                    Date bDate;
                            
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsedBDate = null;
                    Date parsedMDate = null;
                    try {
                        parsedBDate = format.parse(request.getParameter("birthDate"));
                        parsedMDate = format.parse(request.getParameter("movingIn"));
                    } catch (ParseException ex) {
                        Logger.getLogger(RegistrationRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    java.sql.Date sqlBDate = new java.sql.Date(parsedBDate.getTime());        
                    java.sql.Date sqlMDate = new java.sql.Date(parsedMDate.getTime());      
                            
                    Registration_Request newInsert = new Registration_Request(request.getParameter("username"), request.getParameter("passwd"), request.getParameter("lastName"), request.getParameter("firstName"),
                    request.getParameter("middleName"), sqlBDate, 1, request.getParameter("occupation"), Long.parseLong(request.getParameter("telnum")), Long.parseLong(request.getParameter("mobnum")), 
                    Integer.parseInt(request.getParameter("blocknum")),Integer.parseInt(request.getParameter("lotnum")), sqlMDate);
                    
                    uDao.InsertRequest(newInsert);
                    
                }
                request.getRequestDispatcher("create_regrequest.jsp").forward(request, response);
	}

}
