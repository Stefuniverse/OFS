package stuff;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	
	public Player(String n) {
		name = n;
	}
	public Player(String n, ArrayList<Planet> p) {
		name = n;
		planets = p;
	}

	public boolean assign(Planet planet) {
		return planets.add(planet);
		
	}
	public String getName() {
		return name;
	}
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

}
