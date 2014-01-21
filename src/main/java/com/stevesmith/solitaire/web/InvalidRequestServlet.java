package com.stevesmith.solitaire.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class InvalidRequestServlet extends HttpServlet {

	private static final long serialVersionUID = -556962447618500673L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    resp.setContentType("text/plain");
	    resp.setContentType("UTF-8");
	    
	    PrintWriter buildError = resp.getWriter();
	    
	    buildError.append("<html>\n\r");
	    buildError.append("\t<body>\n\r");
	    buildError.append("\t\t<div style='background-color: red'>\n\r");
	    buildError.append("\t\t\t<h1>404 - Page not found</h1>\n\r");
	    buildError.append("\t\t\t<h2>Please use the RESTful api.</h2>\n\r");
	    buildError.append("\t\t</div>\n\r");
	    buildError.append("\t<body>\n\r");
	    buildError.append("</html>\n\r");
	}

}