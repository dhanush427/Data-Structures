
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTemplate{
	
	public FileTemplate()
	{
		File filename = new File("C:\\\\Users\\\\dhanu\\\\eclipse-workspace\\\\Datastructures\\\\data\\\\data1.txt");
		try
		{
			int sum = 0;
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String text;
			while((text=input.readLine())!=null)
			{

				String[] pieces = text.split(" ");
				int num = 0;
				
				try
				{
					for(int x = 0; x<pieces.length;x++){
						num = Integer.parseInt(text);
						sum += num;
					}
				}catch(NumberFormatException ee )
				{
				}
				System.out.println(num);
				
			}
				System.out.println(sum);

		}catch(IOException e)
		{
			System.out.println("File not found.");
		}	
			
	}

	public static void main (String[]args){
	
		FileTemplate app = new FileTemplate();

	}
}
