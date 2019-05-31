package blackjack;

import java.util.LinkedList;
import java.util.Scanner;

public class Player {
	
    protected String playerName;
    private int chips;
    protected LinkedList<Card> playerHand = new LinkedList<>();
    protected int handTotal;
    protected int wins;    
	protected boolean busted = false;
	protected boolean doubler = false;

    
    
    
    //getters/setters
    public boolean getDoubler() {
		return doubler;
	}
	public void setDoubler(boolean doubler) {
		this.doubler = doubler;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
    
    public boolean getBusted() {
		return busted;
	}
	public void setBusted(boolean busted) {
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getChips() {
		return chips;
	}
	public void setChips(int chips) {
		this.chips = chips;
	}

	public LinkedList<Card> getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(LinkedList<Card> playerHand) {
		this.playerHand = playerHand;
	}
	
    public int getHandTotal() {
		return handTotal;
	}
	public void setHandTotal(int handTotal) {
		this.handTotal = handTotal;
	}
	
	public Player(String playerName, int chips) {
        this.playerName = playerName;
        this.chips = chips;

    }


	//prints current hand
	public void printHand() {
    	String currentHand = playerName + "'s hand: ";
    	for (Card inHand: playerHand) {
    		currentHand += inHand + ", ";
    	}
    	currentHand+= " Total: " + this.getHandTotal();
    	System.out.println(currentHand);
    }
    
    
    //adds cards from deck to hand
    public void Deal(Card card1, Card card2) {
    	handTotal = 0;
    	
        playerHand.push(card1);
        playerHand.push(card2);
        
        
        for (Card a : playerHand) {
    		handTotal += a.getValue();
    	}
        
        System.out.println(playerName + " draws: " + card1 +" , and " + card2 + " Total: " + handTotal);
       	
        	
        
    }
    

    //adds one card from deck
    public void hit(Card cardDrawn) {
    	handTotal = 0;
    	
    	playerHand.push(cardDrawn);
    	
    	for (Card a : playerHand) {
    		handTotal += a.getValue();
    	}
    	
    	//Ace adjuster
    	for (Card a : playerHand) {
    		if (a.getValue() == 11 && handTotal > 21) {
    			a.setValue(1);
    			handTotal -= 10;
    		}
    	}
    	
       System.out.println(playerName + " draws: " + cardDrawn);
       this.printHand();
    }
    

    //Did player bust?
    public boolean busted() { 
    	if (handTotal > 21) {
    		System.out.println(playerName + " busted.");
    		return true;
    	} else
    		return false;
    }
    
    



	@Override
	public String toString() {
		String print = ("[ " + playerName + " ] Net Wins: " + wins + ", Chips: " + chips);
		System.out.println(print);
		return print;
	}
    
    
}
