import java.util.ArrayList;
import java.util.Calendar;

public class Flight extends Thread implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Calendar arrivalTime;
	private Calendar departure;
	private Calendar takenTime;
	private ArrayList<String> weekdays;
	private String flightNumber;
	private String nameOfAirlines;
	private Capital takeoffFrom, landTo;
	private String status = "onGround";

	//Thread'in run fonksiyonunda kontrol için kullanılacak iki değişken, görevleri kalkış ve iniş zamanını kontrol etmek.
	public boolean isDepartureTime = false;
	public boolean isArrivalTime = false;
	@Override
	public void run() {
		while(true) {
			isDepartureTime = false;
			isArrivalTime = false;
			while(!this.isDepartureTime) {
				
				if((departure.get(Calendar.HOUR_OF_DAY) == extratab.cal.get(Calendar.HOUR_OF_DAY) && departure.get(Calendar.MINUTE) == extratab.cal.get(Calendar.MINUTE) && departure.get(Calendar.SECOND) == extratab.cal.get(Calendar.SECOND) && isToday()) /*|| (ctrl && isToday())*/ ) {
					this.isDepartureTime = true;
					this.setStatus("isFlying");
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			while(!this.isArrivalTime) {
				
				if(arrivalTime.get(Calendar.HOUR_OF_DAY) == extratab.cal.get(Calendar.HOUR_OF_DAY) && arrivalTime.get(Calendar.MINUTE) == extratab.cal.get(Calendar.MINUTE) && arrivalTime.get(Calendar.SECOND) == extratab.cal.get(Calendar.SECOND) && isToday()) {
					this.isArrivalTime = true;
					this.setStatus("givePermission");
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	//Uçuşun bugün olup olmadığını kontrol eder.
	public boolean isToday() {
			int i = extratab.cal.get(Calendar.DAY_OF_WEEK);
			if(i == 1) {
				return weekdays.contains("Sunday");
			}
			else if(i == 2) {
				return weekdays.contains("Monday");
			}
			else if(i == 3) {
				return weekdays.contains("Tuesday");
			}
			else if(i == 4) {
				return weekdays.contains("Wednesday");
			}
			else if(i == 5) {
				return weekdays.contains("Thursday");
			}
			else if(i == 6) {
				return weekdays.contains("Friday");
			}
			else if(i == 7) {
				return weekdays.contains("Saturday");
			}
			return false;
		}

	//CONSTRUCTOR
	public Flight(Calendar arrivalTime, Calendar departure, ArrayList<String> weekdays, String flightNumber, String nameOfAirlines, Capital takeoffFrom, Capital landTo, Calendar takenTime) {
		
		this.arrivalTime = arrivalTime;
		this.departure = departure;
		this.weekdays = weekdays;
		this.flightNumber = flightNumber;
		this.nameOfAirlines = nameOfAirlines;
		this.takeoffFrom = takeoffFrom;
		this.landTo = landTo;
		this.takenTime = takenTime;
	}

	//GETTERS AND SETTERS
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setNameOfAirlines(String nameOfAirlines) {
		this.nameOfAirlines = nameOfAirlines;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public ArrayList<String> getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(ArrayList<String> weekdays) {
		this.weekdays = weekdays;
	}

	public Capital getTakeoffFrom() {
		return takeoffFrom;
	}

	public void setTakeoffFrom(Capital takeoffFrom) {
		this.takeoffFrom = takeoffFrom;
	}

	public Capital getLandTo() {
		return landTo;
	}

	public void setLandTo(Capital landTo) {
		this.landTo = landTo;
	}

	public Calendar getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Calendar getDeparture() {
		return departure;
	}

	public void setDeparture(Calendar departure) {
		this.departure = departure;
	}

	public Calendar getTakenTime() {
		return takenTime;
	}

	public void setTakenTime(Calendar takenTime) {
		this.takenTime = takenTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getNameOfAirlines() {
		return nameOfAirlines;
	}
}
