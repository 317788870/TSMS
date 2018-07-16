package com.zjp.tsms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextLintener
 *
 */
@WebListener
public class ServletContextLintener implements ServletContextListener {
    /**
     * Default constructor. 
     */
    public ServletContextLintener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
		context.removeAttribute("contextPath");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
		context.setAttribute("contextPath", context.getContextPath()+"/");
    }
	
}
