package com.ctcin.utils;

public class SinglyLinkedListUtil {

	/**
	 * Creates a Singly Linked List as below:
	 * 1 -> 11 -> 22 -> 22 -> 33
	 */
	public static Node_singlyLinkedList createSinglyLinkedList() {
		Node_singlyLinkedList head = new Node_singlyLinkedList(1);
		Node_singlyLinkedList cnode11 = new Node_singlyLinkedList(11);
		head.next=cnode11;
		Node_singlyLinkedList cnode22 = new Node_singlyLinkedList(22);
		cnode11.next = cnode22;
		Node_singlyLinkedList cnode22_2 = new Node_singlyLinkedList(22);
		cnode22.next = cnode22_2;
		Node_singlyLinkedList cnode33 = new Node_singlyLinkedList(33);
		cnode22_2.next=cnode33;
		return head;
	}
	
	/**
	 * Creates a Singly Linked List based on values passed, separated by comma ','
	 */
	public static Node_singlyLinkedList createSinglyLinkedList(String vals) {
		String[] nodevals = vals.split(",");
		if(nodevals.length<1) 
			return null;
		Node_singlyLinkedList head = new Node_singlyLinkedList(Integer.valueOf(nodevals[0]));
		for (int i = 1; i < nodevals.length; i++) {
			addNext(head,Integer.valueOf(nodevals[i].trim()));
		}
		return head;
	}
	
	/**
	 * Creates a Singly Linked List based on values passed, separated by comma ','
	 */
	public static Node_DoublyLinkedList createDoublyLinkedList(String vals) {
		String[] nodevals = vals.split(",");
		if(nodevals.length<1) 
			return null;
		Node_DoublyLinkedList head = new Node_DoublyLinkedList(Integer.valueOf(nodevals[0]));
		for (int i = 1; i < nodevals.length; i++) {
			addNext(head,Integer.valueOf(nodevals[i].trim()));
		}
		return head;
	}
	
	public static void addNext(Node_singlyLinkedList head, int nodeVal){
		Node_singlyLinkedList current = head;
		Node_singlyLinkedList prevNode = new Node_singlyLinkedList();
		while(current!=null){
			prevNode = current;
			current=current.next;
		}
		current = prevNode;
		current.next=  new Node_singlyLinkedList(nodeVal);
		//return head;		
	}
	
	public static void addNext(Node_DoublyLinkedList head, int nodeVal){
		Node_DoublyLinkedList current = head;
		Node_DoublyLinkedList prevNode = new Node_DoublyLinkedList();
		while(current!=null){
			prevNode = current;
			current=current.next;
		}
		current = prevNode;
		current.next=  new Node_DoublyLinkedList(nodeVal);
		//return head;		
	}
	
	public static void printLinkedList(Node_singlyLinkedList head) {
		if(head==null) 
			System.out.println("Linked list Node"); 
		while(head!=null){
			System.out.print(head.nodeVal + " -> ");
			head=head.next;
		}
		System.out.println();
		System.out.println();
	}
	
	/*
	 * Remove all node from(including) second node, while first node is teh head node passed
	 */
	public static Node_singlyLinkedList removeNode2Onwards(Node_singlyLinkedList head, Node_singlyLinkedList node2Remove){
		Node_singlyLinkedList current = head;
		if(head==node2Remove) return null;
		while(current!=null){
			if(current.next==node2Remove){
				current.next = null;
				return head;
			} else {
				current=current.next;
			}
		}
		return head;		
	}
	
	/*
	 * Remove the node given the index 
	 * The linked list is assumed to be starting from 0
	 * Also accepts teh head node as a param
	 */
	public static Node_singlyLinkedList removeNode(Node_singlyLinkedList head, int index2delete){
		Node_singlyLinkedList current = head;
		if(head==null || index2delete<0) return null;
		if(index2delete==1){
			head.next=head.next.next;
			return head;
		}
		int counter = 1;
		while(current!=null){
			if(counter==index2delete){
				current.next=current.next.next;
				current=null;
			} else {
				counter++;
				current = current.next;
			}
		}
		return head;		
	}
}
