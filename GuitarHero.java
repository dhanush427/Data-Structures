import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GuitarHero {

	public GuitarHero() {

	File filename = new File("data/guitarHero.txt");
	
	try {
		
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String text;
		String[][] outputGrid = null;
		String[] noteNames = {"G#", "G", "F#", "F", "E", "D#", "D", "C#", "C#", "B", "A#", "A",
					"G#", "G", "F#", "F", "E", "D#", "D", "C#", "C", "B", "A#", "A", "G#", "G", "F#", "F", "E"};
		int[][] helper = {
                {29, 24, 19, 14, 10, 5},
                {28, 23, 18, 13, 9, 4},
                {27, 22, 17, 12, 8, 3},
                {26, 21, 16, 11, 7, 2},
                {25, 20, 15, 10, 6, 1}
        };
		int row = 0;
		while((text=input.readLine())!=null)
		{
			String[] song = text.split(",");
			
			if (outputGrid == null) {
				outputGrid = new String[30][song.length + 1];
				outputGrid[0][0] = "Measure";
				
                for (int m = 1; m <= song.length; m++)
                	outputGrid[0][m] = "" + m;
                
                for (int r = 1; r <= noteNames.length; r++)
                	outputGrid[r][0] = noteNames[r - 1];
            }
			
            for (int measure = 0; measure < song.length; measure++) {
                for (int col = 0; col < 6; col++) {
                    if (song[measure].charAt(col) == 'o' || song[measure].charAt(col) == '*')
                        outputGrid[helper[row][col]][measure + 1] = "O";
                }
            }
            row++;
		}
		
		output(outputGrid);
		
	}catch(Exception e) {}
	
	}
	
	public void output(String [][] outputGrid) {
		for (int r = 0; r < outputGrid.length; r++) {
            for (int c = 0; c < outputGrid[0].length; c++) {
                if (outputGrid[r][c] == null)
                    System.out.print("\t");
                else
                    System.out.print(outputGrid[r][c] + "\t");
            }
            System.out.println();
        }
	}
	
	public static void main (String[]args)
	{
		GuitarHero guitarHero = new  GuitarHero();
	}
}
