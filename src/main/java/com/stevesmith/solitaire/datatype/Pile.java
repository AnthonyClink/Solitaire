package com.stevesmith.solitaire.datatype;

import java.util.List;

import com.google.common.collect.Lists;
import com.stevensmith.solitaire.exceptions.CardDuplicationException;

public class Pile {

	private  final List<Card> cards;
	
	public Pile(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getCards(){
		List<Card> cardsCopy = Lists.newArrayList();
		cardsCopy.addAll(cards);
		return cardsCopy;
	}

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
