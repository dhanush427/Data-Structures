import java.util.ArrayList;
import java.util.HashSet;
public class Hash_Tree_Set{

	private ArrayList<HashSet<Integer>> list;

	public Hash_Tree_Set(){
		list = new ArrayList<HashSet<Integer>>();

		int randomNum = (int)(Math.random()*10)+2;

		for(int i = 0; i < randomNum; i++){
			HashSet<Integer> hashSet = new HashSet<Integer>();
			while(hashSet.size()<10){
				hashSet.add((int)(Math.random()*30));
			}
			list.add(hashSet);
		}

		for(HashSet<Integer> hash:list)
			System.out.println("Hash:"+hash);
		System.out.println();

		
		
		ArrayList<HashSet<Integer>> intersectionList = new ArrayList<HashSet<Integer>>();
		for(int i = 0;i<list.size()-1;i+=2){
			intersectionList.add(Intersection(list.get(i),list.get(i+1))); 
		}
			if(list.size()%2==0){    
				
				while(intersectionList.size()>1){
					intersectionList.set(0,Intersection(intersectionList.get(0),intersectionList.get(1)));
					intersectionList.remove(1);
				}
				
				System.out.println("\nIntersection: "+intersectionList);
			}
			
			else
				
			if(list.size()%2==1){
				
				while(intersectionList.size()>1){
					intersectionList.set(0,Intersection(intersectionList.get(0),intersectionList.get(1)));
					intersectionList.remove(1);
				
				}
				
				System.out.println("\nIntersection: "+Intersection(intersectionList.get(0),list.get(list.size()-1)));
			
			}

			
			ArrayList<HashSet<Integer>> unionlist = new ArrayList<HashSet<Integer>>();
			
			for(int i = 0;i<list.size()-1;i+=2){
				unionlist.add(Union(list.get(i),list.get(i+1))); //adds union of two sets into an array
			}

				if(list.size()%2==0){
					
					while(unionlist.size()>1){
						unionlist.set(0,Union(unionlist.get(0),unionlist.get(1)));
						unionlist.remove(1);
					}
					
					System.out.println("\nUnion: "+unionlist);
					
				}
				else
					
				if(list.size()%2==1){
					
					while(unionlist.size()>1){
						unionlist.set(0,Union(unionlist.get(0),unionlist.get(1)));
						unionlist.remove(1);
					}
					
					System.out.println("\nUnion: "+Union(unionlist.get(0),list.get(list.size()-1)));
				}
			
			
			
			ArrayList<HashSet<Integer>> Eintersectionlist = new ArrayList<HashSet<Integer>>();
			
			for(int i = 0;i<list.size()-1;i+=2){
				Eintersectionlist.add(EvenIntersection(list.get(i),list.get(i+1))); //adds intersection of two sets into an array
			}
			
			if(list.size()%2==0){
					while(Eintersectionlist.size()>1){
						Eintersectionlist.set(0,EvenIntersection(Eintersectionlist.get(0),Eintersectionlist.get(1)));
						Eintersectionlist.remove(1);
					}
					System.out.println("\nEven Intersection: "+Eintersectionlist);
				}
				else
					
				if(list.size()%2==1){
					while(Eintersectionlist.size()>1){
						Eintersectionlist.set(0,EvenIntersection(Eintersectionlist.get(0),Eintersectionlist.get(1)));
						Eintersectionlist.remove(1);
					}
					
					System.out.println("\nEven Intersection: "+EvenIntersection(Eintersectionlist.get(0),list.get(list.size()-1)));
		}

		

			
		ArrayList<HashSet<Integer>> EUnionlist = new ArrayList<HashSet<Integer>>();
		
		for(int i = 0;i<list.size()-1;i+=2){
			EUnionlist.add(EvenUnion(list.get(i),list.get(i+1))); //adds union of two sets into an array
		}
		
			if(list.size()%2==0){
				
				while(EUnionlist.size()>1){
					EUnionlist.set(0,EvenUnion(EUnionlist.get(0),EUnionlist.get(1)));
					EUnionlist.remove(1);
				}
				
				System.out.println("\nEven Union: "+EUnionlist);
			}
			
			else
			if(list.size()%2==1){
				while(EUnionlist.size()>1){
					EUnionlist.set(0,EvenUnion(EUnionlist.get(0),EUnionlist.get(1)));
					EUnionlist.remove(1);
				}
				System.out.println("\nEven Union: "+EvenUnion(EUnionlist.get(0),list.get(list.size()-1)));
			}
	}

	public HashSet<Integer> Intersection(HashSet<Integer> a,HashSet<Integer> b) {
		HashSet<Integer> intersection = new HashSet<Integer>(a);
		intersection.retainAll(b);
		return intersection;
	}
	
	public HashSet<Integer> Union(HashSet<Integer> a,HashSet<Integer> b){
		HashSet<Integer> union = new HashSet<Integer>();
		HashSet<Integer> intersect = Intersection(a,b);
		for(Integer num:a){
			union.add(num);
		}
		for(Integer x:b){
			union.add(x);
		}
		HashSet<Integer> finalunion = new HashSet<Integer>();
		for(Integer num:union){
			if(!intersect.contains(num))
				finalunion.add(num);
		}
		return finalunion;
	}
	
	public HashSet<Integer> EvenIntersection(HashSet<Integer> a,HashSet<Integer> b){
		HashSet<Integer> Intersect = Intersection(a,b);
		HashSet<Integer> evenIntersect = new HashSet<Integer>();
		for(Integer i:Intersect){
			if(i%2==0)
				evenIntersect.add(i);
		}
		return evenIntersect;
	}

	public HashSet<Integer> EvenUnion(HashSet<Integer> a, HashSet<Integer> b){
		HashSet<Integer> Union = Union(a,b);
		HashSet<Integer> EvenUnion = new HashSet<Integer>();

		for(Integer num:Union){
			if(num%2==0)
				EvenUnion.add(num);
		}
		return EvenUnion;
	}

	public static void main(String [] args){
		Hash_Tree_Set app = new Hash_Tree_Set();
	}

}