package com.stevesmith.solitaire.domain;

import java.util.ArrayList;

import com.google.inject.Provider;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;

public class TestDeckProvider implements Provider<Deck> {

	@Override
	public Deck get() {
		return new Deck(new ArrayList<Card>());
	}

	
}
