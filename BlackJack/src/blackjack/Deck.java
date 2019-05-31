package blackjack;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class Deck {


    private LinkedList<Card> deck = new LinkedList<>();
	

    
    //deck constructor
	public Deck() {
    	
    	for (int i=0; i<4; i++) {
    		Card two = new Card("Two" , 2);
    		deck.add(two);
		
    		Card three = new Card("Three" , 3);
    		deck.add(three);
		
    		Card four = new Card("Four" , 4);
    		deck.add(four);
                
            Card five = new Card("Five" , 5);
            deck.add(five);
                
            Card six = new Card("Six" , 6);
            deck.add(six);
                
            Card seven = new Card("Seven" , 7);
            deck.add(seven);
                
            Card eight = new Card("Eight" , 8);
            deck.add(eight);
                
            Card nine = new Card("Nine" , 9);
            deck.add(nine);
            
            Card ten = new Card("Ten" , 10);
            deck.add(ten);
                
            Card jack = new Card("Jack" , 10);
            deck.add(jack);
                
            Card queen = new Card("Queen" , 10);
            deck.add(queen);
                
            Card king = new Card("King" , 10);
            deck.add(king);
                
            Card ace = new Card("Ace" , 11);
            deck.add(ace);
                
            Collections.shuffle(deck);
    	}    
    }
    
	//pops one off the top
    public Card removeCard() {
    	return this.deck.pop();
    }
    
    //adds discarded
    public void addToDeck(Collection<? extends Card> discarded) {
    	this.deck.addAll(discarded);
    	Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        return "Deck{" + '}' + deck;
    }	
}
