package com.ctcin.trees_n_graphs;

/*
 * This class denotes a directed graph
 * 
 * and creates a Praph of exactly size 6(6 nodes) based on the array values passed.
 * 
 */
public class GraphUtil {
	
	/**
	 * Creates a Graph based on values passed
	 * 
	 * Keeping size fixed to 6, for ease of constructing the graph
	 * 
	 * [0] -> head -> [1][5]
	 * [1] -> [2][3][4]
	 * [2] -> none
	 * [3] -> none
	 * [4] -> none
	 * [5] ->  [1]
	 * 
	 * 
	 * 			    A[0]
	 * 			  /      \
	 * 			 /        \
	 * 		    B[1]   <-   C[5]
	 * 		 /   |   \
	 *      /    |    \
	 *    E[2]  F[3]  G[4]
	 * 
	 * 
	 */
	public static Graph_custom createGraphWithNodes(int[] nodevals) {
		if(nodevals.length<1) 
			return null;
		int size = nodevals.length;
		Graph_custom graph = new Graph_custom();
		GraphNode A = new GraphNode(Integer.valueOf(nodevals[0]),"A");
		graph.setHeadNode(A);

		GraphNode B = new GraphNode(Integer.valueOf(nodevals[1]),"B");
		graph.getNodes().add(B);
		GraphNode E = new GraphNode(Integer.valueOf(nodevals[2]),"E");
		graph.getNodes().add(E);
		GraphNode F = new GraphNode(Integer.valueOf(nodevals[3]),"F");
		graph.getNodes().add(F);
		GraphNode G = new GraphNode(Integer.valueOf(nodevals[4]),"G");
		graph.getNodes().add(G);
		GraphNode C = new GraphNode(Integer.valueOf(nodevals[5]),"C");
		graph.getNodes().add(C);
		
		A.adjacentNodes.add(B);
		A.adjacentNodes.add(C);
		
		B.adjacentNodes.add(E);
		B.adjacentNodes.add(F);
		B.adjacentNodes.add(G);
		
		C.adjacentNodes.add(B);
		
		return graph;
	}

	/**
	 * @param graph
	 */
	static void printGraphNodes(Graph_custom graph) {
		for (int i = 0; i < graph.nodes.size(); i++) {
			System.out.print(graph.nodes.get(i).graphdata);
			System.out.print("  ->  ");
		}
	}
	

}
