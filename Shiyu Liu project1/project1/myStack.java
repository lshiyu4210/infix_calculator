package project1;
//author: Shiyu Liu

public class myStack<T> {
	
	private LinkedList myStack;
	
	public myStack() {
		myStack = new LinkedList();
	}
	public boolean isEmpty() {
		return myStack.isEmpty();
	}
	
	public int getSize() {
		return myStack.getSize();
	}
	
	public void push(T t) {
		myStack.addFirst(t);
	}
	
	public T pop() {
		return (T)myStack.removeFirst();
	}
	
	public T peek() {
		return (T)myStack.peek();
	}
	
	public void printStack() {
		myStack.printAll();
	}
	

}
