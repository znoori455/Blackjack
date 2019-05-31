package blackjack;

import java.util.ArrayList;

public class PlayersTracker {
	

	PlayersTracker() {};
	public static final PlayersTracker playersAtTable = new PlayersTracker();
  
  
	ArrayList<Player> players = new ArrayList<>();
	
  
	public boolean newPlayer() {
		
		if (players.size()<6) {
			return true;
		} else {
			return false;
		}
  }
  
  
}
