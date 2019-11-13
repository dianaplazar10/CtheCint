package com.ctcin.trees_n_graphs;

public class CheckBinTreeIsBalanced_4_4 {

	//A binary tree is balanced if,
	//1)the left child has the same height as the right child (OR)
	//2)if the difference between their heights is not more than 1
	static Array2MinimalBinaryTree_4_2 a2binTree =  new Array2MinimalBinaryTree_4_2();
	public static void main(String[] args) {
		//convert an int arr to a Binary Tree
		int[] arr = {3,4,2,1,5,6,7};
		arr = a2binTree.getArrSorted(arr);
		TreeNode binaryTreeNode = a2binTree.getTreeOfArr(arr);
		
		boolean isBalanced = isBinTreeBalanced(binaryTreeNode);
		System.out.println("Tree is Balanced : " + isBalanced);
		
//		isBalanced = isBinTreeBalanced_withoutRecursion(binaryTreeNode);
//		System.out.println("Tree is Balanced : " + isBalanced);
	}

	private static boolean isBinTreeBalanced(TreeNode node) {
		if(node==null)
			return true;
		int heightDiff=a2binTree.getHeight(node.leftChild) - a2binTree.getHeight(node.leftChild);
		if(Math.abs(heightDiff)>1)
			return false;
		else
			return (isBinTreeBalanced(node.leftChild) && isBinTreeBalanced(node.rightchild));
	}
	
	
//	Base case with invalid height
//	final static int MIN_HEIGHT =-1;

//	private static boolean isBinTreeBalanced_withoutRecursion(TreeNode node) {
//		return checkHeight(node)!=Integer.MIN_VALUE;
//	}
//
//	private static int checkHeight(TreeNode node) {
//		if(node==null)
//			return -1;
//		
//		int leftNodeHeight=checkHeight(node.leftChild);
//		if(leftNodeHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;//Pass error up
//		
//		int rightNodeHeight=checkHeight(node.rightchild);
//		if(rightNodeHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;//Pass error up
//		
//		int heightDiff = leftNodeHeight-rightNodeHeight;
//		if(Math.abs(heightDiff)>1)
//			return Integer.MIN_VALUE;
//		else
//			return (Math.max(leftNodeHeight, rightNodeHeight) +1);
//	}

}
