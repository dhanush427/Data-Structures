import java.io.*;

public class Spiral {
	
	public Spiral() {

	File filename = new File("C:\\\\Users\\\\dhanu\\\\eclipse-workspace\\\\Datastructures\\\\data\\\\spiral.txt");
	
	try {
		
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String text;
		while((text=input.readLine())!=null)
		{
			
			String[][] array = new String[Integer.parseInt(text)][Integer.parseInt(text)];
			
			for (int r = 0; r < array.length; r++)
	        {
	            for (int c = 0; c < array[r].length; c++)
	            	array[r][c] = " - ";
	        }
			for (int r = 0; r < array.length; r++)
	        {
	            for (int c = 0; c < array[r].length; c++) {
	            	System.out.print(array[r][c]);
	            }
	            System.out.println();
	        } 
			
			int startRow = 0;
			int startCol = 0;
			int endRow = Integer.parseInt(text)-1;
			int stopIndex = Integer.parseInt(text);
			int endCol = Integer.parseInt(text)-1;
			
						
			while (startRow <= endRow && startCol <= endCol) {
				
			//right
				for(int c = startCol; c <= endCol; c++) {
					
					array[startRow][c] = " 1 ";
		
				}
				startRow++;
			
				//down
				for(int r = startRow; r <= endRow; r++) {					
					array[r][endCol ] = " 2 ";

				}
				endCol--;	
				
				if(startRow > 1)
					startCol++;
				
				if(stopIndex % 2 == 0 && endCol == 0)
					startCol++;
				
				if(stopIndex % 2 == 0 && (Integer.parseInt(text) % 4 == 2) && endCol == 0)
					startCol++;
				
			//left
				
				
				for(int c = endCol; c >= startCol; c--) {	
					
					array[endRow][c] = " 3 ";
				}
				endRow--;	
				
				startRow++;
			//up	
				for(int r = endRow; r >= startRow; r--) {					
					array[r][startCol] = " 4 ";
				}
				
				
			
				//startRow++;
				endCol--;
				endRow--;
				startCol++;
			
		
			}
			
			if((Integer.parseInt(text))%4==2) {
				array[((Integer.parseInt(text))/2)][((Integer.parseInt(text))/2)-1] = " - ";
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			for (int r = 0; r < array.length; r++)
	        {
	            for (int c = 0; c < array[r].length; c++) {
	            	System.out.print(array[r][c]);
	            }
	            System.out.println();
	        } 
			
		}
	
	}catch(IOException e)
	{
		System.out.println("File not found.");
	}	
		
	}
	public static void main(String[] args) {
		Spiral app = new Spiral();
	}
}
