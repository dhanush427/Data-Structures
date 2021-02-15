import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.io.*;

public class CarTask{

	Stack<Car> StackCar;
	Queue<Car> QueueCar;
	PriorityQueue<Car> PQCar;

	public CarTask(){
		StackCar = new Stack<Car>();
		QueueCar = new LinkedList<>();
		PQCar = new PriorityQueue<>();

		try{
			File file = new File("data/CarData.txt");
			
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			input.readLine();
			int start;
			int last;
			while((text=input.readLine())!=null){
				start = 0;
                last = text.indexOf("	");
                int ID = Integer.parseInt(text.substring(start,last));

                start = last+1;
                last = text.indexOf("	",start);
                int MPG = Integer.parseInt(text.substring(start,last));

                start = last+1;
                last = text.indexOf("	",start);
                int engineSize = Integer.parseInt(text.substring(start,last));

                start = last+1;
                last = text.indexOf("	",start);
                int horsePower = Integer.parseInt(text.substring(start,last));

                start = last+1;
                last = text.indexOf("	",start);
                int weight = Integer.parseInt(text.substring(start,last));

                start = last+1;
                last = text.indexOf("	",start);
                int accel = Integer.parseInt(text.substring(start,last));

                start = last+1;
                last = text.indexOf("	",start);
                String country = (text.substring(start,last));
                start  = last+1;
                last = start+1;
                int cylinders = Integer.parseInt(text.substring(start,last));

                Car car = new Car(accel,MPG,horsePower,engineSize,weight,cylinders,ID,country);

                StackCar.add(car);
                QueueCar.add(car);
                PQCar.add(car);
			}
		}catch(IOException io){
			System.err.println("ERROR");
		}
		
		printOutPut();

	}

	public void printOutPut(){
		

		System.out.println("Queue\n\n");

		//int x = 0;
		while(!QueueCar.isEmpty()){
			System.out.println(QueueCar.poll().toString());
			//System.out.println(" First " + QueueCar.size());
			//x++;
		}

		System.out.println("\n\nStack");
		
		
		while(!StackCar.isEmpty()){
			System.out.println(StackCar.pop().toString());
		}
		
		System.out.println("\n\nPriorityQueue");
		while(!PQCar.isEmpty()){
			System.out.println(PQCar.poll().toString());
        }
	}


	public static void main(String [] args){
		CarTask app = new CarTask();
	}

}