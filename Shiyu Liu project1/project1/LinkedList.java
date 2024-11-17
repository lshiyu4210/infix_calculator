package project1;
//author: Shiyu Liu

public class LinkedList<T> {
	
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int getSize() {
		return N;
	}
	
	public void addFirst(T t) {
		Node oldHead = first;
		first = new Node();
		first.data = t;
		first.next = oldHead;
		N++;
	}
	
	public void addLast(T t) {
		Node oldTail = last;
	    last = new Node();
		last.data = t;
		last.next = null;
		if(isEmpty()) first = last;
		else    	oldTail.next = last;
		N++;
	}
	
	public T removeFirst() {
		T item = (T)first.data;
		first = first.next;
		if(isEmpty())  last = null;
		N--;
		return item;
	}
	
	public T peek() {
		return (T)first.data;
	}
	
	
	public void printAll() {
		Node curNode = new Node();
		curNode = first;
		for(int i = 0; i < N; i++) {
			System.out.print(curNode.data + " ");
			curNode = curNode.next;
		}
		System.out.println("");
			
	}

}
