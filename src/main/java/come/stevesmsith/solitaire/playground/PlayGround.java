package come.stevesmsith.solitaire.playground;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameBoard;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitaire.domain.GameService;
import com.stevesmith.solitaire.domain.RuleService;
import com.stevesmith.solitare.exceptions.NoCardsOnPileException;
import com.stevesmith.solitare.modules.ProductionModule;
import com.stevesmith.solitare.modules.RestModule;
import com.stevesmith.solitare.web.InvalidRequestServlet;
import com.stevesmith.solitare.web.ServerFailedToStartException;

public class PlayGround {

	private static GameService gameService;
	
	
	
	public static void main(String [] args) throws ServerFailedToStartException{
		Injector injector = Guice.createInjector(new ProductionModule());
		
		Server server = new Server(8080);
		
		server.setUncheckedPrintWriter(false);
		
		ServletContextHandler handler = new ServletContextHandler();
		handler.setContextPath("/");
		
		//note, jetty does not like to start without a servlet. Since guice is handling all the servlet filtering
		//this servlet will never be called unless guice fails to load a path correctly.
        handler.addServlet(new ServletHolder(new InvalidRequestServlet()), "/*");

        FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        handler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));

        server.setHandler(handler);
        
        try{
        	server.start();
        }catch(Exception e){
        	throw new ServerFailedToStartException(e);
        }		
	}
	
	public static void main2(String [] args) throws NoCardsOnPileException{
		
//		ruleService = new RuleService();
//		gameService = new GameService(ruleService, new GameBoard(new HashMap<GameSpot, Deck>()));
		Injector injector = Guice.createInjector(new ProductionModule());
		gameService = injector.getInstance(GameService.class);
		
		newGame();
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_2, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.REGULAR_2, GameSpot.REGULAR_4, 2);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_1, 1);
		gameService.drawCard();	gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_5, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.REGULAR_5, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_DIAMONDS, 1);
		gameService.drawCard(); gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_7, 1);
		gameService.drawCard(); gameService.drawCard(); gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_5, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 2);
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.REGULAR_4, 2);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_3, 4);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.RESOLUTION_CLUB, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_1, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_2, 1);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_2, 6);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_2, 1);
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_4, 8);
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_7, 1);
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_7, 1);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_7, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_DIAMONDS, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_2, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.REGULAR_2, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_SPADE, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_CLUB, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_1, 1);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_1, 9);
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.RESOLUTION_DIAMONDS, 1);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_1, 1);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_3, 1);
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_5, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 4);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.RESOLUTION_SPADE, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_6, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.REGULAR_4, 2);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_HEARTS, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_SPADE, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_HEARTS, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		
		
		HashMap<Integer, String> displayMap = createDisplayMap();
		printOutDisplaytMap(displayMap);
		
		
		
		
		
		//printOut();
	}
	

	public static void newGame(){
		Deck deck = loadTestDeck();
		gameService.dealGame(deck);
		gameService.getGameBoard().putDrawDeck(deck);
		
	}
	
	private static Deck loadTestDeck(){
		Deck deck = new Deck(new ArrayList<Card>());
		deck.addCard(new Card(Rank.TEN, Suit.CLUB, false));
		deck.addCard(new Card(Rank.JACK, Suit.SPADE, false));
		deck.addCard(new Card(Rank.ACE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.SPADE, false));
		deck.addCard(new Card(Rank.FOUR, Suit.SPADE, false));
		deck.addCard(new Card(Rank.THREE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.TWO, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.JACK, Suit.CLUB, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.CLUB, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.HEART, false));
		deck.addCard(new Card(Rank.NINE, Suit.HEART, false));
		deck.addCard(new Card(Rank.JACK, Suit.HEART, false));
		deck.addCard(new Card(Rank.THREE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.TEN, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.KING, Suit.CLUB, false));
		deck.addCard(new Card(Rank.SIX, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.THREE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.KING, Suit.SPADE, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.CLUB, false));
		deck.addCard(new Card(Rank.FIVE, Suit.HEART, false));
		deck.addCard(new Card(Rank.TWO, Suit.CLUB, false));
		deck.addCard(new Card(Rank.KING, Suit.HEART, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.SPADE, false));
		deck.addCard(new Card(Rank.KING, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FOUR, Suit.CLUB, false));
		deck.addCard(new Card(Rank.NINE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.ACE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FIVE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.TWO, Suit.SPADE, false));
		deck.addCard(new Card(Rank.TWO, Suit.HEART, false));
		deck.addCard(new Card(Rank.SIX, Suit.CLUB, false));
		deck.addCard(new Card(Rank.TEN, Suit.HEART, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.HEART, false));
		deck.addCard(new Card(Rank.NINE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.ACE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.FOUR, Suit.HEART, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FIVE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.ACE, Suit.HEART, false));
		deck.addCard(new Card(Rank.SIX, Suit.SPADE, false));
		deck.addCard(new Card(Rank.JACK, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.TEN, Suit.SPADE, false));
		deck.addCard(new Card(Rank.NINE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.FOUR, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FIVE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.THREE, Suit.HEART, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.SPADE, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.CLUB, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.HEART, false));
		deck.addCard(new Card(Rank.SIX, Suit.HEART, false));
		return deck;

	}
	
	private static void printOut(){
		HashMap<Integer,String> displayMap = createDisplayMap();
		printOutDisplaytMap(displayMap);
		/*for(GameSpot gameSpot : GameSpot.values()){
			Deck deck = gameService.getDeck(gameSpot);
			System.out.println(gameSpot.toString());
			for(int i = 0; i < deck.getSize(); i++){
				Card card = deck.getCards().get(i);
				if(card.isFaceUp()){
					System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
				}else{
					System.out.println("{DWN}");
					}
			}
		}*/
	}
	
	private static HashMap<Integer, String> createDisplayMap(){
		
		HashMap<Integer, String> displayMap = new HashMap<Integer,String>();
		
		int i = 1;
		for(GameSpot gameSpot : GameSpot.values()){
			displayMap.put(i, gameSpot.name());
			int c = 1;
			for(Card card : gameService.getGameBoard().getGameSpot(gameSpot).getCards()){
				if(card.isFaceUp()){
					displayMap.put(i + (c * 13) , card.toString()+"  ");
				}else{
					displayMap.put(i +  (c*13), "DWN  ");
				}
				c++;
			}
			i++;
		}
		return displayMap;
	}
	
	private static void printOutDisplaytMap(HashMap<Integer, String> displayMap){
		List<String> row = new ArrayList<>();
		int count = 0;
		boolean keepGoing = false;
		for(int i = 1; i <= 676; i++){
			if(displayMap.containsKey(i)){
				row.add(displayMap.get(i));
				keepGoing = true;
			}else{row.add("   ");}
			count++;
			if(count == 13){
				System.out.println("DRW"+"\t"+"DIS"+"\t"+"R 1"+"\t"+"R 2"+"\t"+"R 3"+"\t"+"R 4"+"\t"+"R 5"+"\t"+"R 6"+"\t"+"R 7"
						+"\t"+"R H"+"\t"+"R D"+"\t"+"R S"+"\t"+"R C");
				row.clear();
			}else if(count == 26){
				System.out.println(row.get(0)+"\t"+row.get(1)+"\t"+ row.get(2)+"\t"+ row.get(3)+"\t"+ row.get(4)+"\t"+ row.get(5)
						+"\t"+ row.get(6)+"\t"+ row.get(7)+"\t"+row.get(8)+"\t"+row.get(9)+"\t"+row.get(10)+"\t"+row.get(11)
						+"\t "+row.get(12));
				count = 13;
				row.clear();
				if(keepGoing){	
					keepGoing = false;
				}else{
					break;
				}
			}
			
		}
	}
}
