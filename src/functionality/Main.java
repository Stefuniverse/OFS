package functionality;

import java.io.File;


import stuff.Spyreport;
import tools.parser.SpyreportParser;

public class Main {
	
	public static void main(String[] args) {
		
		
		File f = new File("Testdata.txt");
		Spyreport t = SpyreportParser.parseReportByFile(f);
		System.out.println(t.toString());
	}

}
