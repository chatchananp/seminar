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
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
	
	public String seminarName(String seminarName) {
		String name = seminarName;
		return name;
	}
	
	public LocalTime seminarTime(int startH, int startM) {
		LocalTime Time = LocalTime.of(startH, startM);
		return Time;
	}
	
	public int setHour(int hr) {
		startHour = hr;
		return startHour;
	}
	
	public int setMinute(int min) {
		startMinute = min;
		return startMinute;
	}
	
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

	public LocalTime BeginTime(int userMinute) {
		LocalTime BeginTime = seminarTime(startHour, startMinute);
		return BeginTime;
	}
	
	public LocalTime EndTime(int userMinute) {
		int endHr = calHour(userMinute);
		int endMin = calMinute(userMinute);
		LocalTime EndTime = seminarTime(endHr, endMin);
		return EndTime;
	}
	
	void normalTime (String seminarName, int userMinute) {
		ArrayList<String> seminarNameArray = new ArrayList<>();
		seminarNameArray.add(seminarName);
		
		for (int i = 0; i < seminarNameArray.size(); i++) {
			LocalTime beginT = BeginTime(userMinute);
			LocalTime endT = EndTime(userMinute);
			
			System.out.print(beginT.format(dtf) + " ");
			System.out.print(endT.format(dtf) + " ");
			System.out.print(seminarNameArray.get(i) + " ");
			System.out.println(userMinute + "min");
		}
	}
	
	void showSeminarNameAndTime(String seminarName, int userMinute) {
		normalTime(seminarName, userMinute);
		
	}
	
	
}
