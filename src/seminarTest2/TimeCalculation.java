package seminarTest2;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeCalculation {
	int minute = 0;
	int calHour = 0;
	int calMinute = 0;
	int startHour = 9;
	int startMinute = 0;
	
	public String seminarName(String seminarName) {
		String name = seminarName;
		return name;
	}
	
	public LocalTime seminarTime(int startH, int startM) {
		LocalTime Time = LocalTime.of(startH, startM);
		return Time;
	}
	
//	public String lunchName() {
//		String lunch = "Lunch";
//		return lunch;
//	}
//	
//	public LocalTime lunchTime() {
//		LocalTime Time = LocalTime.of(12, 0);
//		return Time;
//	}
//	
//	public String NEName() {
//		String NE = "Networking Event";
//		return NE;
//	}
//	
//	public LocalTime NETime(int userMinute) {
//		LocalTime NETime = LocalTime.of(calHour(userMinute), calMinute(userMinute));
//		seminarTime(9, 0);
//		return NETime;
//	}
	
	public int calHour(int userMinute) {
		LocalTime Time = LocalTime.of(startHour, startMinute);
		int newHour = (userMinute + startMinute) / 60;
		calHour = Time.getHour() + newHour;
		startHour = calHour;
		return calHour;
	}
	
	public int calMinute(int userMinute) {
		calMinute = (userMinute + startMinute) % 60;
		startMinute = calMinute;
		return calMinute;
	}
	
	void showSeminarNameAndTime(String seminarName, int userMinute) {
		ArrayList<String> seminarNameArray = new ArrayList<>();
		seminarNameArray.add(seminarName);
		
		for (int i = 0; i < seminarNameArray.size(); i++) {
			LocalTime BeginTime = seminarTime(startHour, startMinute);
			calHour(userMinute);
			calMinute(userMinute);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
			System.out.print(BeginTime.format(dtf) + " ");
			System.out.println(seminarNameArray.get(i));
			
		}
		
	}
	
	
}
