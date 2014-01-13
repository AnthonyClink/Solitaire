package com.stevesmith.solitaire.datatype;

public enum Suit {

	SPADE("S", "Spades"),
	HEART("H", "Hearts"),
	CLUB("C", "Clubs"),
	DIAMOND("D", "Diamonds"),
	BLANK("B", "Card"),
	DOWN("DWN", "Down");
	
	public static final Suit[] standardSuits(){
		return new Suit[]{SPADE, HEART, CLUB, DIAMOND};
	}
	
	private String shortName;
	private String fullName;
	
	private Suit(String shortName, String fullName){
		this.shortName = shortName;
		this.fullName = fullName;
	}
	
	public String getShortName(){
		return shortName;
	}
	
	public String getFullName(){
		return fullName;
	}
}
