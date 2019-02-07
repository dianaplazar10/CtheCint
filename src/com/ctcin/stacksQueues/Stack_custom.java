package com.ctcin.stacksQueues;

/*
 * A Stack can be implemented using LinkedLists or something similar as in the example below
 * 
 * The important methods in Stack are 
 * 
 * push() -  insert a item from top, as Stack is FILO datastructure
 * pop() - remove element. Its always the element on top. At the end, lso remener to reset the new Top Node.
 * peek() - return the top element
 * isEmpty() - return boolean status of stack
 * 
 */
public class Stack_custom {

	public static void main(String[] args) {
		MyStack<Integer> mystack = new MyStack();
		
		try{
			int poppedVal = mystack.pop();
			System.out.println("popped Value : " + poppedVal);
		} catch(Exception ex){
			System.out.println("Stack is empty");
		}
		
		mystack.push(3);
		mystack.push(4);
		try{
			int poppedVal = mystack.pop();
			System.out.println("popped Value : " + poppedVal);
		} catch(Exception ex){
			System.out.println("Stack is empty");
		}
		
		System.out.println("Is Stack Empty? "+mystack.isEmpty());
		System.out.println("pop an item and the value popped: " + mystack.pop());
		
	}

}

/*
 * Output:
 * -------
Stack is empty
popped Value : 4
Is Stack Empty? false
pop an item and the value popped: 3
 */

class MyStack<T>{
	
	private static class MyStackNode<T>{
		private T data;
		private MyStackNode<T> next;
		public MyStackNode(T data) {
			this.data = data;
		}
				
	}
	
	MyStackNode<T> topNode;
	
	//push()
	public void push(T item){
		MyStackNode<T> current = new MyStackNode<T>(item);
		current.next=topNode;
		topNode=current;
	}
	
	//pop()
	public T pop(){
		if(topNode==null) 
			return null;// or throw emptyStackException
		T stkItemVal = topNode.data;
		topNode = topNode.next;
		return stkItemVal;
	}
	
	//peek()
	public T peek(){
		if(topNode==null) 
			return null;// or throw emptyStackException
		return topNode.data;
	}
	
	//isEmpty()
	public boolean isEmpty(){
		return topNode==null;
	}
	
}

