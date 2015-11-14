package com.cy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.cy.db.DB;

/**
 * Servlet implementation class Queryservlet
 */
public class Queryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("Content-Type: text/plain;charset=utf-8");
		//get the parameter
		String no=req.getParameter("1");
		String value=req.getParameter("value");
		String key = null;
		
		if(no.equals("no")){
			key = "no";
		}else{
			key = "name";
		}
		
		JSONObject json = new JSONObject();
		try {
			json.put("key", key);
			json.put("value", value);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		DB db = new DB();
		ArrayList<Map> list = db.query(json,"");
		
		JSONObject jsstring  = new JSONObject();
		Vector<JSONObject> data=new Vector<JSONObject>();
		if (list.size()>0){
			for(int i=0;i<list.size()-1;i++){
				Map set  = list.get(i);
				JSONObject js  = new JSONObject();
				try {
			        js.put("no",set.get("no"));
					js.put("name",set.get("name"));
			        js.put("total",set.get("total"));
			        js.put("left",set.get("left"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
		        data.add(js);
			}
			try {
				jsstring.put("result", data);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			try {
				jsstring.put("status", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		if(jsstring.has("result")){
			req.setAttribute("data", jsstring.toString());
			RequestDispatcher rd = req.getRequestDispatcher("Infor.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}

	}

}
