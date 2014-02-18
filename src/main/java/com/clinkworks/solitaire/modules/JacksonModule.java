package com.clinkworks.solitaire.modules;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class JacksonModule extends AbstractModule{

	@Override
	protected void configure() {
		
	}
	
	@Provides
	@Singleton
	public ObjectMapper objectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
	
	@Provides
	@Singleton
	public JacksonJsonProvider jacksonJsonProvider(){
		return new JacksonJsonProvider(objectMapper());
	}
	

}
