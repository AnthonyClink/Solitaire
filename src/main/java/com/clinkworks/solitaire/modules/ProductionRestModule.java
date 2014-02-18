package com.clinkworks.solitaire.modules;

import java.util.HashMap;
import java.util.Map;

import com.clinkworks.solitaire.web.CorsFilter;
import com.clinkworks.solitaire.web.resources.GameResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;



public class ProductionRestModule extends ServletModule{
		
		@Override
	    protected void configureServlets() {
			
			install(new ProductionModule());
			
			// bind game resource so the guice container can pick it up
			bind(GameResource.class);

	        // hook Guice into Jersy Servlet
	        bind(GuiceContainer.class);

	        //haven't done anything wit this yet.
	        Map<String, String> guiceContainerConfig = new HashMap<String, String>();
	        
	        //have guice take care of urls
	        serve("/*").with(GuiceContainer.class, guiceContainerConfig);
	        
	        //lets javascript talk to us
	        filter("/*").through(CorsFilter.class);
	    }
	}


