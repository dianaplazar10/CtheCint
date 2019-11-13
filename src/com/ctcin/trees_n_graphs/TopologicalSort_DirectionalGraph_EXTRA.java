package com.ctcin.trees_n_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * Implement Alien Dictionary
 * 
 * --Interview question with LIME bikes
 * 
 * Problem statement: Given a list of strings, construct an alien dictionary that hols letters of the alien dictionary ...
 *  with sample of strings with topological order
cbb
cbc
aa
ak
aj

reference: https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/

Solution briefing:
1)take 2 strings at a time and compare until the min string length , for each characters
2)The character that comes first is the first in the alpahbetic order. Now try and create nodes as your compare and add it to a Graph, as GraphVertex.
3)The second word in the sequence, or the letter rather, that is compared in the 2 words, is added also, as the adjacent vertex of the first letter
4)Now once the graph is created, they are sorted topologically
	4i)create a stack, an array of boolean with the same size of the no:of vertices in the graph
	4ii)pass the above values and the index of the first node in the graph to a method for topological sorting.
	4iii)Mark the node or corresponding index in the bool array as true as they are traversed, and recurse the topological call on each of the cadjacent nodes of the given node.
	4iv)As a final step pf traverse, add the graph Vertex to the stk 
	Finally, return the stack and pop the letters in the stack to print the letters in topological ordering.
	
	
	NOTE:
	-----
	While comparing letters between 2 words, we only consider the min string length, 
	hence, we may miss out of letter that exceeds the min string, 
	However, we need to also add these nodes into the graph, Atleast as a lone Vertex.
	hence -------(5)
	
	
 */
public class TopologicalSort_DirectionalGraph_EXTRA {

	public static void main(String[] args) {	
		//Create a Directed Graph with the input Strings
		String[] strs ={"cbdke","cbdj","a","ab","b"};// Exp O/P: c a b d k j e
		//{ "cbb","cbc","aa","ak","aj"};// Exp O/P: b c a k j
		Graph graph = new Graph();
		graph.createGraphWithStrings(strs);
		graph.printverticesValues();
		
		System.out.println("");
		System.out.println("----Topological sorting of the alien language----------");
		Stack<GraphVertex> stk =sortTopologically(graph);//Iterate through all vertices of the graph and push to stack from lowest level.
		while(!stk.isEmpty()){
			System.out.println(stk.pop().vertexVal + " ");
		}
		
	}

	private static Stack<GraphVertex> sortTopologically(Graph graph) { // -------------(4i)
		Stack<GraphVertex> stk = new Stack<GraphVertex>();
		List<GraphVertex> vertices = graph.listOfVertices;
		Boolean[] isVisitedBools=new Boolean[vertices.size()];
		Arrays.fill(isVisitedBools,false);///thsi will set false to all items of same number of vertices in the graph
		for(int currentVertexIndex =0; currentVertexIndex<vertices.size();currentVertexIndex++) {
			if(!isVisitedBools[currentVertexIndex]){
				topologicalSortUtil(currentVertexIndex,vertices,isVisitedBools, stk); // -------------(4ii)
			}
		}
		return stk;
	}

	//set the current vertex to visited(=true) and check if either of its children are visited, ignore if visited, recurse otherwise
	private static void topologicalSortUtil(int i, List<GraphVertex> vertices, Boolean[] isVisitedBools, Stack<GraphVertex> stk) {
		isVisitedBools[i] = true;	// -------------(4ii)
		for(GraphVertex adjVertex :vertices.get(i).getAdjacentVertices()){
			 if(!isVisitedBools[vertices.indexOf(adjVertex)]){
				 topologicalSortUtil(vertices.indexOf(adjVertex),vertices,isVisitedBools, stk);
			 }
		}
		stk.push(vertices.get(i));	// -------------(4iv)
	}
}

//Create a Directed Graph with Graph Nodes

class Graph{
	int size;
	GraphVertex startVertex;
	List<GraphVertex> listOfVertices = new ArrayList<GraphVertex>();

	public void printverticesValues() {
		listOfVertices.forEach(vertex->System.out.print(vertex.vertexVal + " "));
	}
	public void setStartVertex(GraphVertex startNode){
		this.startVertex=startVertex;
	}
	
	public GraphVertex getStartVertex(){
		return this.startVertex;
	}
	
	public int getGraphSize(){
		this.size = this.listOfVertices.size();
		return size;
	}
	
	public void addVertix2Graph(GraphVertex vertex){
		this.listOfVertices.add(vertex);
	}
	
	public void createGraphWithStrings(String[] strs){
		int strsIndex=0;
		Set<Character> graphChars = new HashSet<Character>();
		for(int i=0;i<strs.length-1;i++){ // traverse through words. Comparing 2 words at a time
			String word1 = strs[i];
			String word2 = strs[i+1];
			// the character to charcater comparison can only happen until the smaller word length, hence for modified accordingly
			int minLength = Math.min(word1.length(),word2.length()); 
			for (int j = 0; j < minLength; j++) {
				if(word1.charAt(j)!=word2.charAt(j)){
					GraphVertex node1 = new GraphVertex(word1.charAt(j));
					GraphVertex node2 = new GraphVertex(word2.charAt(j));
					//Add both the nodes to Graph
					addVertex2Graph(graphChars, node1, node2);
				}
				//------------To also include missed out end characters from words larger than the comparing words
				//But teh only drawback is that the last nodes get added at the end... so prints before the expected first characters.
				/*
				if((word1.length()-word2.length())>0){
					addVertex2GraphAndSet(graphChars, word1, word2);
				} else if(word2.compareToIgnoreCase(word1)>0){
					addVertex2GraphAndSet(graphChars, word2, word1);
				}
				*/
			}
			
			
			
			//Adding left out nodes from words greater than the min length string
			
		}
		this.size=this.listOfVertices.size();
	}
	/**
	 * @param graphChars
	 * @param word1
	 * @param word2
	 */
	private void addVertex2GraphAndSet(Set<Character> graphChars, String word1, String word2) {
		for(int k=(word1.length()-word2.length())-1; k<word1.length();k++){
			if(!graphChars.contains(word1.charAt(k))) {
				GraphVertex vertex = new GraphVertex(word1.charAt(k));
				graphChars.add(vertex.vertexVal);
				listOfVertices.add(vertex);
			} 
		}
	}
	/**
	 * @param graphChars
	 * @param node1
	 */
	private void addVertex2Graph(Set<Character> graphChars, GraphVertex node1, GraphVertex node2) {
		if(!graphChars.contains(node1.vertexVal)) {
			graphChars.add(node1.vertexVal);
			listOfVertices.add(node1);
		}
		
		if(!graphChars.contains(node2.vertexVal)) {
			graphChars.add(node2.vertexVal);
			listOfVertices.add(node2);
		} 
		GraphVertex vertex = listOfVertices.stream().filter(vertexx->vertexx.vertexVal==node1.vertexVal).findFirst().orElse(null);
		GraphVertex vertex2 = listOfVertices.stream().filter(vertexx->vertexx.vertexVal==node2.vertexVal).findFirst().orElse(null);
		//add the second char as next vertex to the first letter, 
		if(!vertex.getAdjacentVertices().contains(vertex2)) vertex.getAdjacentVertices().add(vertex2);
	}
}


//Create GraphVertices for the Graph
class GraphVertex{
	char vertexVal;
	List<GraphVertex> adjacentVertices=null;
	public GraphVertex(char nodeValue) {
		this.vertexVal=nodeValue;
	}
	
	private void addChildVertex(GraphVertex adjacentVertex){
		if(adjacentVertices==null){
			adjacentVertices = new ArrayList<GraphVertex>();
		}
		if(adjacentVertex!=null) 
			adjacentVertices.add(adjacentVertex);
	}
	
	public List<GraphVertex> getAdjacentVertices(){
		if(adjacentVertices==null){
			adjacentVertices = new ArrayList<GraphVertex>();
		}
		return adjacentVertices;
	}
}
//Create Graph node consisting node value and adjascent nodes,
