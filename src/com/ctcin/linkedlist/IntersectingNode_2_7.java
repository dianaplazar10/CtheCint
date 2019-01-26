package com.ctcin.linkedlist;

/*
 * This problem is to find the intersecting Node between 2 linked list.
 * 
 * Lets say that below are two intersecting LinkedLists with Intersecting Node = 5
 * 
 * LinkedList 1 = 4- > 5 
 * 						 -> 2 -> 6 -> 3
 * LinkedList 2 = 3 -> 6 
 * 
 * Important node, intersecting nodes are the references and not just the node values,
 * 
 * ie,
 * 
 * The below are not intersecting nodes, though the values for both are the same after node with value 2 
 * Example of non-intersecting Nodes
 * LinkedList 1 = 4- > 5 -> 2 -> 6 -> 3
 * 						
 * LinkedList 2 = 3 -> 6 -> 2 -> 6 -> 3
 */
import com.ctcin.utils.Node_singlyLinkedList;
import com.ctcin.utils.SinglyLinkedListUtil;

public class IntersectingNode_2_7 {

	public static void main(String[] args) {
		String node1Vals = "8,4,5";
		String node2Vals = "3,6";
		String intersectingNodes="2,6,3";
		Node_singlyLinkedList ll_one = SinglyLinkedListUtil.createSinglyLinkedList(node1Vals);
		Node_singlyLinkedList ll_two = SinglyLinkedListUtil.createSinglyLinkedList(node2Vals);
		Node_singlyLinkedList intersectingNodeSet = SinglyLinkedListUtil.createSinglyLinkedList(intersectingNodes);
		
		Node_singlyLinkedList current = ll_one;
		Node_singlyLinkedList current_prev = null;
		while(current!=null){
			current_prev=current;
			current=current.next;
		}
		current_prev.next= intersectingNodeSet;
		
		Node_singlyLinkedList current2 = ll_two;
		Node_singlyLinkedList current2_prev = null;
		while(current2!=null){
			current2_prev=current2;
			current2=current2.next;
		}
		current2_prev.next= intersectingNodeSet;
		
		System.out.println("----------LinkedList 1-------------");
		SinglyLinkedListUtil.printLinkedList(ll_one);
		System.out.println("----------LinkedList 2-------------");
		SinglyLinkedListUtil.printLinkedList(ll_two);
		
		boolean nodesIntersect = doNodesIntersect(ll_one,ll_two);//This can be identified by checking f teh last Node of both the LinkedLIsts are the same.
		if(nodesIntersect){
			System.out.println("----------The intersecting Node----------" );
			Node_singlyLinkedList intersectingNode = getIntersectingNode(ll_one,ll_two);
			SinglyLinkedListUtil.printLinkedList(intersectingNode);
		} else {
			System.out.println("The Nodes are not intersecting, Hence cannot find the intersecting Node");
		}
		

	}

	private static boolean doNodesIntersect(Node_singlyLinkedList ll_one, Node_singlyLinkedList ll_two) {
		Node_singlyLinkedList ll_oneCurrent = ll_one;
		Node_singlyLinkedList ll_twoCurrent = ll_two;
		Node_singlyLinkedList tail1 = null;
		Node_singlyLinkedList tail2=null;
		while(ll_oneCurrent!=null){
			tail1=ll_oneCurrent;
			ll_oneCurrent=ll_oneCurrent.next;
		}
		while(ll_twoCurrent!=null){
			tail2=ll_twoCurrent;
			ll_twoCurrent=ll_twoCurrent.next;
		}
		if(tail1==tail2)
			return true;
		return false;
	}

	private static Node_singlyLinkedList getIntersectingNode(Node_singlyLinkedList ll_one,Node_singlyLinkedList ll_two) {
		Node_singlyLinkedList interNode = null;
		//get sizes of both the linkedlist
		boolean nodeSizesEqual = false;
		Node_singlyLinkedList shortLL=null;
		Node_singlyLinkedList largeLL=null;
		if(ll_one.nodeSize()==ll_two.nodeSize())
			nodeSizesEqual=true;
		if(nodeSizesEqual){
			interNode = getInterNode(ll_one,ll_two);
		}else{
			shortLL= ((ll_one.nodeSize()+1) >(ll_two.nodeSize()+1)) ? ll_two : ll_one;
			largeLL= ((ll_one.nodeSize()+1) >(ll_two.nodeSize()+1)) ? ll_one : ll_two;
			int deleteSize = largeLL.nodeSize()-shortLL.nodeSize();
			int counter=0;
			Node_singlyLinkedList current = largeLL;
			while(current!=null){
				counter++;
				if((deleteSize+1)==counter){
					largeLL=current;
					break;
				} else {
					current=current.next;
				}
			}					
			interNode = getInterNode(shortLL, largeLL);
		}
		
		return interNode;
	}

	private static Node_singlyLinkedList getInterNode(Node_singlyLinkedList ll_one, Node_singlyLinkedList ll_two) {
		while(ll_one!=ll_two){
			ll_one=ll_one.next;
			ll_two=ll_two.next;
		}
		return ll_one;// cd also be = to ll_two
	}

}


/*
 * Output:
 * 
----------LinkedList 1-------------
8 -> 4 -> 5 -> 2 -> 6 -> 3 -> 

----------LinkedList 2-------------
3 -> 6 -> 2 -> 6 -> 3 -> 

----------The intersecting Node----------
2 -> 6 -> 3 -> 
*/
