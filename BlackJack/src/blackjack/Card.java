package blackjack;


public class Card {

    
    private String name = new String();
	private int value;
	
	
	
//	enum suit {
//		Diamond, Heart, Spade, Club
//	}
	
	
	
	//getters/setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	
	
	public Card(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}

    @Override
    public String toString() {
        return "{ " + name + ", " + value + " }";
    }
   
}
