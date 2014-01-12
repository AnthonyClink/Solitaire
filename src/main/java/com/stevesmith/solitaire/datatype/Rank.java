package com.stevesmith.solitaire.datatype;

public enum Rank {
	ACE("A", "Ace"),
	TWO("2", "Two"),
	THREE("3", "Three"),
	FOUR("4", "Four"),
	FIVE("5", "Five"),
	SIX("6", "Six"),
	SEVEN("7", "Seven"),
	EIGHT("8", "Eight"),
	NINE("9", "Nine"),
	TEN("10", "Ten"),
	JACK("J", "Jack"),
	QUEEN("Q", "Queen"),
	KING("K", "King");
	
	private String shortName;
	private String fullName;
	
	private Rank(String shortName, String fullName){
		this.shortName = shortName;
		this.fullName = fullName;
	}
	
	public static Rank[] orderedRanks(){
		Rank[] ranks = Rank.values();
		Rank[] retval = new Rank[ranks.length];
		retval[0] = ranks[0];
		
		for(int i = 1; i < ranks.length; i++){
			retval[i] = ranks[ranks.length - i];
		}
		
		return retval;
	}
	
	public String getShortName(){
		return shortName;
	}
	
	public String getFullName(){
		return fullName;
	}

}
