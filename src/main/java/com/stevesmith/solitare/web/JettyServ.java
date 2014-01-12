package com.stevesmith.solitare.web;

import java.util.EnumSet;

import org.eclipse.jetty.server.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceFilter;

public class JettyServ {
	
	public static void main(String[] args) throws ServerFailedToStartException{
        
        Server server = new Server(8080);
        
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");

        handler.addServlet(new ServletHolder(new InvalidRequestServlet()), "/*");

        //FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        //handler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));

        server.setHandler(handler);
        
        try{
        	server.start();
        }catch(Exception e){
        	throw new ServerFailedToStartException(e);
        }
        
	}
	
	public static Module getInjectorForModule(Class<?> worldcraftModule){
		Module myModule = null;
		
		try {
			myModule = (Module) worldcraftModule.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Injector injector = Guice.createInjector(myModule);
		return myModule;
	}
}
