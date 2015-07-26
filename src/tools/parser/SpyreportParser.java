package tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import stuff.Planet;
import stuff.Player;
import stuff.Spyreport;
import exceptions.MalformedException;
import functionality.PlayerData;
import functionality.Settings;

public class SpyreportParser {
	
	static String[] header;
	
	public static Spyreport parseReportByFile(File kb) {
		HashMap<String,Integer> content = new HashMap<String,Integer>();
		try {
			header = null;
			String line;
			String[] words;
			
			BufferedReader readspy = new BufferedReader(new FileReader(kb));
			
			while((line = readspy.readLine()) != null) {
				line = line.replace("\t", " ");
				if (line.contains("Rohstoffe")) {
					header = parseReportHeader(line);
					System.out.println("Headline gefunden!");
				} else if (isInfoLine(line)){
					
					line = line.replace(":", "");
					line = line.replace(".", "");
					words = line.split(" ");
					if (words.length!=4) {
						System.out.println("Auxparser!\n"+line);
						words = AuxillaryParser.repairLine(line);
					} 
					for(int i=0;i<words.length;i+=2){
						content.put(words[i], Integer.parseInt(words[i+1]));
					}
				}	
			}
			readspy.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MalformedException e) {
			e.printStackTrace();
		}
		if (Settings.ANTIGAME_ON) {
			Planet p = PlayerData.searchOrCreatePlanet(header[1], AuxillaryParser.parseCoordinatesFromString(header[2]), searchOrCreatePlayer(header[3]));
			if (p != null) {
				return new Spyreport(p,content);
			} else {
				return new Spyreport(content);
			}
		} else {
			Planet p =PlayerData.searchOrCreatePlanet(header[0], AuxillaryParser.parseCoordinatesFromString(header[1]), searchOrCreatePlayer(header[2]));
			if (p != null) {
				return new Spyreport(p,content);
			} else {
				return new Spyreport(content);
			}
		}
	}
	
	private static Player searchOrCreatePlayer(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isInfoLine(String line) {
		for (String s : Settings.SPYINFOLINEWORDS) {
			if(line.contains(s)) {
				return true;
			}
		}
		return false;
	}


	private static String[] parseReportHeader(String line) {
		String[] words;
		line = line.replace(")", "");
		line = line.replace("(", "");
		words = line.split(" ");
		if (!Settings.ANTIGAME_ON) {
			return new String[]{words[2],words[3], words[5]};
		} else {
			return new String[]{words[0],words[3],words[4],words[6]};
		}
		
		
	}

}
