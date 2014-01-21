package com.stevesmith.solitare.modules;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.stevesmith.solitaire.web.CorsFilter;
import com.stevesmith.solitare.resources.GameResource;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;



public class ProductionRestModule extends ServletModule{
		
		@Override
	    protected void configureServlets() {
			
			install(new ProductionModule());
			
			// bind game resource so the guice container can pick it up
			bind(GameResource.class);

	        // hook Guice into Jersy Servlet
	        bind(GuiceContainer.class);

	        // hook Jackson into Jersey as the POJO <-> JSON mapper
	        //(jersy needs this class in the constructor, this allows guice to know what to inject there)
	        bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

	        //haven't done anything wit this yet.
	        Map<String, String> guiceContainerConfig = new HashMap<String, String>();
	        
	        //have guice take care of urls
	        serve("/*").with(GuiceContainer.class, guiceContainerConfig);
	        
	        //lets javascript talk to us
	        filter("/*").through(CorsFilter.class);
	    }
	}


