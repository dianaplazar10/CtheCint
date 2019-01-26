package com.ctcin.linkedlist;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

public class DeleteMiddleNodeinLL_2_3 {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		
		int midIndex=(head.nodeSize())/2;
		System.out.println("Linked List after removal of index : "+midIndex);
		System.out.println("-------------------");
		head = removeMidNode(head, midIndex);
		SinglyLinkedListUtil.printLinkedList(head);
	}

	private static Node_singlyLinkedList removeMidNode(Node_singlyLinkedList head,int midIndex) {
		int counter=0;
		Node_singlyLinkedList current = head;
		while(current!=null){
			counter++;
			if(counter==midIndex){
				head = SinglyLinkedListUtil.removeNode(head, midIndex);
				current=null;
			} else {
				current=(Node_singlyLinkedList) current.next;
			}
		}
		return head;
	}

}
