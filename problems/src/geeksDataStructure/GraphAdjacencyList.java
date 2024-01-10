package geeksDataStructure;

import java.util.ArrayList;

public class GraphAdjacencyList {
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		adj.stream().forEach(i->{
			System.out.print(adj.indexOf(i)+"-->");
			i.stream().forEach(System.out::print);
			System.out.println();
		});
	}
	
	public static void main(String[] args) {
		int V=5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		for(int i=0; i<V;i++)
			adj.add(new ArrayList<Integer>());
		addEdge(adj,1,2);
		addEdge(adj,1,4);
		addEdge(adj,2,3);
		addEdge(adj,3,4);
		printGraph(adj);
	}
}
