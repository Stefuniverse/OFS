package stuff;

import java.util.ArrayList;

public class Planet {
	
	String name;
	Coords coords;
	private ArrayList<Spyreport> reports = new ArrayList<Spyreport>();
	
	public Planet(String n, Coords c, Player p) {
		name = n;
		coords = c;
		p.assign(this);
	}
	public Planet(String n, Coords c, Player p, ArrayList<Spyreport> s) {
		name = n;
		coords = c;
		p.assign(this);
		reports = s;
	}

	public void assign(Spyreport s) {
		reports.add(s);
		
	}
	public String getName() {
		return name;
	}
	public Coords getCoords() {
		return coords;
	}
	public ArrayList<Spyreport> getReports() {
		return reports;
	}

}
