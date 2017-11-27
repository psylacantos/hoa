/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
 import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

import model.Policy;
import dao.BoardMemberDao;
import dao.DocumentDao;

import dao.PenaltyDao;
import dao.PolicyDao;



public class ModifyPolicy extends HttpServlet {
	
public ModifyPolicy() {
 }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
    PolicyDao policyDao = new PolicyDao();
       if(request.getParameter("Mode").equals("Add")){
            PolicyDao p = new PolicyDao();
            ArrayList<String> aff = p.getAffectedName();
            String[] affected = new String[aff.size()];
            for(int i = 0;i<aff.size();i++){
              affected[i]=aff.get(i);
              System.out.println(aff.get(i));
            }
            
            request.setAttribute("affected",affected);
            request.getRequestDispatcher("/WEB-INF/views/addPolicy.jsp").forward(request, response);
        }
       else if(request.getParameter("Mode").equals("Modify")){
            PolicyDao p = new PolicyDao();
            ArrayList<String> aff = p.getAffectedName();
            String[] affected = new String[aff.size()];
            
            request.setAttribute("pol",p.getPolicy(Integer.parseInt(request.getParameter("policyIDM"))));
            request.setAttribute("affected",p.getAffectedName());
            request.getRequestDispatcher("/WEB-INF/views/modifyPolicy.jsp").forward(request, response);
        }
       else if(request.getParameter("Mode").equals("Remove")){
          int id = Integer.parseInt(request.getParameter("policyID"));
         Policy pol = policyDao.getPolicy(id);
         ArrayList<String> aff = pol.getAffected();
         String PolicyValidate = policyDao.removePolicy(id);
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
        }
       else if(request.getParameter("Mode").equals("Approve")){
         int id = Integer.parseInt(request.getParameter("policyIDA"));
         Policy pol = policyDao.getPolicy(id);
         
         policyDao.approvePolicy(id);
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
       else if(request.getParameter("Mode").equals("Suspend")){
         int id = Integer.parseInt(request.getParameter("policyIDS"));
         Policy pol = policyDao.getPolicy(id);
         
         String PolicyValidate = policyDao.suspendPolicy(pol);
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
       else if(request.getParameter("Mode").equals("View")){
         int id = Integer.parseInt(request.getParameter("policyIDV"));
         Policy pol = policyDao.getPolicy(id);
         
        
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
       
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 

    PenaltyDao p = new PenaltyDao();
    DocumentDao d = new DocumentDao();
    BoardMemberDao b = new BoardMemberDao();


     //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.

     //setting the username and password through the loginBean object then only you can get it in future.

    PolicyDao policyDao = new PolicyDao(); //creating object for LoginDao. This class contains main logic of the application.
    if(request.getParameter("Mode").equals("Add")){
         String desc = request.getParameter("desc");
        int penaltyID = Integer.parseInt(request.getParameter("penaltyID"));
        int documentID = Integer.parseInt(request.getParameter("documentID"));
        String[] affected2 = request.getParameterValues("affected");
        ArrayList<String> affected = new ArrayList<String>();
        for(int i = 0;i<affected2.length;i++){
                affected.add(affected2[i]);
        }
        Policy policy = new  Policy(policyDao.getMaxID()+1,desc,penaltyID,documentID,null,"Created",affected);
        String PolicyValidate = policyDao.addPolicy(policy); //Calling authenticateUser function
        
            
         request.setAttribute("pol", policy);
         
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
     }
     else if(request.getParameter("Mode").equals("Modify")){
         String desc = request.getParameter("desc");
    int penaltyID = Integer.parseInt(request.getParameter("penaltyID"));
    int documentID = Integer.parseInt(request.getParameter("documentID"));
    String[] affected2 = request.getParameterValues("affected");
    ArrayList<String> affected = new ArrayList<String>();
    for(int i = 0;i<affected2.length;i++){
            affected.add(affected2[i]);
    }
         int id = Integer.parseInt(request.getParameter("policyID"));
         Policy sub = policyDao.getPolicy(id);
         Policy pol = new Policy (id,desc,penaltyID,documentID,sub.getEnactment(),sub.getStopimplementDate(),sub.getEnabler(),"Modified",affected);
         String PolicyValidate = policyDao.modifyPolicy(pol);
          request.setAttribute("pol", pol);
          
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
     else if(request.getParameter("Mode").equals("Remove")){
         int id = Integer.parseInt(request.getParameter("policyID"));
         Policy pol = policyDao.getPolicy(id);
         ArrayList<String> aff = pol.getAffected();
         String PolicyValidate = policyDao.removePolicy(id);
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
    else if(request.getParameter("Mode").equals("Approve")){
         int id = Integer.parseInt(request.getParameter("policyIDA"));
         Policy pol = policyDao.getPolicy(id);
         
         policyDao.approvePolicy(id);
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
    else if(request.getParameter("Mode").equals("Suspend")){
         int id = Integer.parseInt(request.getParameter("policyIDS"));
         Policy pol = policyDao.getPolicy(id);
         
         String PolicyValidate = policyDao.suspendPolicy(pol);
          request.setAttribute("pol", pol);
         request.getRequestDispatcher("WEB-INF/views/viewPolicy.jsp").forward(request, response);
     }
    
     }
 }
 
