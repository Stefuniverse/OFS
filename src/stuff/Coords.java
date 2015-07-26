package stuff;

public class Coords {
	
	private int universe;
	private int solarsystem;
	private int planet;
	
	public Coords(int u,int s,int p) {
		this.universe = u;
		this.solarsystem = s;
		this.planet = p;
	}
	
	public String toString() {
		return "["+universe+":"+solarsystem+":"+planet+"]";
	}

	public int getUniverse() {
		return universe;
	}

	public int getSolarsystem() {
		return solarsystem;
	}

	public int getPlanet() {
		return planet;
	}

}
