import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.math.BigInteger;

public class StackExample2 {

	public StackExample2()
	{
		String string = new String();
		
		Stack<String> inverted = new Stack<String>();
		
		string = "Dhanush";
		
		for(int x = 0; x < string.length(); x++) {
			inverted.push(String.valueOf((string.charAt(x))));
		}
		
		
		while (!inverted.empty())
		{
		
		System.out.print ( inverted.pop() );
		
		if(!inverted.empty())
			System.out.print ("");
		else 
			System.out.println();
		}	
			
	}

	
	public static void main(String[] args) {
		
		StackExample2 app = new StackExample2();

	}

}
