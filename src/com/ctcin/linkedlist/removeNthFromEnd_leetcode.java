package com.ctcin.linkedlist;

import java.util.Stack;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * sample LinkedList used: 1 -> 11 -> 22 -> 22 -> 33
 */
public class removeNthFromEnd_leetcode {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		
		int n=4;
		Node_singlyLinkedList updatedNode = removeNthFromEnd(head,n);
		System.out.println("Updated Nodes after removing the "+n+"th Node from last");
		System.out.println("-------------------");
		if(updatedNode==null) 
			System.out.println("LinkedList does not have that many elements to remove (or) has only 1 elemnt that is removed for nth");
		else 
			SinglyLinkedListUtil.printLinkedList(updatedNode);

	}

	private static Node_singlyLinkedList removeNthFromEnd(Node_singlyLinkedList head, int n) {
		//add Nodes to stack
		Stack<Node_singlyLinkedList> stk = getStackOfLinkedList(head);
		//Decrement counter an dpop till n , create a LInkedlist With remaining and return
		if(stk.size()==0 || stk.size()<n) return null; 
		if(stk.size()==n){
			Node_singlyLinkedList temp = head.next;
			head=temp;
			return head;
		}
		Node_singlyLinkedList updatedNode=null;
		while(n>0){
			if(stk.peek()!=null) updatedNode=stk.pop();
            else head=updatedNode;
			if(n==1){
				Node_singlyLinkedList temp = updatedNode.next;
				updatedNode=stk.pop();
				updatedNode.next=temp;
			}
			System.out.println("-------------  " + n);
			n--;
		}
		return head;
	}
	
//	counter | nodeindex
//	3			last
//	2			last-1
//	1			last-2
	

	private static Stack<Node_singlyLinkedList> getStackOfLinkedList(Node_singlyLinkedList head) {
		Node_singlyLinkedList current = head;
		Stack<Node_singlyLinkedList> stk = new Stack<Node_singlyLinkedList>();
		while(current!=null){
			stk.push(current);
			current=current.next;
		}
		return stk;
	}

}
