import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;  

public class TimeTravel {

	
	
		
	
	public TimeTravel() {

		File filename = new File("C:\\\\Users\\\\dhanu\\\\eclipse-workspace\\\\Datastructures\\\\data\\\\TimeTravel.txt");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance(); 
		//System.out.println(calendar.getTime());
		try {
			
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String text;
			int counter = 1; 
			while((text=input.readLine())!=null)
			{
				String[] data = text.split(" ");
				int day = Integer.parseInt(data[0]);
				int hr = Integer.parseInt(data[1]);
				int min = Integer.parseInt(data[2]);
				
				calendar.add(Calendar.DAY_OF_MONTH, day);
				calendar.add(Calendar.HOUR_OF_DAY, hr);
				calendar.add(Calendar.MINUTE, min);
				
				
				System.out.println("\nTrip: " + counter);
				System.out.println();
				SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm aa");
				
				System.out.println("Departure Date and Time: " + timeFormatter.format(calendar1.getTime()) +" "+ dateFormatter.format(calendar1.getTime()));
				System.out.println();
				System.out.println("Arrival Date and Time: " + timeFormatter.format(calendar.getTime()) +" "+ dateFormatter.format(calendar.getTime()));
				
				//System.out.println(calendar.getTime());
				
				calendar.setTime(calendar1.getTime());		
				
				counter++;

			}
		
		}catch(IOException e)
		{
			System.out.println("File not found.");
		}
	}
	
	public static void main(String[] args) {
		
		TimeTravel timetravel = new TimeTravel();

	}
}
