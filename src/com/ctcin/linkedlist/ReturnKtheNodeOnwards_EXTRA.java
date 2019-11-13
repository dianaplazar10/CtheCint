package com.ctcin.linkedlist;

import java.util.Stack;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;
/*
 * This program is implemented to return linkedList after the given kth Nodes
 * 
 * The solution uses Stack to cache the reverse order of the list and then save upto teh kth Node to return the list of K nodes.
 */
public class ReturnKtheNodeOnwards_EXTRA {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		
		Node_singlyLinkedList reverseNode = getFromKthNodes(head,2);
		System.out.println("Remaining Nodes");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(reverseNode);

	}

	private static Stack<Node_singlyLinkedList> addToStack(Node_singlyLinkedList head){
		Stack<Node_singlyLinkedList> stk = new Stack<Node_singlyLinkedList>();
		Node_singlyLinkedList current = head;
		while(current!=null){
			stk.push(current);
			current=current.next;
		}
		return stk;
	}
	
	private static Node_singlyLinkedList getFromKthNodes(Node_singlyLinkedList head, int k) {
		// add to stack
		Stack<Node_singlyLinkedList> stk = addToStack(head);
		Node_singlyLinkedList returnNode = null;
		int counter = k;
		// pop stack and counter till k
		while(!stk.isEmpty() && counter>0){
			if(returnNode==null){
				returnNode=stk.pop();
			}else{
				Node_singlyLinkedList temp = returnNode;
				returnNode=stk.pop();
				returnNode.next=temp;
			}
			counter--;
		}
			
		return returnNode;
	}

}


//OUTPUT:
//Initial Linked List
//-------------------
//1 -> 11 -> 22 -> 22 -> 33 -> 
//
//Remaining Nodes
//-------------------
//22 -> 33 -> 
