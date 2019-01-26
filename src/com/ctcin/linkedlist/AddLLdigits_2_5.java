package com.ctcin.linkedlist;

import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

/*
 * Add 2 linked lists, while each node is single digit node of both the linked lists.
 * However their sum as shows below needs to be the resulting Linked List.
 * Example:
 * Input : (7 -> 1 -> 6 ) + (5 -> 9 -> 2)
 * Output : (9 -> 1 -> 2). Which is the reverse of the sum of the above: 716 + 592 = 912 
 */

public class AddLLdigits_2_5 {


	public static void main(String[] args) {
		String node1Values = "7,1,6";
		String node2Values = "5,9,2";
		Node_singlyLinkedList linkedlist1 = SinglyLinkedListUtil.createSinglyLinkedList(node1Values);
		Node_singlyLinkedList linkedlist2 = SinglyLinkedListUtil.createSinglyLinkedList(node2Values);
		System.out.println("--LinkedList one ------");
		SinglyLinkedListUtil.printLinkedList(linkedlist1);System.out.println();
		System.out.println("--LinkedList two ------");
		SinglyLinkedListUtil.printLinkedList(linkedlist2);
		
		Node_singlyLinkedList result = addLinkedLists(linkedlist1,linkedlist2,0);
		System.out.println("--Result ------");
		SinglyLinkedListUtil.printLinkedList(result);
	}

	

	private static Node_singlyLinkedList addLinkedLists(Node_singlyLinkedList linkedlist1, Node_singlyLinkedList linkedlist2, int carry) {
		if(linkedlist1==null && linkedlist2==null && carry==0){
			return null;
		}
		Node_singlyLinkedList result = new Node_singlyLinkedList();
		int value=carry;
		if(linkedlist1!=null){
			value = value+linkedlist1.nodeVal;
		}
		if(linkedlist2!=null){
			value = value+linkedlist2.nodeVal;
		}
		result.nodeVal = value%10;
		if(linkedlist1!=null || linkedlist2!=null){
			Node_singlyLinkedList more = addLinkedLists((Node_singlyLinkedList) linkedlist1!=null?(Node_singlyLinkedList) linkedlist1.next : null, 
														(Node_singlyLinkedList) linkedlist2!=null?(Node_singlyLinkedList) linkedlist2.next : null, 
															value>=10 ? 1 :0);
			result.next = more;
		}
		return result;		
	}

}
