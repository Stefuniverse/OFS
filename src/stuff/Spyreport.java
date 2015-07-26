package stuff;


import java.util.HashMap;
import java.util.Map.Entry;

public class Spyreport {
	
	private static Planet unknown = new Planet("unknown", new Coords(0,0,0) , new Player("unknown"));
	private static int newid = 0;
	private int id = newid++;
	
	//Füge Datum ein
	HashMap<String,Integer> content;
	
	public Spyreport(Planet p, HashMap<String,Integer> c) {
		p.assign(this);
		content = c;
	}
	public Spyreport(HashMap<String,Integer> c) {
		unknown.assign(this);
		content = c;
	}
	
	public Spyreport(Planet p) {
		p.assign(this);
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		if (content!= null) {
		String s = "";
		for (Entry<String,Integer> k : content.entrySet()) {
			s += k.getKey() + ": " + k.getValue() + "\n";
		}
		return s;
		} else {
			return "";
		}
	}

}
