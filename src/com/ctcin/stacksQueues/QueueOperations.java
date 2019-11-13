package com.ctcin.stacksQueues;


/*Note that in -----------(1), Queue is implement using a LinkedList.
 * This restricts the queue from having access to any of the specific LinkedList methods, such as 
 * 1) .getFirst
 * 2) .peekFirst()
 * 3) .removeFirst()
 * 4) .indexOf(0)
 * 5) .set(7)
 * 
 * 
 */
import java.util.LinkedList;
import java.util.Queue;

public class QueueOperations {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();  //-----------(1)
		
		queue.poll(); //without element , NO EXCEP, returns "null"
		//queue.remove();//without element , THROWS NOSUCHELEMENT exception
		
		queue.peek();//without element , NO EXCEP, returns "null"
		//queue.element();//without element , THROWS NOSUCHELEMENT exception
		
		//add and offer both add items to a queue and return a boolean, however, 
		//they r different in the sense of handling the capacity of the queue, 
		//while offer is preferred over add with a queue's defined capacity
		queue.add(2);
		queue.offer(3);
		
		queue.peek();//with element
		queue.element();//with element
		
	}

}
