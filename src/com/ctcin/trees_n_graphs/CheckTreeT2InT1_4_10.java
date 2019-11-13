package com.ctcin.trees_n_graphs;

/*
 * Problem is to check if Binary tree T2 is a subtree of Binary Tree T1
 * 
 * Solution:
 * -------
 * 1) We could traverse both the trees to an array via the pre-order traversal. (Pre-order suits most, as it excuses teh ascending order as in in-order traversal.)
 * 2) Once traversed into an in -irder array, the T2 can be checked if contained in T1
 * 
 * Example tree, T1 (created below in main method):
    
     *      5
     *  /       \
     *  2        6
     * / \      / \
     * 1  3    11  12
     * /\      /
     *7  8    15
     *         \
     *         10
     *         
     *         
     *         
     *         T2:
 		//Lets check for another subtree (T2)
        	     6
        *       / \
        *     11  12
        *     /
        *    15
        *     \
        *     10
     */


public class CheckTreeT2InT1_4_10 {

	public static void main(String[] args) {
		TreeNode t1Node = new TreeNode(5);
        createTree(t1Node);

        TreeNode t2Node = new TreeNode(6);
        createTreeT2(t2Node);
        
        boolean ist1InT2 = IsT1ContainsT2(t1Node,t2Node);
        System.out.println("Is T2 contained in T1 ?  :::" + ist1InT2);
        
	}

	/*
	 * This method takes in both the big tree T1 and the subtree T2
	 * 1) Get the pre=order version String)use StringBuilder for both these trees
	 * 2) check if the index of T2 is in T1,If the index search returns -1, T1 does not contain T2
	 * 3) IMPORTANT - all leaf nodes needs to indicate their null Nodes, with 'X', 
	 * 		as otherwise, a tree with no left child and tree with no right child such as one below, would have same pre-order,
	 * 		example:
	 * 			6				6
	 * 			/				 \
	 * 		   3                  3
	 * 
	 * 	While they are not the same binary tree, one has no left child, while th other has no right child
	 */
	private static boolean IsT1ContainsT2(TreeNode t1Node, TreeNode t2Node) {
		StringBuilder preOrderStrT1 = new StringBuilder();
		StringBuilder preOrderStrT2 = new StringBuilder();
		
		appendPreOrderStr4Tree(t1Node,preOrderStrT1);
		appendPreOrderStr4Tree(t2Node,preOrderStrT2);
		return (preOrderStrT1.indexOf(preOrderStrT2.toString())!=-1);
	}

	private static void appendPreOrderStr4Tree(TreeNode node, StringBuilder preOrderStr) {
		if(node ==null) {
			preOrderStr.append("X");
			return;
		}
		preOrderStr.append(String.valueOf(node.nodeVal));
		appendPreOrderStr4Tree(node.leftChild,preOrderStr);
		appendPreOrderStr4Tree(node.rightchild,preOrderStr);		
	}

	private static void createTreeT2(TreeNode t2Node) {
		t2Node.leftChild = new TreeNode(11);
        t2Node.leftChild.leftChild = new TreeNode(15);
        t2Node.leftChild.leftChild.rightchild = new TreeNode(10);
        t2Node.rightchild = new TreeNode(12);		
	}

	/**
	 * * Example tree(created below in main method):
    
     *      5
     *  /       \
     *  2        6
     * / \      / \
     * 1  3    11  12
     * /\      /
     *7  8    15
     *         \
     *         10
	 */
	private static void createTree(TreeNode node) {
		node.leftChild = new TreeNode(5);
        node.leftChild.leftChild = new TreeNode(1);
        node.leftChild.leftChild.leftChild = new TreeNode(7);
        node.leftChild.leftChild.rightchild = new TreeNode(8);
        node.leftChild.rightchild =  new TreeNode(3);
        //node.leftChild.rightchild.leftChild =  new Node(9);
        node.rightchild =  new TreeNode(10);
        node.rightchild.leftChild = new TreeNode(11);
        node.rightchild.leftChild.leftChild = new TreeNode(15);
        node.rightchild.leftChild.leftChild.rightchild = new TreeNode(10);
        
        //if 2 longest path
        //node.rightchild.leftChild.leftChild.leftChild = new Node(40);//prints both the paths
        
        node.rightchild.rightchild = new TreeNode(12);
	}

}
