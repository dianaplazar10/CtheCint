package com.ctcin.trees_n_graphs;

/*
 * BinarySearchTree: 
 * A Binary Tree is said to be a binary search tree 
 * if, 
 * 1)All nodes are unique
 * 2) the root node is greater than left node, 
 * 3)and lesser than right node, and hold for all nodes in tree 
 * ie , (Left.node < current.node < Right.node)
 *      ----------------------------------------
 *      
 *  METHOD 1
 * ---------
 * Steps: (Using an int[] )
 * 1)Convert the given tree to an arr, using the In-order traversal technique and copy to array istead of printing the node value
 * 2)Once copied, iterate over the array and validate the Binary search tree condition
 * 
 * 	METHOD 2
 * ---------
 * Steps: avoid using the int[]
 * 1)Recurse
 */

public class ValidateBinarySearchTree_4_5 {

	static Array2MinimalBinaryTree_4_2 a2binTree =  new Array2MinimalBinaryTree_4_2();
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,1,5,6,7};
		arr = a2binTree.getArrSorted(arr);
		TreeNode binaryTreeNode = a2binTree.getTreeOfArr(arr);
		
		
		//METHOD 1
		//--------
		//Copy all nodes of the tree in IN-order format, ie Left..root..right
		//and then parse through the array to check the condition, arr[i]>arr[i-1].. all the same as in the if condition on line 46
		boolean isBST= checkIsBST(binaryTreeNode);
		System.out.println("Is the tree is BST ? " + isBST);
		
//		System.out.println(getNodeCount(binaryTreeNode));
		
		//METHOD 2
		//--------
		//In thsi method, we check to see if teh given node lies between min and max,
		// for root, min and max=null and hence, root lies within null and null
		//while we branch out, for the left tree, root becomes the max, and min becomes null
		// and similarly, while we branch out for the right tree, root becomes the min and max becomes null
		//When we branch out left, min gets updated, and when we branch out right, max gets updated.
		
		//TIME O(N)
		//SPACE O(LogN), since recursive
		 isBST= checkIsBST_recursive(binaryTreeNode);
		System.out.println("Is the tree is BST ? " + isBST);
	}

	/**
	 * @param binaryTreeNode
	 * @return 
	 */
	private static boolean checkIsBST(TreeNode binaryTreeNode) {
		int[] copiedArr = new int[getNodeCount(binaryTreeNode)];
		copyTree2Arr_InOrder(binaryTreeNode,copiedArr);
		for (int i = 1; i < copiedArr.length; i++) {//start the iteration with 1, as if condition checks for i-1
			if(copiedArr[i]<=copiedArr[i-1])
				return false;
		}
		return true;
	}

	private static int getNodeCount(TreeNode binaryTreeNode) {
			if(binaryTreeNode == null) return 0;
			if(binaryTreeNode.leftChild==null && binaryTreeNode.rightchild==null) return 1;
			return getNodeCount(binaryTreeNode.leftChild) + getNodeCount(binaryTreeNode.leftChild) +1;
	}

	static int index=0;
	private static void copyTree2Arr_InOrder(TreeNode binaryTreeNode,int[] arr) {
		if(binaryTreeNode==null) return;
		copyTree2Arr_InOrder(binaryTreeNode.leftChild, arr);
		arr[index] = binaryTreeNode.nodeVal;
		System.out.println(arr[index] + " ");
		index++;
		copyTree2Arr_InOrder(binaryTreeNode.rightchild, arr);
	}
	

	private static boolean checkIsBST_recursive(TreeNode binaryTreeNode) {
		return checkIsBST_recursive(binaryTreeNode,null,null);
	}

	private static boolean checkIsBST_recursive(TreeNode node, Integer minNodeVal, Integer maxNodeVal) {
		if(node==null) 
			return true;
		if((minNodeVal!=null && node.nodeVal<=minNodeVal) || (maxNodeVal!=null && node.nodeVal>maxNodeVal))
			return false;
		if(!checkIsBST_recursive(node.leftChild,minNodeVal,node.nodeVal) ||
				!checkIsBST_recursive(node.rightchild,maxNodeVal,node.nodeVal) )
			return false;
		return true;
	}

}
