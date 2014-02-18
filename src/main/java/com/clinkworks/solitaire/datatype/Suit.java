package com.clinkworks.solitaire.datatype;

public enum Suit {

	SPADES("S", "Spades", Color.BLACK),
	HEARTS("H", "Hearts", Color.RED),
	CLUBS("C", "Clubs", Color.BLACK),
	DIAMONDS("D", "Diamonds", Color.RED),
	BLANK("B", "Card", Color.BLACK),
	DOWN("DWN", "Down", Color.BLACK);
	
	public static final Suit[] standardSuits(){
		return new Suit[]{SPADES, HEARTS, CLUBS, DIAMONDS};
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
