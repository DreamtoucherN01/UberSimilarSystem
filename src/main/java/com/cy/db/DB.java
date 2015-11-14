
package com.cy.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import com.cy.po.Data;

public class DB extends DBUtils{

	public boolean insert(JSONObject json , String table) throws JSONException {
		Transaction tx = session.beginTransaction(); 
		Data data = new Data();  
		
		data.setNo(json.getInt("no"));
		data.setName((String) json.get("name"));
		data.setTotal(json.getInt("total"));
		data.setNimei(json.getInt("left"));
		session.save(data);  
		
		tx.commit(); 
		session.clear();
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<Map> query(JSONObject json , String table) {
		//int sum=0;

		String sql;SQLQuery query = null;
		List<?> data;

		sql="select * from data order by no" ;
		query=session.createSQLQuery(sql).addEntity(Data.class);
		data = query.list();
		//sql="select count(*) from data";
		//query=session.createSQLQuery(sql);
		//sum = ((Number)query.uniqueResult()).intValue();

	    ArrayList<Map> list=new ArrayList<Map>();
	    
	    for(int i=0;i<data.size();i++){
	    	Map rowData = new HashMap<Object, Object>();
	    	Data back=(Data)data.get(i);
	    	rowData.put("no", back.getNo());
	    	rowData.put("name", back.getName());
	    	rowData.put("total", back.getTotal());
	    	rowData.put("left", back.getNimei());
	    	list.add(rowData);
	    }
	    Map rowData = new HashMap<Object, Object>();
	    list.add(rowData);
		session.clear();   
		return list;
	}

	public boolean delete(JSONObject json , String table) throws JSONException {
		Transaction tx = session.beginTransaction(); 
		String hql="delete from data where "+json.getString("key")+"=?";
	    try
	    {
	    	SQLQuery q=session.createSQLQuery(hql);
	        q.setParameter(0, json.getString("value"));
	        q.executeUpdate();
	        tx.commit();
	    }catch(Exception ex){
	       if(tx!=null)
	       {
	    	   tx.rollback();
	       }
	    }finally{
			session.clear();
	    }
		return true;
	}
	
}