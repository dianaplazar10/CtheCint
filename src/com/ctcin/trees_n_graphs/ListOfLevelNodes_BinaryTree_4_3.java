package com.ctcin.trees_n_graphs;

import java.util.LinkedList;

public class ListOfLevelNodes_BinaryTree_4_3 {

	public static void main(String[] args) {
		Array2MinimalBinaryTree_4_2 arr2binTree = new Array2MinimalBinaryTree_4_2();
		int[] arr = {3,4,2,1,5,6,7};
		arr = arr2binTree.getArrSorted(arr);
		TreeNode binaryTreeNode = arr2binTree.getTreeOfArr(arr);
		
		LinkedList<LinkedList<TreeNode>> listOfLevelNodes=getListOfLevelNodes(binaryTreeNode);
		for(LinkedList<TreeNode> list : listOfLevelNodes){
			list.forEach(x->System.out.print(x.nodeVal+" "));
			System.out.println();
		}
	}

	/*
	 * Here's whats happening this this method:
	 * 1)First off, create a LinkedList of List to hold all Level-wise Nodes' list --- listOfLevelNodes
	 * 2)Create a temp LinkedList of treeNode, that will hold all the child nodes. However, this is first assign to a temp node, before clearing to contain teh children as seen, within the while loop
	 * 3) The while loop checks to see if the LinkedList containing child nodes is empty or not 
	 * 4) and then each of the parent nodes are traversed to add their respective child nodes for the next while iteration.
	 */
	private static LinkedList<LinkedList<TreeNode>> getListOfLevelNodes(TreeNode binaryTreeNode) {
		//final list.. holding all lists
		LinkedList<LinkedList<TreeNode>> listOfLevelNodes=new LinkedList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> currentLevelList = new LinkedList<TreeNode>();// will re-use this list for overwriting all nodes in a level from within the below while loop
		//Adding the first level- root node
		if(binaryTreeNode!=null)
			currentLevelList.add(binaryTreeNode);
		
		//temp list holding current level children
		while(currentLevelList.size()>0){
			listOfLevelNodes.add(currentLevelList);
			LinkedList<TreeNode> parents = currentLevelList;
			currentLevelList = new LinkedList<TreeNode>();
			for(TreeNode node : parents){
				if(node.leftChild!=null)
					currentLevelList.add(node.leftChild);
				if(node.rightchild!=null)
					currentLevelList.add(node.rightchild);
			}
		}		
		return listOfLevelNodes;
	}

}
