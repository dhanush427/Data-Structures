import java.util.*;
import java.text.SimpleDateFormat;

public class Passenger implements Comparable<Passenger> {

    private String firstName;
    private String lastName;
    private String flightCity;
    private String flightTime;
    

    public Passenger(String firstName, String lastName, String city, String time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightCity = city;
        this.flightTime = time;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String flightCity() {
        return flightCity;
    }
    
    public String flightTime() {
        return flightTime;
    }

    public int etdCalc() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String time;
        if(flightTime.split(":")[0].length() > 1) {
        	time = flightTime;
        }
        else {
        	time = "0" + flightTime;
        }
        if((time.substring(6).equals("AM") && !flightTime.split(":")[0].equals("12")) || (time.substring(6).equals("PM") && flightTime.split(":")[0].equals("12"))) {
            time = time.substring(0, 6);
        }
        else
            time = (Integer.parseInt(time.split(":")[0]) + 12) + ":" + time.split(":")[1].substring(0, 2);
        try {
            Date date = sdf.parse(time);
            Date current = sdf.parse("09:03");
            double difference = date.getTime() - current.getTime();
            if(difference < 0) {
            	difference += 24L * 3600 * 1000;
            }
            if(time.split(":")[0].equals("12")) {
            	difference -=  12L * 3600 * 1000;
            }
            return (int)difference / 60000;
        } catch(Exception e) {
            System.err.println("error");
        }
        return 0;
    }
    
    public int compareTo(Passenger person) {
        int p1 = etdCalc();
        int p2 = person.etdCalc();
        if(p1 == p2 || (p1 > 60 && p2 > 60))
            return 0;
        return (p1 - p2) / Math.abs(p1-p2);
    }

    public String toString() {
        int minutes = etdCalc();
        String result = "";
        if(minutes > 60) {
        	if(minutes/60 >= 2)
        		result = (minutes/60) + " hours" + " and " ;
        	else 
        		result = (minutes/60) + " hour" + " and " ;
        }
        return lastName + ", "+ firstName + " - " + flightCity + " - " + flightTime + " - " + result + (minutes%60) + " minutes.";
    }

}