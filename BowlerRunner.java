import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.Comparator;

public class BowlerRunner{

	public BowlerRunner(){
		File name = new File("data/BowlingData.txt");
		ArrayList<Bowler> list = new ArrayList<Bowler>();
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			while((text = input.readLine())!=null){
				String [] nameArray = text.split(" ");
				String firstName = nameArray[0];
				String lastName = nameArray[1];
				int score = Integer.parseInt(nameArray[2]);
				list.add(new Bowler(firstName,lastName,score));
			}

			TreeMap<Integer, PriorityQueue<Bowler>> map = new TreeMap<>();
			
			BComparator bcomparator = new BComparator();

			for(int x = 0;x<list.size();x++){
				
				int score = list.get(x).getScore();
				
				PriorityQueue<Bowler> temp = new PriorityQueue<>(bcomparator);

				for(int j = 0;j<list.size();j++){
					if(list.get(j).getScore()==score){
						temp.add(list.get(j));
						map.put(score,temp);
					}
				}
			}
			
            Iterator it = map.keySet().iterator();
            Iterator it2 = map.keySet().iterator();
            Iterator it3 = map.keySet().iterator();
            Iterator it4 = map.keySet().iterator();

            System.out.print("{");
			while(it.hasNext()){
				Object obj = it.next();
				System.out.print(obj + "=[");
				int count = 0; 
				for(Bowler bowler:map.get(obj))
				{

					count++;
					
					if(count < map.get(obj).size())
						System.out.print(bowler.getFirst()+" "+bowler.getLast() + ", ");
					else if (count == map.get(obj).size())
						System.out.print(bowler.getFirst()+" "+bowler.getLast());
				}
				System.out.print("]");
            }
            System.out.print("}");
            
            int count = 0 ;

            System.out.println("+++++++++++++++++++++++++++++++++++ \n+++++++++++++ENTRY SET+++++++++++++ \n+++++++++++++++++++++++++++++++++++");

            while(it2.hasNext()){
				Object obj = it2.next();
				System.out.println(obj);
            }

            System.out.println("+++++++++++++++++++++++++++++++++++ \n+++++++++++++++KEYS++++++++++++++++ \n+++++++++++++++++++++++++++++++++++");

            while(it3.hasNext()){
				Object obj = it3.next();
				System.out.print(obj + "=[");
			    count = 0 ;
				for(Bowler bowler:map.get(obj))
				{

                    count++;
					
					if(count < map.get(obj).size())
						System.out.print(bowler.getFirst()+" "+bowler.getLast() + ", ");
					else if (count == map.get(obj).size())
						System.out.print(bowler.getFirst()+" "+bowler.getLast());
				}
				System.out.println("]");
            }
            
            count = 0; 

            System.out.println("+++++++++++++++++++++++++++++++++++ \n++++++++++++++VALUES+++++++++++++++ \n+++++++++++++++++++++++++++++++++++");

            while(it4.hasNext()){
				Object obj = it4.next();
				System.out.print("[");
				count = 0; 
				for(Bowler bowler:map.get(obj))
				{
					count++;
					
					if(count < map.get(obj).size())
						System.out.print(bowler.getFirst()+" "+bowler.getLast() + ", ");
					else if (count == map.get(obj).size())
						System.out.print(bowler.getFirst()+" "+bowler.getLast());
                    
				}
				System.out.println("]");
            }

		}catch(IOException io){
			System.err.println("File does not exist");
		}

	}
	
	
	
	public class BComparator implements Comparator<Bowler>{
		public int compare(Bowler one, Bowler two){
			int comp = one.getLast().compareTo(two.getLast());

			if(comp != 0)
				return comp;
			else
				return one.getFirst().compareTo(two.getFirst());

		}
	}
	
	public static void main(String [] args){
		BowlerRunner app = new BowlerRunner();
	}

}