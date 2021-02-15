import java.util.EmptyStackException;
import java.util.List;

public class SuperList<E> {
	
	ListNode<E> root;
	ListNode<E> end;
	int size;
	
	public SuperList() {
		root = null;
		end = null; 
		size = 0;
	}
	
	public void add(E value) {
		//State of the list. 
		
		ListNode<E> newNode = new  ListNode<E> (value);	
		
		if(root == null) {
			root = newNode; 
			end = root;
		}else {
			end.setNext(newNode);
			newNode.setPrevious(end);
			end = newNode;
		}
		size++;
	}
	
	public void add(int position, E value) {
		
		//State of the list. 
		ListNode<E> newNode = new  ListNode<E> (value);
		if(position > size) {
			//ERROR
		}
		else if(position == size) {
			add(value);
			// add the new node at the end
			// change the next pointer of the existing end to point to new end
		}
		else if (position == 0) {
			root.setPrevious(newNode);
            newNode.setNext(root);
            root = newNode;
            size++;
			
		}
		else {
			ListNode<E> temp = root;
			
            for(int i=0; i<position; i++){
                temp = temp.getNext();
            }
            
            ListNode<E> prev = temp.getPrevious();
            prev.setNext(newNode);
            newNode.setPrevious(prev);
            temp.setPrevious(newNode);
            newNode.setNext(temp);
            size++;
			
		}
	}
	
	public E get(int index){  
		int value; 
		ListNode<E> temp = root;
		for(int i=0; i<index; i++){             
			temp = temp.getNext();         
		}         
		if(index>size-1 || index<0)             
			throw new ArrayIndexOutOfBoundsException(); 
		else 
		    return temp.getValue();
	}
	
	public E peekStack(){        
		if (end == null)
            return null;
        return end.getValue();   
	}     
	public E peekQueue(){         
		if (root == null)
            return null;
        return root.getValue();
	}
	
	public E remove(int index) 
	{
		E value = null;
        if(index>=size || index<0)
                throw new ArrayIndexOutOfBoundsException("This index ( " + index + " ) is out of bounds for size " + size);

        else if(index==0) 
        	return poll();
        else if(index==size-1) 
        	return pop();
        else{

            ListNode<E> temp = root;

            for(int i=0; i<index; i++){
                temp = temp.getNext();
            }
            value = temp.getValue();

            temp.getNext().setPrevious(temp.getPrevious());
            temp.getPrevious().setNext(temp.getNext());
            size--;


        }
        return value;
	}
	
	public E poll() {
		if (root == null)
            return null;
       
		E value = root.getValue();
		
        if (size == 1)
            clear();
        
        else {
            root = root.getNext();
            root.setPrevious(null);
        }
        
        size--;
        
        return value;
	}
	
	public E pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
        E value = end.getValue();
        if (size == 1)
            clear();
        else {
            end = end.getPrevious();
            end.setNext(null);
        }
        size--;
        return value;
	}
	
	public void clear() {
        root = null;
        end = null;
        size = 0;
	}
	
	public Boolean isEmpty() {
		if(size <= 0)
			return true;
		else 
			return false;
	}
	
	public String toString() {
		String st = "[";
		ListNode<E> temp = root;
		for(int x = 0; x < size; x++) {
			st+=temp.getValue();
			if(x < size-1)
				st+=", ";
			temp = temp.getNext();
		}
		st+="]";
		return st;
	}
	
	public int size() {
		return size;
	}
	
		
	public Boolean contains(E value) {
		ListNode<E> temp = root;
		for(int x = 0; x < size ; x++) {
			if(temp.getValue().equals(value)) {
					return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	     
	public void push(E value){         
		add(value);     
	}            
	
	
	
	
	
	
	
	
	
	
	public class ListNode<E>{
		
		E value; 
		ListNode<E> next; 
		ListNode<E> previous; 
		
		public ListNode (E value) {
			this.value = value;
			next = null;
			previous = null; 
		}
		
		public E getValue()
		{
			return value; 
		}
		public ListNode<E> getNext(){
			return next;
		}
		public ListNode<E> getPrevious(){
			return previous;
		}
		public void setNext(ListNode <E> newNode) {
			next = newNode;
		}
		public void setPrevious(ListNode <E> newNode) {
			previous = newNode;
		}
	}
	
}


