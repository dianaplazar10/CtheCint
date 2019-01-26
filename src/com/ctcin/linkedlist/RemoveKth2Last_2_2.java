package com.ctcin.linkedlist;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

public class RemoveKth2Last_2_2 {

	public static void main(String[] args) {
		int k=3;
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		head = removeKthOnwards(head, k);
		System.out.println("Initial Linked after kth nodes removal");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
	}

	/*
	 * This method takes in the head Node of a LinkedList and an index k
	 * The method functions in removing all the Nodes after the kth index of the Given LinkedList
	 * set a counter to know the position of the node in linked list starting from zero
	 */
	private static Node_singlyLinkedList removeKthOnwards(Node_singlyLinkedList head, int k) {
		int counter=0;
		if(k==0) {head=null;}
		Node_singlyLinkedList current = head;
		while(current!=null){
			if(counter==k){				
				head = SinglyLinkedListUtil.removeNode2Onwards(head, current);
			} else {
				counter++;
			}
			current=current.next;
		}
		return head;
	}

}
