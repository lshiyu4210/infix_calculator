package project1;
//author: Shiyu Liu

public class myQueue<T> {
	
	private LinkedList myQueue;
	
	public myQueue() {
		myQueue = new LinkedList();
	}
	
	public boolean isEmpty() {
		return myQueue.isEmpty();
	}
	
	public int getSize() {
		return myQueue.getSize();
	}
	
	public void enqueue(T t) {
		myQueue.addLast(t);
	}
	
	public T dequeue() {
		return (T)myQueue.removeFirst();
	}
	
	public T peek() {
		return (T)myQueue.peek();
	}
	

	public void printQueue() {
		myQueue.printAll();
			
	}

}
