package com.cy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.cy.db.DB;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("Content-Type: text/plain;charset=utf-8");
		//get the parameter
		String no=req.getParameter("no");
		String name=req.getParameter("name");
		String total=req.getParameter("total");
		String left=req.getParameter("left");
		
		JSONObject json = new JSONObject();
		try {
			json.put("no", no);
			json.put("name", name);
			json.put("total", total);
			json.put("left", left);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		DB db = new DB();
		boolean done = false;
		try {
			done = db.insert(json,"");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if(done){
			RequestDispatcher rd = req.getRequestDispatcher("control.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}

	}

}
