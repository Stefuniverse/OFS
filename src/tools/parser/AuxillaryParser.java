package tools.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.MalformedException;
import functionality.Settings;
import stuff.Coords;

public class AuxillaryParser implements Settings {
	
	public static Coords parseCoordinatesFromString(String in) {
		in = in.replace("[", "");
		in = in.replace("]", "");
		in = in.replace("\t", "");
		String[] s = in.split(":");
		return new Coords(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
	}

	public static String[] repairLine(String line) throws MalformedException {
		String words[];
		line = line.replace("-", "");
		line = line.replace(" ", "");
		StringBuffer hue = new StringBuffer(line.length());
		Matcher match = Pattern.compile("\\p{Upper}\\p{Lower}*").matcher(line);
		while(match.find()) {
			
			match.appendReplacement(hue," $0 ");
		}
		match.appendTail(hue);
		line = hue.toString();
		line = line.trim();
		System.out.println(line);
		words = line.split(" ");
		if (words.length != 4) {
			System.out.println(line);
			throw new MalformedException();
		}
		return words;
				
	}

}
