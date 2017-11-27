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



public class Redirect extends HttpServlet {
	
public Redirect() {
 }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
    PolicyDao policyDao = new PolicyDao();
       if(request.getParameter("Mode").equals("Policy")){
            
            request.getRequestDispatcher("/WEB-INF/views/PolicyHome.jsp").forward(request, response);
        }
       else if(request.getParameter("Mode").equals("Penalty")){
            
            request.getRequestDispatcher("/WEB-INF/views/PenaltyHome.jsp").forward(request, response);
        }
       
}

 }
 
