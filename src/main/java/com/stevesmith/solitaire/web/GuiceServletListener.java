package com.stevesmith.solitaire.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.stevesmith.solitare.modules.ProductionRestModule;

public class GuiceServletListener extends GuiceServletContextListener {

	  @Override
	  protected Injector getInjector() {
	    return Guice.createInjector(new ProductionRestModule());
	  }
	}