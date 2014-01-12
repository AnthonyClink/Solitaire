package com.stevesmith.solitaire.domain;

import com.google.inject.AbstractModule;

public class MockGameServiceModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(GameService.class).to(FakeGameService.class);
	}

}
