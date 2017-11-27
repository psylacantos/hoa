/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import model.Penalties;
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



public class ModifyPenalties extends HttpServlet {
	
public ModifyPenalties() {
 }

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
    PenaltyDao p = new PenaltyDao();
    DocumentDao d = new DocumentDao();


 if(request.getParameter("Mode").equals("Add")){
     
     request.getRequestDispatcher("/WEB-INF/views/addPenalty.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
 }
 
 else if(request.getParameter("Mode").equals("View")){
        int id = Integer.parseInt(request.getParameter("penaltyID"));
         
         
        
          request.setAttribute("penalty", p.getPenalty(id));
     request.getRequestDispatcher("/WEB-INF/views/viewPenalty.jsp").forward(request, response);
     
 
 }
 }
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
if(request.getParameter("Mode").equals("Add")){
     PenaltyDao p = new PenaltyDao();
     String desc = request.getParameter("desc");
     int level = Integer.parseInt(request.getParameter("level"));
     int documentID = Integer.parseInt(request.getParameter("documentID"));
     double fee = Double.parseDouble(request.getParameter("fee"));
     String action = request.getParameter("action");
  
        
        
        Penalties penalty = new  Penalties(p.getMaxID()+1,level,desc,fee,action,documentID);
       p.addPenalty(penalty); 
        
            
         request.setAttribute("penalty", penalty);
     request.getRequestDispatcher("/WEB-INF/views/viewPenalty.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
 }

}

}
 

