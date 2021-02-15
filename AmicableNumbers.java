import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class AmicableNumbers {

	public AmicableNumbers(){
	File filename = new File("C:\\\\Users\\\\dhanu\\\\eclipse-workspace\\\\Datastructures\\\\data\\\\amicable.txt");
	try
	{
		int sum = 0;
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String text;
		ArrayList<Integer> num1Multiples = new ArrayList<Integer>(); 
		ArrayList<Integer> num2Multiples = new ArrayList<Integer>(); 
		
		while((text=input.readLine())!=null)
		{
			int[] amicableTotal=new int[2];
			
			String[] pair = text.split(" ");
			int value1 = 0;
			if(pair.length == 2) {
		
				num1Multiples = findMultiples(Integer.parseInt(pair[0]));
				num2Multiples = findMultiples(Integer.parseInt(pair[1]));
			}
		
		int a1 = num1Multiples.get(0);
		int an = num1Multiples.get(num1Multiples.size()-1);
		int b1 = num2Multiples.get(0);
		int bn = num2Multiples.get(num2Multiples.size()-1);
		
		if(a1==bn && b1==an)  {
			System.out.println("The numbers "+ a1 + " and " + b1 + " are amicable.");
		}
		else {
			System.out.println("The numbers "+ a1 + " and " + b1 + " are not amicable.");
		}
		
		printOutput(num1Multiples,a1,an);
		
		printOutput(num2Multiples,b1,bn);
		System.out.println();

		}
		
		
	}
	catch(Exception e) {
		
	}
}
	
	public void printOutput(ArrayList<Integer> list, int numStart, int numEnd) {
		list.remove(0);
		list.remove(list.size()-1);
		System.out.print("Factors of " + numStart + " are ");
		String num1Text = new String();
		for(int i = 0 ; i < list.size() ; i++)
			if(i == list.size()-2) {
				num1Text = num1Text+ "" + list.get(i) + " and ";
				num1Text = num1Text+ "" + list.get(i+1) + ".";
				break;
			}
			else
				num1Text = num1Text+ "" + list.get(i) + ", ";
		
		System.out.println(num1Text.substring(0, num1Text.length()-1) + ". Sum is " + numEnd + ".");
	}
	public ArrayList findMultiples(int value) {
		int total = 0;
		ArrayList<Integer> multiplesArrayList = new ArrayList<Integer>();
		multiplesArrayList.add(value);
		for (int i = 1; i < value;i++) {
			if ((value) % i == 0) {
				total += i;
				multiplesArrayList.add(i);
			}
		}
		multiplesArrayList.add(total);
		return multiplesArrayList;
	}

	public static void main (String[]args){
	
		AmicableNumbers app = new AmicableNumbers();

	}
}
