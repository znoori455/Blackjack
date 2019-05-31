package blackjack;

public class Dealer extends Player {
	
	//constructor
	public Dealer(String playerName, int chips) {
		super(playerName, chips);
	}
	
	//only difference: one card is hidden
	public void Deal(Card card1, Card card2) {
		handTotal = 0;
    	
        playerHand.push(card1);
        playerHand.push(card2);
        
        
        for (Card a : playerHand) {
    		handTotal += a.getValue();
    	}
        
        System.out.println(playerName + " draws: " + card1 +" , and (hidden) " + " Total: " + card1.getValue());
	}

}
