import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.math.BigInteger;

public class StackExample1 {

	public StackExample1()
	{
		Scanner scanner = new Scanner(System.in); 
		
		
	    System.out.println("Enter a number you want to continue to binary: ");
	    int input = scanner.nextInt(); 
	    
	    printBinary(input);
			
	}

	public void printBinary(int x) {
		
		Stack<Integer> binary = new Stack<Integer>();
		
		if(x == 0) {
			binary.push(0);
		}
		
		else {
		while (x != 0) { 
			
			if(x%2 == 0)
				binary.push(x%2);
			else if (x%2 == 1)
				binary.push(x%2);
			
			x = x/2;
			
		}
		}
		
		while (!binary.empty())
		{
		
		System.out.print (binary.pop() );
		
		if(!binary.empty())
			System.out.print (" ");
		else 
			System.out.println();
		}	
		

	}
	public static void main(String[] args) {
		
		StackExample1 app = new StackExample1();

	}

}
