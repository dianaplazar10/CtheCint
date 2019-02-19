package com.ctcin.trees_n_graphs;

import java.util.LinkedList;

/*
* 			    A[3]
* 			  /      \
* 			 /        \
* 		    B[4]   <-   C[6]
* 		 /   |   \
*      /    |    \
*    E[2]  F[1]  G[5]			D[7]
*/

public class IsRoute_btw_graphNodes_4_1 {

	public static void main(String[] args) {
		int[] arr = {3,4,2,1,5,6,7};

		int size = arr.length;
		Graph_custom graph = new Graph_custom();
		GraphNode A = new GraphNode(Integer.valueOf(arr[0]),"A");
		graph.setHeadNode(A);

		GraphNode B = new GraphNode(Integer.valueOf(arr[1]),"B");
		graph.getNodes().add(B);
		GraphNode E = new GraphNode(Integer.valueOf(arr[2]),"E");
		graph.getNodes().add(E);
		GraphNode F = new GraphNode(Integer.valueOf(arr[3]),"F");
		graph.getNodes().add(F);
		GraphNode G = new GraphNode(Integer.valueOf(arr[4]),"G");
		graph.getNodes().add(G);
		GraphNode C = new GraphNode(Integer.valueOf(arr[5]),"C");
		graph.getNodes().add(C);
		
		GraphNode D = new GraphNode(Integer.valueOf(arr[6]),"D");
		graph.getNodes().add(D);
		
		A.adjacentNodes.add(B);
		A.adjacentNodes.add(C);
		
		B.adjacentNodes.add(E);
		B.adjacentNodes.add(F);
		B.adjacentNodes.add(G);
		
		C.adjacentNodes.add(B);
		
		GraphUtil.printGraphNodes(graph);
		
		boolean isRoute = IsRoutesBetweenNodes(graph,C,D);
		System.out.println("Is there a route between nodes : " + C.name + " and "+D.name + "????????" + isRoute);

	}

	/*
	 * Check if there is a connection between the headNode and the node with value = searchNodeVal
	 */
	private static boolean IsRoutesBetweenNodes(Graph_custom graph, GraphNode headNode, GraphNode searchNode) {
		//Validate if the headnod eitself if the node serached?

		if(headNode==searchNode) return true;
		else if (headNode==null) return false;
		
		setStateOfAllNodesToUnvisited(graph);
		
		//Add head
		LinkedList<GraphNode> nodesList= new LinkedList<GraphNode>();
		nodesList.add(headNode);// add the node here, iterate over this nodes adjacents and set their state as visited, and then 
		GraphNode node;
		while(!nodesList.isEmpty()){
			node = (GraphNode) nodesList.removeFirst();
			if(node!=null){
				//Traverse through each of the adjacent nodes, compare if they are teh serach node, and set their state
				for(GraphNode nodeadj : node.getAdjacentNodes()){
					if(nodeadj.state == NODE_STATE.UNVISITED){
						if(nodeadj==searchNode) {
							return true;
						}else{
							nodeadj.setState(NODE_STATE.VISITING);
							nodesList.add(nodeadj);
						}						
					}
				}
				node.setState(NODE_STATE.VISITED);
			}
		}		
		//Traverse through all of the adjacent nodes of the headnode
		return false;
	}

	private static void setStateOfAllNodesToUnvisited(Graph_custom graph) {
		for (GraphNode node : graph.nodes) {
			node.state= NODE_STATE.UNVISITED;			
		}
		
	}
}