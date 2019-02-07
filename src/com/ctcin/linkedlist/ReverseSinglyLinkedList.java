package com.ctcin.linkedlist;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

public class ReverseSinglyLinkedList {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		
		Node_singlyLinkedList reverseNode = getReverseOf(head);
		System.out.println("Reversed Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(reverseNode);
		
	}

	/*
	 * The function takes in the Head node.
	 * The head node is traversed,
	 * On each traversal, a new node is created with value of current head node
	 * Then the next of this temp node in assigned to reverse Node.
	 * While finally reverse node is re-assigned to temp node, which now has the head as current node and the next as previous reverse node..
	 * 
	 * here's how it works:
	 * 
	 * 
	 * 
	 */
	private static Node_singlyLinkedList getReverseOf(Node_singlyLinkedList head) {
		Node_singlyLinkedList reverse = null;
		while(head!=null){
			Node_singlyLinkedList tempNode = new Node_singlyLinkedList(head.nodeVal);
			tempNode.next=reverse;
			reverse=tempNode;
			head = head.next;	
		}
		return reverse;
	}
}


/*
 * 
Initial Linked List
-------------------
1 -> 11 -> 22 -> 22 -> 33 -> 

Reversed Linked List
-------------------
33 -> 22 -> 22 -> 11 -> 1 -> 
 */
