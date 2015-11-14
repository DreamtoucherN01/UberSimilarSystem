/**
 * 
 */
/**
 * @author cy
 *
 */
package com.cy.entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cy.server.DBServer;
import com.cy.server.JettyEmbedServer;

public class Start {

	private static final Logger logger = LoggerFactory.getLogger(JettyEmbedServer.class);
	
	/**
	 * @param args
	 */
    
	public static void main(String args[]) {
		String contextFile = "classpath:spring-context.xml";
		ApplicationContext context = null;
		try {
			context =  new FileSystemXmlApplicationContext(contextFile);
			new org.springframework.context.support.ClassPathXmlApplicationContext(contextFile);
			 
		} catch (Exception e) {
			System.out.println("RunMain [spring-conf-file]");
			logger.warn("", e);
		}

		String jettyEmbedServerBeanName = "jettyEmbedServer";

		final JettyEmbedServer jettyEmbedServer = (JettyEmbedServer) context.getBean(jettyEmbedServerBeanName);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					jettyEmbedServer.stop();
					//Operation.session.close();
				} catch (Exception e) {
					logger.error("run main stop error!", e);
				}
			}
		});

		try {
			jettyEmbedServer.start();
			new DBServer();
			logger.info("server started");
		} catch (Throwable e) {
			logger.warn("has exception!", e);
			System.exit(-1);
		}
	}
}
