import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class test {
	
	public static ArrayList<Flight> flights = new ArrayList<Flight>();
	public static ArrayList<Capital> capitals = new ArrayList<Capital>();
	
	public static void main(String args[]) {
		
		//Dosyaya ilk defa yazılacaksa bu değişken 0 yapılır. Yazılmış dosya üzerinde işlem yapmak için ilk çalıştırmadan sonra bu değişkeni 1 yapınız.
		int ctrl = 0;
		if(ctrl == 0) {
			Capital istanbul = new Capital("İstanbul");
			Capital newyork = new Capital("New York");
			Capital sydney = new Capital("Sydney");
			Capital paris = new Capital("Paris");
			Capital tokyo = new Capital("Tokyo");
			
			capitals.add(istanbul);
			capitals.add(newyork);
			capitals.add(sydney);
			capitals.add(paris);
			capitals.add(tokyo);
		
			ArrayList<String> weekdays = new ArrayList<String>(7);
			weekdays.add("Monday");
			weekdays.add("Tuesday");
			weekdays.add("Wednesday");
			weekdays.add("Thursday");
			weekdays.add("Friday");
			weekdays.add("Saturday");
			weekdays.add("Sunday");
			
			Flight flight1 = new Flight(setCalendar(0,15,0), setCalendar(0,5,0), weekdays, "1001", "THY", paris, tokyo, setCalendar(0,10,0));
			Flight flight2 = new Flight(setCalendar(0,20,0), setCalendar(0,10,0), weekdays, "1002", "American", istanbul, sydney, setCalendar(0,10,0));
			Flight flight3 = new Flight(setCalendar(0,18,0), setCalendar(0,13,0), weekdays, "1003", "Delta", tokyo, paris, setCalendar(0,5,0));
			Flight flight4 = new Flight(setCalendar(0,25,0), setCalendar(0,15,0), weekdays, "1004", "Southwest", newyork, tokyo, setCalendar(0,10,0));
			Flight flight5 = new Flight(setCalendar(0,30,0), setCalendar(0,28,0), weekdays, "1005", "THY", istanbul, newyork, setCalendar(0,2,0));
			Flight flight6 = new Flight(setCalendar(0,22,0), setCalendar(0,12,0), weekdays, "1006", "EasyJet", paris, istanbul, setCalendar(0,10,0));
			Flight flight7 = new Flight(setCalendar(0,20,0), setCalendar(0,14,0), weekdays, "1007", "AirChina", tokyo, sydney, setCalendar(0,6,0));
			Flight flight8 = new Flight(setCalendar(1,10,0), setCalendar(1,0,0), weekdays, "1008", "THY", sydney, newyork, setCalendar(0,10,0));
			Flight flight9 = new Flight(setCalendar(1,35,0), setCalendar(1,15,0), weekdays, "1009", "Delta", newyork, istanbul, setCalendar(0,20,0));
			Flight flight10 = new Flight(setCalendar(2,10,0), setCalendar(2,0,0), weekdays, "1010", "American", newyork, paris, setCalendar(0,10,0));
			
			flights.add(flight1);
			flights.add(flight2);
			flights.add(flight3);
			flights.add(flight4);
			flights.add(flight5);
			flights.add(flight6);
			flights.add(flight7);
			flights.add(flight8);
			flights.add(flight9);
			flights.add(flight10);
			
			Flight_Track gui = new Flight_Track(flights, capitals);
			gui.writeFileCapital(capitals);
			gui.writeFile(flights);
			gui.fillTable();
			gui.setVisible(true);
		}
		else {
			
			createFlightsFromFile();
			createCapitalsFromFile();
			Flight_Track gui = new Flight_Track(flights, capitals);
			gui.fillTable();
			gui.setVisible(true);
		}
		
	}
	
	//Program başlatılırken flights.dat dosyasından flight'leri okuyup arraylist'i doldurur.
	@SuppressWarnings("unchecked")
	public static void createFlightsFromFile() {
		String fileName = "src/flights.dat";
    	ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(fileName));
			flights = (ArrayList<Flight>)reader.readObject();
	    	reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Program başlatılırken capitals.dat dosyasından capital'leri okuyup arraylist'i doldurur.
	@SuppressWarnings("unchecked")
	public static void createCapitalsFromFile() {
		String fileName = "src/capitals.dat";
    	ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(fileName));
			capitals = (ArrayList<Capital>)reader.readObject();
	    	reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Dosyaya ilk defa yazılacak uçuşlar oluşturulurken kullanılıyor.
		public static Calendar setCalendar(int h, int m, int s) {
			Calendar tmp = Calendar.getInstance();
			tmp.set(Calendar.HOUR_OF_DAY, h);
			tmp.set(Calendar.MINUTE, m);
			tmp.set(Calendar.SECOND, s);
			
			return tmp;
		}
		
}
