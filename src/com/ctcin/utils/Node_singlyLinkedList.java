package com.ctcin.utils;

public class Node_singlyLinkedList {
	public Node_singlyLinkedList next=null;
	public int nodeVal;

	public Node_singlyLinkedList() {
	}
	
	public Node_singlyLinkedList(int value){
		this.nodeVal=value;
	}
	
	public void addNode(Node_singlyLinkedList head,int newNodeVal){
		while(head.next!=null){
			head = head.next;
		}
		head.next=new Node_singlyLinkedList(newNodeVal);
	}
	
	public int nodeSize(){//returns number of node that follows the current node
		int size=0;
		Node_singlyLinkedList node = this;
		while(node!=null){
			size++;
			node=node.next;
		}
		return size;
	}

}
