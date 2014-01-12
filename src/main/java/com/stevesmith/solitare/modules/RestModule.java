package com.stevesmith.solitare.modules;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.stevesmith.solitare.resources.GameResource;
import com.stevesmith.solitare.web.CorsFilter;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;



public class RestModule extends ServletModule{
		
		@Override
	    protected void configureServlets() {
			bind(GameResource.class);

	        // hook Jersey into Guice Servlet
	        bind(GuiceContainer.class);

	        // hook Jackson into Jersey as the POJO <-> JSON mapper
	        bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

	        Map<String, String> guiceContainerConfig = new HashMap<String, String>();
	        
	        //guiceContainerConfig.put(ResourceConfig.PROPERTY_RESOURCE_FILTER_FACTORIES,
	        //    HttpStatusCodeMetricResourceFilterFactory.class.getCanonicalName());
	        
	        
	        serve("/*").with(GuiceContainer.class, guiceContainerConfig);
	        
	        filter("/*").through(CorsFilter.class);
	    }
	}


