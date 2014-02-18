package com.clinkworks.solitaire.web;

import com.clinkworks.solitaire.modules.ProductionRestModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceServletListener extends GuiceServletContextListener {

	  @Override
	  protected Injector getInjector() {
	    return Guice.createInjector(new ProductionRestModule());
	  }
	}