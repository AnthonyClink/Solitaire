package com.stevesmith.solitare.web;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;


@Singleton
public class CorsFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		if(response instanceof HttpServletResponse){
			HttpServletResponse alteredResponse = ((HttpServletResponse)response);
			// I need to find a way to make sure this only gets called on 200-300 http responses
			// TODO: see above comment
			addHeadersFor200Response(alteredResponse);
		}
		
		filterChain.doFilter(request, response);
	}

	private void addHeadersFor200Response(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
	}
	
	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig)throws ServletException{}
}