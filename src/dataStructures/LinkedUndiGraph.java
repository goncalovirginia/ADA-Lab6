package dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedUndiGraph implements UndiGraph {
	
	private final List<List<Integer>> successors;
	
	public LinkedUndiGraph(int numNodes) {
		successors = new ArrayList<>(numNodes);
		
		for (int i = 0; i < numNodes; i++) {
			successors.add(new LinkedList<>());
		}
	}
	
	@Override
	public int numNodes() {
		return successors.size();
	}
	
	@Override
	public int numEdges() {
		return 0;
	}
	
	@Override
	public int aNode() {
		return 0;
	}
	
	@Override
	public void addEdge(int node1, int node2) {
		successors.get(node1).add(node2);
		successors.get(node2).add(node1);
	}
	
	@Override
	public boolean edgeExists(int node1, int node2) {
		return false;
	}
	
	@Override
	public Iterable<Integer> nodes() {
		return null;
	}
	
	@Override
	public Iterable<Edge> edges() {
		return null;
	}
	
	@Override
	public int degree(int node) {
		return successors.get(node).size();
	}
	
	@Override
	public Iterable<Integer> adjacentNodes(int node) {
		return successors.get(node);
	}
	
	@Override
	public Iterable<Edge> incidentEdges(int node) {
		return null;
	}
}
