package com.ctcin.linkedlist;

/*
 * Given a node value in a linked list,
 * Partition the linked list into 2 by keeping all nodes smaller to given node in one, 
 * and the others in another linked list
 */

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

public class PartitionLinkedList_2_4 {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		
		partitionLLbyNode(head, 22);
		System.out.println();
		System.out.println("Linked List partitions into start and tail");
		System.out.println("-----Start-------");
		SinglyLinkedListUtil.printLinkedList(start);
		System.out.println("-----tail-------");
		SinglyLinkedListUtil.printLinkedList(tail);
	}

	static Node_singlyLinkedList start = null;
	static Node_singlyLinkedList tail = null;
	private static void partitionLLbyNode(Node_singlyLinkedList head, int x) {
		Node_singlyLinkedList current = head;
		while(current!=null){
			Node_singlyLinkedList startCurrent = start;
			Node_singlyLinkedList tailCurrent = tail;
//			System.out.println( " current " + current.nodeVal + "--------------------------");
			if(current.nodeVal<x){
				if(startCurrent!=null){
					while(startCurrent.next!=null){
						startCurrent=startCurrent.next;
					}
					startCurrent.next=new Node_singlyLinkedList(current.nodeVal);
				} else {
					start = new Node_singlyLinkedList(current.nodeVal);
				}
			} else {
				if(tailCurrent!=null){
					while(tailCurrent.next!=null){
						tailCurrent=tailCurrent.next;
					}
					tailCurrent.next=new Node_singlyLinkedList(current.nodeVal);
				} else {
					tail = new Node_singlyLinkedList(current.nodeVal);
				}
			}
			current=current.next;
		}
	}
}
