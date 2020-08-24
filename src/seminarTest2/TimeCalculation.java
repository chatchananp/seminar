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
	int n = 1;
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
		LocalTime beginT = BeginTime(userMinute);
		LocalTime endT = EndTime(userMinute);

		System.out.print(beginT.format(dtf) + " ");
		//System.out.print(endT.format(dtf) + " ");
		System.out.print(seminarName + " ");
		System.out.println(userMinute + "min");
	}

	void showSeminarNameAndTime(String seminarName, int userMinute) {

		ArrayList<String> seminarNameArray = new ArrayList<>();
		seminarNameArray.add(seminarName);

		for (int i = 0; i < seminarNameArray.size(); i++) {
			if (startHour >= 9 && startHour < 11) {
				if (startHour == 9 && startMinute == 0) {
					System.out.println("Day " + n + ":");
				}
				
				normalTime(seminarNameArray.get(i), userMinute);
				
			} else if (startHour >= 11 && startHour <= 12) {
				if (userMinute / 60 <= 1) {
					if (userMinute + startMinute <= 60) {
						normalTime(seminarNameArray.get(i), userMinute);
						
					} else if (userMinute + startMinute > 60) {
						LocalTime LunchTime = seminarTime(12, 0);
						seminarNameArray.add(i, "Lunch");
						System.out.print(LunchTime.format(dtf) + " ");
						System.out.println(seminarNameArray.get(i) + " ");
						setHour(13);
						setMinute(0);
					}

				} else if (userMinute / 60 > 1) {
					LocalTime LunchTime = seminarTime(12, 0);
					seminarNameArray.add(i, "Lunch");
					System.out.print(LunchTime.format(dtf) + " ");
					System.out.println(seminarNameArray.get(i) + " ");
					setHour(13);
					setMinute(0);
				}
				
			} else if (startHour > 12 && startHour < 16) {
				normalTime(seminarNameArray.get(i), userMinute);
				
			} else if (startHour >= 16 && startHour <= 17) {
				if (userMinute / 60 <= 1) {
					if (userMinute + startMinute <= 60) {
						normalTime(seminarNameArray.get(i), userMinute);
						
					} else if (userMinute + startMinute > 60) {
						LocalTime NETime = seminarTime(startHour, startMinute);
						seminarNameArray.add(i, "Networking Event");
						System.out.print(NETime.format(dtf) + " ");
						System.out.println(seminarNameArray.get(i) + "\n");
						setHour(9);
						setMinute(0);
						n++;
					}

				} else if (userMinute / 60 > 1) {
					LocalTime NETime = seminarTime(startHour, startMinute);
					seminarNameArray.add(i, "Networking Event");
					System.out.print(NETime.format(dtf) + " ");
					System.out.println(seminarNameArray.get(i) + "\n");
					setHour(9);
					setMinute(0);
					n++;
					
				}
				
			}
		}
	}

}
