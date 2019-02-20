package com.ctcin.trees_n_graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph_custom {
	GraphNode headNode;
	public GraphNode getHeadNode() {return headNode;}
	public void setHeadNode(GraphNode headNode) {
		this.headNode = headNode;
		this.nodes.add(headNode);
	}
	
	List<GraphNode> nodes = new ArrayList<GraphNode>();
	public List<GraphNode> getNodes() {return nodes;}
	public void setNodes(List<GraphNode> nodes) {this.nodes = nodes;}
}
enum NODE_STATE{VISITED, VISITING, UNVISITED};

class GraphNode{
	int graphdata;
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	List<GraphNode> adjacentNodes = new ArrayList<GraphNode>();

	public GraphNode(int data, String name) {
		this.graphdata=data;
		this.name=name;
		this.state = NODE_STATE.UNVISITED;
	}
	
	public int getGraphdata() {
		return graphdata;
	}
	public void setGraphdata(int graphdata) {
		this.graphdata = graphdata;
	}
	public List<GraphNode> getAdjacentNodes() {
		return adjacentNodes;
	}
	public void setAdjacentNodes(List<GraphNode> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	NODE_STATE state;
	
	public NODE_STATE getState() {
		return state;
	}

	public void setState(NODE_STATE state) {
		this.state = state;
	}
	
}
