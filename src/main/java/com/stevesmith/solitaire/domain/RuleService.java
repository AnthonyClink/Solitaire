package com.stevesmith.solitaire.domain;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.GameSpotType;
import com.stevesmith.solitaire.datatype.Suit;

public class RuleService {
	
	public boolean isGoingToResolutionPile(GameSpot toSpot){
		if(toSpot.getGameSpotType() == GameSpotType.RESOLUTION){
			return true;
		}
		return false;
	}

	public boolean isRed(Card card) {
		Suit suit = card.getSuit();
		if(suit == Suit.DIAMOND || suit == Suit.HEART){
			return true;
		}else {return false;}
	}
	
	public boolean isBlack(Card card){
		Suit suit = card.getSuit();
		if(suit == Suit.CLUB || suit == Suit.SPADE){
			return true;
		}else {return false;}
	}

	public boolean isOneAbove(Card fromCard, Card toCard) {
		int fromRank = fromCard.getRank().ordinal();
		int toRank = toCard.getRank().ordinal();
		if(fromRank - 1 == toRank){
			return true;
		}else{return false;}
	}
	
	public boolean isOneBelow(Card fromCard, Card toCard){
		int fromRank = fromCard.getRank().ordinal();
		int toRank = toCard.getRank().ordinal();
		if(fromRank + 1 == toRank){
			return true;
		}else{return false;}
	}
	
	public boolean isOppositeColor(Card fromCard, Card toCard){
		//toCard is Red
		if(isRed(toCard)){
			if(isBlack(fromCard)){
				return true;
			}else{return false;}
		//toCard is black
		}else{
			if(isRed(fromCard)){
				return true;
			}else{return false;}
		}
	}

	public boolean spotIsEmpty(Deck toDeck) {
		if(toDeck.getCards().size() == 0){
			return true;
		}
		return false;
	}

}
