package functionality;

import java.util.ArrayList;

import stuff.Coords;
import stuff.Planet;
import stuff.Player;

public class PlayerData {
	
	private static ArrayList<Player> players = new ArrayList<Player>();

	public static Player searchOrCreatePlayer(String p) {
		if (players.isEmpty()) {
			return new Player(p);
		}
		for (Player search : players) {
			if (search.getName().equals(p)) {
				return search;
		}
	}
		return new Player(p);
	}

	public static Planet searchOrCreatePlanet(String string, Coords c, Player p) {
		
		return null;
	}

}
