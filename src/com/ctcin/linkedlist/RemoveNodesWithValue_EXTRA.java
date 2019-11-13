package com.ctcin.linkedlist;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

public class RemoveNodesWithValue_EXTRA {

	public static void main(String[] args) {
		Node_singlyLinkedList head = SinglyLinkedListUtil.createSinglyLinkedList();//createSinglyLinkedList_SameElements();//
		System.out.println("Initial Linked List");
		System.out.println("-------------------");
		SinglyLinkedListUtil.printLinkedList(head);
		
		int val2Remove =6;
		Node_singlyLinkedList updatedHeadNode = removeElements(head,val2Remove);
		System.out.println("Remaining Nodes");
		System.out.println("-------------------");
		if(updatedHeadNode==null)
			System.out.println("NULL");
		else
			SinglyLinkedListUtil.printLinkedList(updatedHeadNode);

	}
	
	public static Node_singlyLinkedList removeElements(Node_singlyLinkedList head, int val) {
		if(head==null) return null;
		while(head!=null && head.nodeVal==val){
			head=head.next;
		}
        Node_singlyLinkedList current = head;
        Node_singlyLinkedList previous = null;
        while(current!=null){        	
        	if(current.nodeVal==val && current.next!=null){        		
            	previous.next = current.next;
            	current=previous;
            } else if(current.nodeVal==val && current.next==null){
            	if(previous!=null) previous.next=null;
            	current=previous;
            } 
            previous = current;
            current=current.next;
        }
        return head;
    }

}
