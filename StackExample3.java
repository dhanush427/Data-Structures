import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class StackExample3 {

	public static void main(String[] args) {
		
		File filename = new File("C:/Users/dhanu/eclipse-workspace/Datastructures/data/StarWarsCharacters.csv");
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String text;
			
			Stack<Character> male = new Stack();
			Stack<Character> female = new Stack();
			Stack<Character> droids = new Stack();
			Stack<Character> birth = new Stack();
			Character charObj = null;
			while((text=input.readLine())!=null)
			{
				
				String[] line = text.split(",");
				charObj = new Character();
				charObj.setName(line[0]);
				charObj.setBirthYear(line[5]);
				charObj.setGender(line[6]);
				charObj.setWorldHome(line[7]);
				charObj.setSpecies(line[8]);
				
				if((charObj.getGender()).equals("male"))
					male.push(charObj);
				
				if ((charObj.getGender()).equals("female"))
					female.push(charObj);
				
				if ((charObj.getSpecies()).equals("Droid"))
					droids.push(charObj);
				
				if ((charObj.getBirthYear()).endsWith("BBY")) {
					birth.push(charObj);
				}
					
			}
			
			
			System.out.println("Male Characters");
			String printString = String.format("%-40s%-40s", "Name","Homeworld");
			System.out.println(printString);
			
			while (!male.empty())
			{
				Character c = male.pop();
				printString = String.format("%-40s%-40s", c.getName(), c.getWorldHome());
				System.out.println(printString);
			}
			
			System.out.println();
			System.out.println("Female Characters");
			printString = String.format("%-40s%-40s", "Name","Homeworld");
			System.out.println(printString);
			
			while (!female.empty())
			{
				Character c = female.pop();
				printString = String.format("%-40s%-40s", c.getName(), c.getWorldHome());
				System.out.println(printString);
			}
			
			System.out.println();
			System.out.println("Droids");
			printString = String.format("%-40s%-40s", "Name","Homeworld");
			System.out.println(printString);
			
			while (!droids.empty())
			{
				Character c = droids.pop();
				printString = String.format("%-40s%-40s", c.getName(), c.getWorldHome());
				System.out.println(printString);
			}
			
			System.out.println();
			System.out.println("Ages");
			printString = String.format("%-40s%-40s%-40s", "Name","Homeworld","Birth Year");
			System.out.println(printString);
			
			while (!birth.empty())
			{ 
				Character c = birth.pop();
				printString = String.format("%-40s%-40s%-40s", c.getName(), c.getWorldHome(),c.getBirthYear());
				System.out.println(printString);
			}
		}
		catch(Exception e) {
			
		}

	}
}

class Character{

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWorldHome() {
		if (worldHome.equals("NA")) {
			return "Unknown";
		}
		else 
			return worldHome;
	}
	public void setWorldHome(String worldHome) {
		this.worldHome = worldHome;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	private String name;
	private String birthYear;
	private String gender;
	private String worldHome;
	private String species;

	
	
}

