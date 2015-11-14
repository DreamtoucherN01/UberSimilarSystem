/**
 * 
 */
/**
 * @author cy
 *
 */
package com.cy.server;


import java.net.URL;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 */
public class JettyEmbedServer {

	private static final Logger logger = LoggerFactory.getLogger(JettyEmbedServer.class);

	//===========set
	private int port = 8983;
	private String contextPath = "/";
	private String webPath;
	private int threadNum = 50;
	
	private String cy;

	private Map<String, Filter> filters;

	private Map<String, Servlet> servlets;

	//===========
	private Server server;


	@SuppressWarnings("static-access")
	private void init() throws Exception {
		server = new Server();

		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(port);
        connector.setMaxIdleTime(30000);
        connector.setRequestHeaderSize(8192);
        QueuedThreadPool threadPool =  new QueuedThreadPool(threadNum);
        threadPool.setName("embed-jetty-http");
        connector.setThreadPool(threadPool);

		server.setConnectors(new Connector[] { connector });
		
		//Context context = null;
		ServletContextHandler context = null;

		if(webPath != null) {
			WebAppContext webcontext = new WebAppContext();
			webcontext.setContextPath(contextPath);
			URL warLocation = this.getClass().getClassLoader().getSystemResource(webPath);
			//File f = new File(this.getClass().getResource("/").getPath()); System.out.println(f);
			//URL warLocation = this.getClass().getClassLoader().getResource(webPath);
			if(warLocation != null){
				webcontext.setWar(warLocation.toExternalForm());
				context = webcontext;
				server.setHandler(context);
			}else{
				webcontext.setResourceBase("./src/main/webapp");
				//webcontext.setResourceBase("./root");
				webcontext.setParentLoaderPriority(true);
				context = webcontext;
				server.setHandler(context);
			}
		} else {
			context = new ServletContextHandler(server, contextPath);
		}
		

		//add filter
		if(filters != null) {
			for(Map.Entry<String, Filter> eFilter : filters.entrySet()) {
				logger.info("add filter={}, path={}", eFilter.getValue().getClass(), eFilter.getKey());
				context.addFilter(new FilterHolder(eFilter.getValue()), eFilter.getKey(), FilterMapping.DEFAULT);
			}
		}

		//add servlet
		if(servlets != null) {
			for(Map.Entry<String, Servlet> eServlet : servlets.entrySet()) {
				logger.info("add servlet={}, path={}", eServlet.getValue().getClass(), eServlet.getKey());
				//File f = new File(this.getClass().getResource("/").getPath()); System.out.println(f);
				//System.err.println(eServlet.getValue()+" "+eServlet.getKey());
				context.addServlet(new ServletHolder(eServlet.getValue()), eServlet.getKey());
			}
		}

		if(webPath == null) {
			context.addServlet(DefaultServlet.class, "/*");
		}
	}


	public void start() throws Exception {
		init();
		server.start();
		logger.info("jetty embed server started, port={}", port);
	}

	public void stop() throws Exception {
		server.stop();
		server.destroy();
	}

	
	public void setPort(int port) {
		this.port = port;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}

	public void setFilters(Map<String, Filter> filters) {
		this.filters = filters;
	}

	public void setServlets(Map<String, Servlet> servlets) {
		this.servlets = servlets;
	}
	
}
