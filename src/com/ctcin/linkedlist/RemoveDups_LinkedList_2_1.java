package com.ctcin.linkedlist;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

/*
 * Program to remove duplicate nodes from an unsorted linked list
 * it could be done in 2 ways,
 * 1)using HashSet
 * 2)for in-place, iterate n check each node with the remaining nodes
 * 
 */
public class RemoveDups_LinkedList_2_1 {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		int initialheadsize=head.nodeSize();
		SinglyLinkedListUtil.printLinkedList(head);
		System.out.println();
//		System.out.println("LinkedList after cleaning dups");
//		System.out.println("--------------------------------");
//		head=clearDupNodes_InPlace(head);
//		printLinkedList(head);
		
		System.out.println();
		System.out.println("LinkedList after deleting a node");
		System.out.println("--------------------------------");
		Node_singlyLinkedList headAfterDeletion = deleteNode(head,22);
		if(headAfterDeletion.nodeSize()==initialheadsize) 
			System.out.println("No nodes were deleted / the deletion Node not in Linked List");
		else 
			SinglyLinkedListUtil.printLinkedList(head);
	}

	private static Node_singlyLinkedList clearDupNodes_InPlace(Node_singlyLinkedList head) {
		Node_singlyLinkedList current =head;
		while(current!=null){
			Node_singlyLinkedList runner = current;
			while(runner!=null){
				if(runner.next!=null && current.nodeVal==runner.next.nodeVal) {
					runner.next=runner.next.next;				
				} else{
					runner=runner.next;
				}
			}
			current=current.next;
		}
		return head;
	}
	
	public static Node_singlyLinkedList deleteNode(Node_singlyLinkedList head,int deleteNodeVal){
		Node_singlyLinkedList current = head;
		while(current!=null){
			if(head.nodeVal == deleteNodeVal) {
				current = current.next; 
				return current;
			}else if(current.next!=null && current.next.nodeVal==deleteNodeVal){
				current.next=current.next.next;
				return head;
			} 
			current=current.next;				
		}
		return head;
	}
}
