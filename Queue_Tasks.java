import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue_Tasks {

	public static void main(String[] args) {
		doTaskOne();
		System.out.println("\n_______________________________________________________________________________");
		System.out.println("Task Two : part a");
		doTaskTwo();
		System.out.println("\n_______________________________________________________________________________");
		System.out.println("Task Two : part b");
		doTaskThree();
		
	}
	
	public static void doTaskOne() {
        try {
            Queue<Word> queue = new LinkedList<>();
            PriorityQueue<Word> ascendingQueue = new PriorityQueue<>();
            PriorityQueue<Word> decendingQueue = new PriorityQueue<>();

            File file = new File("data/queue1.txt");
            
            BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			String[] allWords = null;
			while((text=input.readLine())!=null) {
				allWords = text.split(" ");
			}
            
            for(String word: allWords) {
                Word w = new Word(word);
                Word w2 = new WordReverse(word);
                queue.add(w);
                ascendingQueue.add(w);
                decendingQueue.add(w2);

            }
            System.out.printf("%-10s %-10s %s\n", "Queue", "Ascending", "Decending");

            while(!queue.isEmpty()) {
                System.out.printf("%-10s %-10s %s\n", queue.poll(), ascendingQueue.poll(), decendingQueue.poll());
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
            System.err.println("Error");
        }
        
    }
	
	public static void doTaskTwo() {
		try {
            Queue<Passenger> queue = new LinkedList<>();

            File file = new File("data/PassengerInfo.txt");
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while((text=input.readLine())!=null) {
				list.add(text);
			}
            for(int i = 0; i + 2 < list.size(); i += 3) {
                queue.add(new Passenger((list.get(i)).split(" ")[0],(list.get(i)).split(" ")[1], list.get(i + 1), list.get(i + 2)));
            }
            while(!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            
        } catch(IOException e) {
            System.err.println("Error in Task 2");
        }
	}
	
	public static void doTaskThree() {
		try {
			PriorityQueue<Passenger> queue = new PriorityQueue<>();

            File file = new File("data/PassengerInfo.txt");
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while((text=input.readLine())!=null) {
				list.add(text);
			}
            for(int i = 0; i + 2 < list.size(); i += 3) {
                queue.add(new Passenger((list.get(i)).split(" ")[0],(list.get(i)).split(" ")[1], list.get(i + 1), list.get(i + 2)));
            }
            while(!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            
        } catch(IOException e) {
            System.err.println("Error in Task 3");
        }
	}

}
