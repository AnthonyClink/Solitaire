package com.clinkworks.solitaire.datatype;

import java.util.List;

import com.clinkworks.solitaire.exceptions.CardDuplicationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

public class Pile {

	private  final List<Card> cards;
	
	public Pile(){
		this.cards = Lists.newArrayList();
	}
	
	public Pile(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getCards(){
		List<Card> cardsCopy = Lists.newArrayList();
		cardsCopy.addAll(cards);
		return cardsCopy;
	}
	
	@JsonIgnore
	public int getSize(){
		return cards.size();
	}

	public Pile addCard(Card card) {
		for(Card aCard : cards){
			if(aCard == card){
				throw new CardDuplicationException();
			}
		}
		cards.add(card);
		return this;
	}

	public Pile removeCard(Card card) {
		  cards.remove(card);
		  return this;
		
	}
	
	@JsonIgnore
	public Card getTopCard() {
		if(cards.size() ==0){
			return null;
		}
		return cards.get(cards.size() - 1);
	}

	public void addCards(List<Card> newCards) {
		cards.addAll(newCards);
		
	}
	
	protected List<Card> getInternalData(){
		return cards;
	}
}
