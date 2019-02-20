package com.ctcin.trees_n_graphs;

import java.util.stream.IntStream;

/*
 * MinimalBinaryTree -> a binary search tree with minimal height
 * 
 * Steps:
 * 1) Get the array sorted
 * 2)get teh mid and make it the root,
 * 3)traverse through left and right
 */

public class Array2MinimalBinaryTree_4_2{

	public static void main(String[] args) {
		int[] arr = {3,4,2,1,5,6,7};
		arr = getArrSorted(arr);
		TreeNode binaryTreeNode = getTreeOfArr(arr);
		printLevelOrder(binaryTreeNode);
	}

	private static void printLevelOrder(TreeNode binaryTreeNode) {
		if(binaryTreeNode==null) return;
		int height = getHeight(binaryTreeNode);
		for(int i=1;i<=height;i++){
			printLevelOrder(binaryTreeNode,i);
		}
	}

	private static void printLevelOrder(TreeNode binaryTreeNode, int level) {
		if(binaryTreeNode==null) return;
		if(level==1) 
			System.out.print(binaryTreeNode.nodeVal +" ");
		else {
			printLevelOrder(binaryTreeNode.leftChild,level-1);
			printLevelOrder(binaryTreeNode.rightchild,level-1);		
		}
		
	}

	static int getHeight(TreeNode binaryTreeNode) {
		if(binaryTreeNode==null) 
			return 0;
		if(binaryTreeNode.leftChild==null && binaryTreeNode.rightchild==null) 
			return 1;
		return 1+Math.max(getHeight(binaryTreeNode.leftChild), getHeight(binaryTreeNode.rightchild));
	}

	static TreeNode getTreeOfArr(int[] arr) {
		return getTreeOfArr(arr,0,arr.length-1);
	}

	private static TreeNode getTreeOfArr(int[] arr, int startIndex, int endIndex) {
		if(endIndex<startIndex) return null;
		int midIndex = (startIndex + endIndex)/2;
		TreeNode node=new TreeNode(arr[midIndex]);
		node.leftChild = getTreeOfArr(arr,startIndex,midIndex-1);
		node.rightchild=getTreeOfArr(arr, midIndex+1 , endIndex);
		return node;
	}

	/**
	 * @param arr
	 */
	static int[] getArrSorted(int[] arr) {
		int[] sorted = IntStream.of(arr)
		        .boxed()
		        .sorted()
		        .mapToInt(i -> i)
		        .toArray();
//		IntStream.of(sorted).forEach(x->System.out.println(x));
		return sorted;
	}

}


class TreeNode{
	int nodeVal;
	TreeNode leftChild;
	TreeNode rightchild;
	
	public TreeNode(int nodeVal) {
		this.nodeVal=nodeVal;
		this.leftChild =null;
		this.rightchild=null;
	}

}