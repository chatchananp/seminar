package seminarTest2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainProgram extends TimeCalculation {
	public static void main(String[] args) throws IOException {
		mainProgram newObj = new mainProgram();
		ArrayList<String> seminarArray = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\baschatt\\Desktop\\JavaProjectsOnEclipse\\seminarTest2\\src\\seminarTest2\\demo.txt"));) {
			String strLine = br.readLine();
			while (strLine != null) {
				seminarArray.add(strLine);
				strLine = br.readLine();
			}
		}

		for (int i = 0; i < seminarArray.size(); i++) {
			String seminarName = seminarArray.get(i);
			
			String patternString1 = "(.*) (\\d+)";

	        Pattern pattern = Pattern.compile(patternString1);
	        Matcher matcher = pattern.matcher(seminarName);

	        while(matcher.find()) {
	        	String n1 = matcher.group(1);
	        	String n2 = matcher.group(2);
	        	int minute = Integer.parseInt(n2);
	        	
	        	newObj.showSeminarNameAndTime(n1, minute);
	        }
	     
	        
	        
		}
	}
}
