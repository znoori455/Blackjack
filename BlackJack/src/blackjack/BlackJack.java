package blackjack;

import java.util.LinkedList;
import java.util.Scanner;

public class BlackJack {
	static Deck deck = new Deck(); //deck
	static Scanner reader = new Scanner(System.in); //accessible throughout class
	static LinkedList<Card> discarded = new LinkedList<Card>(); //discarded pile
	
	public static void main(String[] args) {
	    
	    Dealer dealer = new Dealer("House", 1000000);
	    
	    
	    
	    System.out.println("Please enter your name");
	    String player1Name = reader.nextLine();
	    System.out.println("How many chips do you have?");
	    int player1Chips = reader.nextInt();
	    reader.nextLine();
	    
	    Player player1 = new Player(player1Name, player1Chips);
	    
	    
	    
	    if (player1.getChips() >= 10) {
	    	play(dealer, player1);
	    } else {
	    	System.out.println("Sorry, you're too poor to play here.");
	    }
	    
	    
	    //replay loop
	    if (player1.getChips() >= 10) {
	    	while (true) {
	    		
	    		System.out.println("Play another round? (\"yes\" or \"no\")");
	    		String playAnotherRound = reader.nextLine();
    		
	    		
	    		if (playAnotherRound.equalsIgnoreCase("yes")) {
	    			play(dealer, player1);
    
	    		} 
	    		
	    		
	    		else if (playAnotherRound.equalsIgnoreCase("no")) {
	    			break;
	    		} else {
	    			System.out.println("Not a valid response!");
	    		}
	    
	    	}
	    }
	    
	    
	    System.out.println("Thanks for stopping by.");
	    
	}

	
	
	//basic games
	public static void play(Dealer dealer, Player player1) {
	    player1.Deal(deck.removeCard(), deck.removeCard());
	    dealer.Deal(deck.removeCard(), deck.removeCard());
	    
	    playerChoices(player1);
	    
	    //reveals the second hand
	    dealer.printHand();
	    
	    
	    //dealer keeps hitting while under 16
	    while (dealer.getHandTotal()<16) {
	    	dealer.hit(deck.removeCard());
	    }
	    
	    //adjusts scores
	    outcomes(dealer, player1, player1.getDoubler() );

		//throws the hands into discarded pile
    	discarded.addAll(player1.playerHand);
    	discarded.addAll(dealer.playerHand);
    	player1.playerHand.clear();
    	dealer.playerHand.clear();
    	
    	//adds discarded cards back in
    	if (discarded.size() > 26) {
    		deck.addToDeck(discarded);
    		discarded.clear();
    	}
    	
	}
	
	
	
	public static void playerChoices(Player player1) {
		
		//skips if natural blackjack
		while (player1.getHandTotal() < 21) {
			
	    	System.out.println(player1.getPlayerName() + ", make a choice.");
		    String player1Choice = reader.nextLine();
		    
		    //hit case
		    if (player1Choice.equalsIgnoreCase("hit")) {
		    	player1.hit(deck.removeCard());
		    } else if (player1Choice.equalsIgnoreCase("stand")){
		    	break;
		    	
		    //double case
		    } else if (player1Choice.equalsIgnoreCase("double")){
		    	if (player1.getHandTotal() ==9 ||player1.getHandTotal() ==10 ||player1.getHandTotal() ==11) {
		    		player1.setDoubler(true);
		    		player1.hit(deck.removeCard());
		    		break;
		    		
		    //you done goofed		
		    } else
		    	System.out.println("Not a valid response!");
		    }
	    }
	}

	
	
	
	
	//adjusts scores
	public static void outcomes(Dealer dealer, Player player1, boolean doubler) {
		//standard play
		if (player1.getDoubler() == false) {
	    	if (player1.busted() == true) {
		    	houseWins(dealer, player1);
		    } else if (dealer.busted() == true) {
		    	playerWins(dealer, player1);
		    } else if (dealer.handTotal > player1.handTotal) {
		    	houseWins(dealer, player1);
		    } else if (player1.handTotal > dealer.handTotal){
		    	playerWins(dealer, player1);
		    } else {
		    	tie(dealer, player1);
		    }
	    } 
		
		
		//double play
		else if (player1.getDoubler() == true) {
	    	player1.setDoubler(false);
	    	
	    	if (player1.busted() == true) {
		    	doubleHouseWins(dealer, player1);
		    } else if (dealer.busted() == true) {
		    	doublePlayerWins(dealer, player1);
		    } else if (dealer.handTotal > player1.handTotal) {
		    	doubleHouseWins(dealer, player1);
		    } else if (player1.handTotal > dealer.handTotal){
		    	doublePlayerWins(dealer, player1);
		    } else {
		    	tie(dealer, player1);
		    }
	    }
	}
	
	
	
	
	
	public static void houseWins(Dealer dealer, Player player1) {
		
		dealer.setChips((dealer.getChips() + 10));
    	player1.setChips(player1.getChips() - 10);
    	
    	dealer.setWins(dealer.getWins() + 1);
    	player1.setWins(player1.getWins() - 1);
    	
    	System.out.println(dealer.getPlayerName() + " wins");
    	player1.toString();
    	dealer.toString();		
	}
	

	
	public static void playerWins(Dealer dealer, Player player1) {
		
		dealer.setChips((dealer.getChips() - 10));
    	player1.setChips(player1.getChips() + 10);
    	
    	dealer.setWins(dealer.getWins() - 1);
    	player1.setWins(player1.getWins() + 1);
    	
    	System.out.println(player1.getPlayerName() + " wins");
    	player1.toString();
    	dealer.toString();		
	}
	
	
	
	
	
	
	public static void doubleHouseWins(Dealer dealer, Player player1) {
		dealer.setChips((dealer.getChips() + 20));
    	player1.setChips(player1.getChips() - 20);
    	
    	dealer.setWins(dealer.getWins() + 1);
    	player1.setWins(player1.getWins() - 1);
    	
    	System.out.println(dealer.getPlayerName() + " wins");
    	player1.toString();
    	dealer.toString();
	}
	
	public static void doublePlayerWins(Dealer dealer, Player player1) {
		
		dealer.setChips((dealer.getChips() - 20));
    	player1.setChips(player1.getChips() + 20);
    	
    	dealer.setWins(dealer.getWins() - 1);
    	player1.setWins(player1.getWins() + 1);
    	
    	System.out.println(player1.getPlayerName() + " wins");
    	player1.toString();
    	dealer.toString();
	}

	
	
	
	//Tie
	public static void tie(Dealer dealer, Player player1) {
	
	System.out.println("Tie.");
	player1.toString();
	dealer.toString();		
	}
	
}
