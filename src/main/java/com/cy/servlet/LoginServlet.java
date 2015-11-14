/**
 * 
 */
/**
 * @author cy
 *
 */
package com.cy.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4532373161142028853L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("Content-Type: text/plain;charset=utf-8");
		//get the parameter
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(username.equals("root")&&password.equals("123456")){
			RequestDispatcher rd = req.getRequestDispatcher("control.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}

		
	}
	
}