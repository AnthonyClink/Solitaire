package com.stevesmith.solitaire.datatype;

public enum Suit {

	SPADE("S", "Spades", Color.BLACK),
	HEART("H", "Hearts", Color.RED),
	CLUB("C", "Clubs", Color.BLACK),
	DIAMOND("D", "Diamonds", Color.RED),
	BLANK("B", "Card", Color.BLACK),
	DOWN("DWN", "Down", Color.BLACK);
	
	public static final Suit[] standardSuits(){
		return new Suit[]{SPADE, HEART, CLUB, DIAMOND};
	}
	
	private String shortName;
	private String fullName;
	private Color color;
	
	private Suit(String shortName, String fullName, Color color){
		this.shortName = shortName;
		this.fullName = fullName;
		this.color = color;
	}
	
	public String getShortName(){
		return shortName;
	}
	
	public String getFullName(){
		return fullName;
	}
	
	public Color getColor(){
		return color;
	}
}
