package com.cy.server;

import com.cy.db.TableInit;

public class DBServer {
	
	public DBServer(){
		TableInit ti = new TableInit();
		ti.initialize();
	}

}
