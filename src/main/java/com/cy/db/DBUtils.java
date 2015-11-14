package com.cy.db;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DBUtils {
	
	int pagenum=2;
	Configuration cfg ;//= new Configuration().configure();
	SessionFactory sf ;//= cfg.buildSessionFactory(); 
	public static Session session ;//=sf.openSession(); 
	
	public DBUtils(){
		if(session==null){
			cfg = new Configuration().configure();
			sf = cfg.buildSessionFactory();
			session =sf.openSession();
			session.setFlushMode(FlushMode.AUTO);
		}
	}

}
