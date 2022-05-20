import dataStructures.LinkedUndiGraph;
import dataStructures.UndiGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	
	private static int nodeCounter = 1;
	private static int[][] nodes = new int[1000][1000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int s = Integer.parseInt(in.readLine()), paintedSegments = 0;
		UndiGraph segments = new LinkedUndiGraph(s * 2 + 1);
		
		for (int i = 0; i < s; i++) {
			int[] c = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if (!formsCycle(segments, c)) {
				paintedSegments++;
			}
		}
		
		System.out.println(paintedSegments);
	}
	
	private static boolean formsCycle(UndiGraph segments, int[] c) {
		int node1 = coordinatesToNode(c[0], c[1]), node2 = coordinatesToNode(c[2], c[3]);
		
		if (segments.degree(node1) == 0 || segments.degree(node2) == 0) {
			segments.addEdge(node1, node2);
			return false;
		}
		
		boolean[] visited = new boolean[segments.numNodes()];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(node1);
		
		while (!stack.empty()) {
			int currentNode = stack.pop();
			
			if (currentNode == node2) {
				return true;
			}
			
			visited[currentNode] = true;
			
			for (int node : segments.adjacentNodes(currentNode)) {
				if (!visited[node]) {
					stack.push(node);
				}
			}
		}
		
		segments.addEdge(node1, node2);
		return false;
	}
	
	private static int coordinatesToNode(int x, int y) {
		if (nodes[x][y] == 0) {
			nodes[x][y] = nodeCounter;
			return nodeCounter++;
		}
		return nodes[x][y];
	}
	
}
