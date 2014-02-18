package com.clinkworks.solitaire;

import java.util.EnumSet;

import org.eclipse.jetty.server.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.clinkworks.solitaire.modules.ProductionRestModule;
import com.clinkworks.solitaire.web.InvalidRequestServlet;
import com.clinkworks.solitaire.web.ServerFailedToStartException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;


public class Solitaire {
	
	public static void main(String [] args) throws ServerFailedToStartException{
		Injector injector = Guice.createInjector(new ProductionRestModule());
		
		Server server = new Server(8080);
		
		//added some comments to see if the Jenkins build server will pick up the git hub changes
		//added some comments to see if the Jenkins build server will pick up the git hub changes
		
		ServletContextHandler handler = new ServletContextHandler();
		handler.setContextPath("/solitaire");
		
		//note, jetty does not like to start without a servlet. Since guice is handling all the servlet filtering
		//this servlet will never be called unless guice fails to load a path correctly.
        handler.addServlet(new ServletHolder(new InvalidRequestServlet()), "/*");

        FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        handler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));

        server.setHandler(handler);
        
        try{
        	server.start();
        }catch(Exception e){
        	throw new ServerFailedToStartException(e);
        }		
	}

}
