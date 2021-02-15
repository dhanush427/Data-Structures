import java.util.*;
public class SuperListRunner2 {
	
	public SuperListRunner2()
	{
		SuperList<Integer> list=new SuperList<Integer>();
		
		for(int x = 0; x < 30 ; x++) {
			list.add((int)(Math.random()*100)+1);
		}
		
		System.out.println("List : " + list);
		System.out.println("Size of List : " + list.size());
		
		//Stack
		System.out.println("\nStack Version (conversion to a stack):  ");
		SuperList<Integer> tempList=new SuperList<Integer>();
		String output="[";
		int size = 0;
		while(!list.isEmpty())
		{
			int num=list.pop();
			output+=num;
			try
			{
				list.peekStack();
				if(size < list.size())
					output+=", ";
			}
			catch(EmptyStackException e)
			{

			}
			tempList.add(num);

		}
		output+="]";
		list=tempList;
		System.out.println("Stack: "+output);
		
		//Queue
		System.out.println("\nQueue Version (conversion to a queue):  ");
		SuperList<Integer> tempListQ=new SuperList<Integer>();
		output="[";
		while(!list.isEmpty())
		{
			int num=list.poll();
			output+=num;
			if(list.peekQueue()!=null)
				output+=", ";
			tempListQ.push(num);

		}
		output+="]";
		list=tempListQ;
		System.out.println("Queue: "+output);
		
		//ArrayList 
		System.out.println("\nRandom Arraylists");
		SuperList<Integer> newList=new SuperList<Integer>();
		int sizeList = 0;
		output="[";
		while(!list.isEmpty())
		{
			
			if(sizeList < 1) {
				int num=list.poll();
				output+=num;
				
				if(list.peekQueue()!=null)
					output+=", ";
				
				newList.push(num);
				
				sizeList++;
			}
			
			else if (sizeList >= 1) {
				int num=list.poll();
				int randomIndex = (int)(Math.random()*sizeList) + 0;
				newList.add(randomIndex,num);
				sizeList++;
			}
	
		}
		output+="]";
		list=newList;
		System.out.println("Array: "+newList);
		
		//Finding the sums 
		
		SuperList<Integer> addList=new SuperList<Integer>();
		int sum = 0;
		int evenSum = 0;
		int oddSum = 0;
		int oddOreven = 0;
		output="[";
		while(!list.isEmpty())
		{
			int num=list.poll();
			
			if (oddOreven == 0) {
				sum += num;
				evenSum += num;
				oddOreven++;
			}
			else if (oddOreven == 1) {
				sum += num;
				oddSum += num;
				oddOreven--;
			}
			
			output+=num;
			if(list.peekQueue()!=null)
				output+=", ";
			addList.push(num);

		}
		output+="]";
		list=addList;
		System.out.println("\nSum : " + sum);
		System.out.println("EvenSum : " + evenSum);
		System.out.println("OddSum : " + oddSum);
		
		//Duplicates 
		System.out.println("\nAdding Duplicates of Even :  ");
		SuperList<Integer> duplicateList=new SuperList<Integer>();
		
		output="[";
		while(!list.isEmpty())
		{
			int num=list.poll();
			output+=num;
			if(list.peekQueue()!=null)
				output+=", ";
			duplicateList.push(num);

		}
		list=duplicateList;
		for(int i = 0; i < 30; i++) {
			if(duplicateList.get(i) % 2 == 0) {
				duplicateList.add(duplicateList.get(i));
			}
		}
		System.out.println(duplicateList);
		
		for(int i = 0; i < 30; i++) {
			if(duplicateList.get(i) % 3 == 0) {
				duplicateList.remove(i);
			}
		}
		System.out.println("\nRemoving instances divisble by 3 : ");
		System.out.println(duplicateList);
		
		duplicateList.add(4, 5555);
		System.out.println("\nInserting 5555 in 4th position : ");
		System.out.println(duplicateList);
		
		int[] sortListInt = new int[duplicateList.size()];
		
		for(int x = 0; x < duplicateList.size(); x++) {
			sortListInt[x] = (duplicateList.get(x));
		}
		
		for(int i=0;i<sortListInt.length;i++)
        {
            int j = i;
            while(j>0)
            {
                if(sortListInt[j-1] > sortListInt[j])
                {
                    int temp = sortListInt[j-1];
                    sortListInt[j-1] = sortListInt[j];
                    sortListInt[j] = temp;
                }
                else
                {
                    break;
                }
                j--;
            }
        }
		
		
		duplicateList.clear();
		
		for(int x = 0; x < sortListInt.length; x++) {
			duplicateList.add(sortListInt[x]);
		}
		
		System.out.println("\nSorting List in Ascending Order : ");
		System.out.println(duplicateList);
		
		if(duplicateList.size() % 2 == 1 ) {
			System.out.println("\nThe median is " + duplicateList.get((duplicateList.size()-1)/2) + ".");
		}
		if(duplicateList.size() % 2 == 0 ) {
			System.out.println("\nThe median is " + duplicateList.get(((duplicateList.size()/2)+(duplicateList.size()-1))/2) + ".");
		}
		
		
		
		
		SuperList<String> stringList =new SuperList<String>();
		String sentence = "I love to code and do projects";
		String[] split = sentence.split(" ");
		for (int x = 0; x < split.length ; x++) {
			stringList.add(split[x]);
		}
		System.out.println();
		System.out.println("Sentence : ");
		System.out.println(stringList);
		
		for (int x = 0; x < stringList.size() ; x++) {
			if((stringList.get(x)).length() <= 3) {
				stringList.remove(x);
				x--;
			}
		}
		System.out.println("\nSentence after removing words with 3 or less letters : ");
		System.out.println(stringList);
		//
		String[] sortedList = new String[stringList.size()];
		for(int x = 0; x < stringList.size(); x++) {
			sortedList[x] = (stringList.get(x));
		}
		
		String [] fullSorted = sort(sortedList, sortedList.length);
		
		stringList.clear();
		
		for(int x = 0; x < fullSorted.length; x++) {
			stringList.add(sortedList[x]);
		}
		
		System.out.println("\nSorted in Ascending Order : ");
		System.out.println(stringList);
		int totalLetterCount = 0; 
		for(int x = 0; x < stringList.size(); x++) {
			totalLetterCount += (stringList.get(x)).length();
		}
		System.out.println("\nAverage Word Length : " + ((double)totalLetterCount/stringList.size()));
		
	}
	
	public String[] sort(String array[], int length){
		String temp="";
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(array[i].compareToIgnoreCase(array[j])>0){
					temp = array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
		}

	public static void main(String[] args) {
		
		SuperListRunner2 app=new SuperListRunner2();
		
	}

}
