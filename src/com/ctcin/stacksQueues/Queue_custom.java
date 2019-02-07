package com.ctcin.stacksQueues;

/*
 * A Queue can be implemented using LinkedLists or something similar as in the example below
 * 
 * The important methods in Queue are 
 * 
 * add() -  insert a item from top, as Queue is FIFO datastructure
 * remove() - remove element. Its always the element on top. At the end, lso remener to reset the new Top Node.
 * peek() - return the top element
 * isEmpty() - return boolean status of queue
 * 
 */

public class Queue_custom {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<Integer> ();
		
		try{
			int poppedVal = myQueue.remove();
			System.out.println("popped Value : " + poppedVal);
		} catch(Exception ex){
			System.out.println("Queue is empty");
		}
		
		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(46);
		
		try{
			int poppedVal = myQueue.remove();
			System.out.println("Removed Value : " + poppedVal);
		} catch(Exception ex){
			System.out.println("Queue is empty");
		}
		
		System.out.println("Is Queue Empty? "+myQueue.isEmpty());
		System.out.println("Peek for the last element in the Queue: " + myQueue.peek());
		

	}

}

class MyQueue<T> {
	private static class MyQueueNode<T>{
		private T data;
		private MyQueueNode<T> next;
		public MyQueueNode(T data) {
			this.data = data;
		}			
	}
	
	MyQueueNode<T> startNode;
	MyQueueNode<T> endNode;
	
	public void add(T item) {
		MyQueueNode<T> temp = new MyQueueNode<T>(item);
		if(endNode!=null){
			endNode.next = temp;
		}
		endNode=temp;
		if(startNode==null){			
			startNode=endNode;
		}
	}
	
	public T remove() {
		T startData = startNode.data;
		startNode=startNode.next;
		return startData;
	}
	
	public T peek() {
		return (startNode.data!=null?startNode.data:null);
	}
	
	public boolean isEmpty() {
		return startNode==null;
	}
}