package com.stevesmith.solitare.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

@Singleton
@Path("todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {
	
	 @GET
	 @Path("{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	public List<String> getTodos(String todosId){
		
		return Lists.newArrayList();
	}
	

}
