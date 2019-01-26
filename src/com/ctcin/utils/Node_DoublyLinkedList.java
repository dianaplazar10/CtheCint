package com.ctcin.utils;

public class Node_DoublyLinkedList {
	public Node_DoublyLinkedList next=null;
	public Node_DoublyLinkedList prev=null;
	public int nodeVal;

	public Node_DoublyLinkedList() {
	}
	
	public Node_DoublyLinkedList(int value){
		this.nodeVal=value;
	}
	
	public Node_DoublyLinkedList addNode(Node_DoublyLinkedList head,int newNodeVal){
		while(head.next!=null){
			head = head.next;
		}
		head.next=new Node_DoublyLinkedList(newNodeVal);
		head.next.prev= head;
		return head;		
	}
	
	public int nodeSize(){//returns number of node that follows the current node
		int size=0;
		Node_DoublyLinkedList node = this;
		while(node!=null){
			size++;
			node=node.next;
		}
		return size;
	}

}
