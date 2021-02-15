import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.math.BigInteger;

public class LucasNumbers {

	public LucasNumbers()
	{
		File filename = new File("C:\\\\Users\\\\dhanu\\\\eclipse-workspace\\\\Datastructures\\\\data\\\\lucasNumbers.txt");
		try
		{
			
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String text;
			BigInteger A, B,C;
			A  = BigInteger.valueOf(2);
			B  = BigInteger.valueOf(1);
			
			while((text=input.readLine())!=null)
			{

				try
				{
					//BigInteger value = new BigInteger(text);
					
					int value1 = Integer.parseInt(text);
					int val; 
					C = BigInteger.valueOf(0);
					BigInteger Value = BigInteger.valueOf(value1);
					A  = BigInteger.valueOf(2).abs();
					B  = BigInteger.valueOf(1).abs();
					if(value1 == 1) {
						val = 0;
					}
					else {
						val = 1; 
					}
					for(BigInteger forX = BigInteger.valueOf(val); forX.compareTo(Value) < 0;forX = (BigInteger.valueOf(forX.intValue() + 1))){
						//System.out.println("Value : " + value1);
						//System.out.println("Value of A" + A);
						//System.out.println("Value of B" + B);
						if (value1 == 1) {
							C = B.abs();
						}
						else {
							C = A.add(B).abs();
						}
						
						//System.out.println("Value of C" + C);
						A  = B.abs();
						B  = C.abs();
					}
					
					System.out.println("input: " + C.abs());
				
				}catch(NumberFormatException ee )
				{
				}
				
				
			}

		}catch(IOException e)
		{
			System.out.println("File not found.");
		}	
			
	}

	
	public static void main(String[] args) {
		
		LucasNumbers app = new LucasNumbers();

	}

}
