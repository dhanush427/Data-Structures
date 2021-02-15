import java.util.*;
import java.io.*;

public class Census {

	ArrayList<Citizen> listOfCitizens;
	
	public Census() {
		
		listOfCitizens = new ArrayList<Citizen>();
		File filename = new File("data/FedCensus1930_CambriaCountyPA.txt");
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String text;
			while((text = input.readLine()) != null){
				
				if(text.length()>2 && text.substring(0,2).equals("17")){
					String first = text.substring(71,88).trim();
					String last = text.substring(55,71).trim();
					String streetName = text.substring(20,36).trim();
					String streetNumber = text.substring(36,45).trim();
					String relation = text.substring(88,108).trim();
					String rentOwn = text.substring(108,113).trim();
					String valueProp = text.substring(113,121).trim();
					String gender = text.substring(133,134).trim();
					String age = text.substring(143, 151).trim();
					String maritalStatus = text.substring(151,156).trim();
					String ageFirstMarriage = text.substring(156,162).trim();
                    String attendSchool = text.substring(162, 167).trim();
                    String canRead = text.substring(167,173).trim();
                    String birthplace= text.substring(173, 190);
                    String fathersBirthplace = text.substring(190, 207).trim();
                    String mothersBirthplace =text.substring(207,224).trim();
                    String motherTounge  = text.substring(224,235).trim();
                    String yearImmigrated = text.substring(235,241).trim();
                    String occupation = text.substring(252, 274).trim();
                    String industry = text.substring(274,303).trim();
                    String transcribedRemark = text.substring(342).trim();

                    
                    listOfCitizens.add(new Citizen(first,last,streetName,streetNumber,relation,rentOwn,valueProp,gender,age,maritalStatus,ageFirstMarriage,attendSchool,canRead,birthplace,fathersBirthplace,mothersBirthplace,motherTounge,yearImmigrated,occupation,industry,transcribedRemark));
                }
			}
			
			}catch(IOException io) {
				System.out.println("File Error");
			}
		
			Collections.sort(listOfCitizens);
	
			for(int x=listOfCitizens.size()-1;x>=0;x--){
				String last = listOfCitizens.get(x).getLast();
				String first = listOfCitizens.get(x).getFirst();
				if(last.equals(".") && first.equals("."))
					listOfCitizens.remove(x);
			}
			
			streetCitizen();
			lineOfStars();
			birthPlaceAge();
			lineOfStars();
			motherToungeName();
			lineOfStars();
			occupationFatherBirthplace();
			lineOfStars();
			genderRemarks();
			lineOfStars();
			rentOwnValues();
	}
		
	public void lineOfStars(){
		System.out.println("********************************************************************");
	}
	
	public void rentOwnValues(){
		TreeMap<String, TreeSet<Double>> rentOwnValuesMap= new TreeMap<>();
		for(Citizen c:listOfCitizens){
			if(!rentOwnValuesMap.containsKey(c.getRentOrOwn()))
				rentOwnValuesMap.put(c.getRentOrOwn(), new TreeSet<Double>());
			rentOwnValuesMap.get(c.getRentOrOwn()).add(c.getPropValue());

		}
		Iterator<String> it = rentOwnValuesMap.keySet().iterator();
		while(it.hasNext()){
			String rentOwn=it.next();
			System.out.println(rentOwn+":");
			TreeSet<Double> temp = rentOwnValuesMap.get(rentOwn);
			for(Double num:temp)
				System.out.println("\t"+num);
		}
	}
	
	public void streetCitizen(){
		TreeMap<String, TreeSet<Citizen>> streetCitizenMap = new TreeMap<>();
		for(Citizen c: listOfCitizens){
			if(!streetCitizenMap.containsKey(c.getStreet()))
				streetCitizenMap.put(c.getStreet(), new TreeSet<Citizen>());
			streetCitizenMap.get(c.getStreet()).add(c);
		}
		Iterator<String> it = streetCitizenMap.keySet().iterator();
		while(it.hasNext()){
			String street = it.next();
			System.out.println(street + ":");
			TreeSet<Citizen> temp = streetCitizenMap.get(street);
			for(Citizen c:temp)
				System.out.println("\t"+c);
		}
	}
	
	public void birthPlaceAge(){
		TreeMap<String, PriorityQueue<Double>> birthplaceAgeMap = new TreeMap<>();
		for(Citizen c: listOfCitizens){
			if(!birthplaceAgeMap.containsKey(c.getBirthplace()))
				birthplaceAgeMap.put(c.getBirthplace(), new PriorityQueue<Double>());
			birthplaceAgeMap.get(c.getBirthplace()).add(c.getAge());
		}
		Iterator<String> it = birthplaceAgeMap.keySet().iterator();
		while(it.hasNext()){
			String birthplace = it.next();
			System.out.println(birthplace+":");
			PriorityQueue<Double> temp=birthplaceAgeMap.get(birthplace);
			System.out.println("[");
			while(!temp.isEmpty()){
				double age=temp.poll();
				if(age>=0){
					if(temp.peek()!=null)
						System.out.print(age+", ");
					else
						System.out.print(age);
				}
			}
			System.out.println("]");
		}
	}
	
	public void motherToungeName(){
		TreeMap<String,ArrayList<String>> motherTongueNameMap = new TreeMap<>();
		for(Citizen  c: listOfCitizens){
			if(!motherTongueNameMap.containsKey(c.getMothertongue()));
				motherTongueNameMap.put(c.getMothertongue(), new ArrayList<String>());
			motherTongueNameMap.get(c.getMothertongue()).add(c.getFirst()+" "+c.getLast());
		}
		Iterator<String> it=motherTongueNameMap.keySet().iterator();
		while(it.hasNext()){
			String motherTongue = it.next();
			System.out.println(motherTongue+":");
			ArrayList<String> temp = motherTongueNameMap.get(motherTongue);
			for(String c: temp)
				System.out.println("\t"+c);
		}
	}
	
	public void occupationFatherBirthplace(){
		TreeMap<String, HashSet<String>> occupationFatherBirthplace= new TreeMap<>();
		for(Citizen c: listOfCitizens){
			if(!occupationFatherBirthplace.containsKey(c.getOccupation()))
				occupationFatherBirthplace.put(c.getOccupation(), new HashSet<String>());
			occupationFatherBirthplace.get(c.getOccupation()).add(c.getFathersBirthplace());
		}
		Iterator<String> it=occupationFatherBirthplace.keySet().iterator();
		while(it.hasNext()){
			String occupation = it.next();
			System.out.println(occupation+":");
			HashSet<String> temp = occupationFatherBirthplace.get(occupation);
			Iterator<String> hashIt=temp.iterator();
			while(hashIt.hasNext())
				System.out.println("\t"+hashIt.next());
		}
	}
	
	public void genderRemarks(){
		TreeMap<String,HashSet<String>> genderRemarksMap = new TreeMap<>();
		for(Citizen c: listOfCitizens){
			if(!genderRemarksMap.containsKey(c.getGender()))
				genderRemarksMap.put(c.getGender(),new HashSet<String>());
			genderRemarksMap.get(c.getGender()).add(c.getTranscibedRemarks());
		}
		Iterator<String> it= genderRemarksMap.keySet().iterator();

		while(it.hasNext()){
			String gender = it.next();
			System.out.println(gender+":");
			HashSet<String> temp = genderRemarksMap.get(gender);
			for(String st:temp)
				System.out.println("\t"+st);
		}

	}
	////////////////////////// Tried to make a TreeMap // Tried to print all the males in a certain street
	public void streetNameMales() {
		TreeMap<String, TreeSet<Citizen>> streetNameMale = new TreeMap<>();
		for(Citizen c: listOfCitizens){
			if(!streetNameMale.containsKey(c.getStreet()))
				streetNameMale.put(c.getStreet(), new TreeSet<Citizen>());
			streetNameMale.get(c.getStreet()).add(c);
		}
		Iterator<String> it = streetNameMale.keySet().iterator();
		while(it.hasNext()){
			String gender = it.next();
			System.out.println(gender+":");
			TreeSet<Citizen> temp = streetNameMale.get(gender);
			for(Citizen st:temp)
				System.out.println("\t"+st);
		}
	}
	////////////////////////////
	public static void main(String[] args) {
		Census app = new Census();
	}

}
