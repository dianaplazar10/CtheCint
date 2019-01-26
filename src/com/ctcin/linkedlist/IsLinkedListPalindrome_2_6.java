package com.ctcin.linkedlist;

import java.util.Stack;

import com.ctcin.utils.Node_DoublyLinkedList;
import com.ctcin.utils.Node_singlyLinkedList;
//import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

/*
 * check if given linked list is a palindrome?
 */

public class IsLinkedListPalindrome_2_6 {

	public static void main(String[] args) {
		String nodeVals = "3,6,2,5";
		String nodeValsPal = "3,6,2,6,3";
		Node_singlyLinkedList nonPalinNode = SinglyLinkedListUtil.createSinglyLinkedList(nodeVals);
		Node_singlyLinkedList palinNode = SinglyLinkedListUtil.createSinglyLinkedList(nodeValsPal);
		boolean isPalin = IsPalindrome(nonPalinNode);
		if(isPalin) {
			SinglyLinkedListUtil.printLinkedList(nonPalinNode);
			System.out.print(  " : is a palindrome Linked list");
		} else {
			SinglyLinkedListUtil.printLinkedList(nonPalinNode);
			System.out.print(  " :  is NOT a palindrome Linked list");
		}
		
		System.out.println();System.out.println();
		
		isPalin = IsPalindrome(palinNode);
		if(isPalin) {
			SinglyLinkedListUtil.printLinkedList(palinNode);
			System.out.print(  " : is a palindrome Linked list");
		} else {
			SinglyLinkedListUtil.printLinkedList(palinNode);
			System.out.print(  " :  is NOT a palindrome Linked list");
		}
	}

	/*
	 * we are using 3 pointers to figure out if the given linked list is a palindrome
	 * 1)slow :  iterates one pointer
	 * 2)fast :iterates over 2 pointers
	 * 3)current : iterates across each node
	 * 
	 * The idea of this method is to populate a Stack with first half of the linked list, while comparing it using pop() with the remaining linked list
	 * 
	 * if the size of the linked list is even, then the last iteration for fast will have fast.next=null, while
	 * if size = odd, last iteration for fast with have fast.next!=null, while fast.next.next will be null
	 * 
	 */
	private static boolean IsPalindrome(Node_singlyLinkedList node) {
		Node_singlyLinkedList slow = node;
		Node_singlyLinkedList fast=node;
		Stack<Integer> stackVals = new Stack<Integer>();
		
		while(fast!=null && fast.next!=null){
			stackVals.push(slow.nodeVal);
			slow=slow.next;
			fast=fast.next.next;
		}
		
		//to validate ignoring of the mid Node if the size is odd
		if(fast!=null){
			slow = slow.next;
		}
		
		while(slow!=null){
			int stkPopVal = stackVals.pop().intValue();
			if(slow.nodeVal!=stkPopVal){
				return false;
			}
			slow=slow.next;
		}
		return true;		
	}

}
