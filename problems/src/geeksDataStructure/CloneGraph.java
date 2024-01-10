package geeksDataStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> neighbors;

	void addEdge(Node u, Node v) {
		u.neighbors.add(v);
		v.neighbors.add(u);
	}

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

}

public class CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Map<Node, Node> map = new HashMap<Node, Node>();
		Queue<Node> visited = new ArrayDeque<Node>();
		visited.add(node);
		map.put(node, new Node(node.val, new ArrayList<Node>()));
		while (!visited.isEmpty()) {
			Node head = visited.poll();
			for (Node neighbors : head.neighbors) {
				if (!map.containsKey(neighbors)) {
					map.put(neighbors, new Node(neighbors.val, new ArrayList<Node>()));
					visited.add(neighbors);
				}
				map.get(head).neighbors.add(map.get(neighbors));
			}
		}
		return map.get(node);
	}
	
	static void bfs(Node node) {
		Queue<Node> visited = new ArrayDeque<Node>();
		visited.add(node);
		while (!visited.isEmpty()) {
			Node h = visited.poll();
			for (Node node2 : h.neighbors) {
				visited.add(node2);
			}
			System.err.print(h.val+" ");			
		}
		System.err.println();
	}

	public static void main(String[] args) {
//		[[2,4],[1,3],[2,4],[1,3]]

		List<Node> nodelist = new ArrayList<Node>();
		nodelist.add(new Node(1, new ArrayList<Node>(Arrays.asList(new Node[] { new Node(2, new ArrayList<Node>()), new Node(4, new ArrayList<Node>()) }))));
		nodelist.add(new Node(2,new ArrayList<Node>(Arrays.asList(new Node[] { new Node(1), new Node(3, new ArrayList<Node>()) }))));
		nodelist.add(new Node(3, new ArrayList<Node>(Arrays.asList(new Node[] { new Node(2), new Node(4) }))));
		nodelist.add(new Node(4, new ArrayList<Node>(Arrays.asList(new Node[] { new Node(3), new Node(1) }))));

//		Node node1 = new Node(1, new ArrayList<Node>());
//		Node node2 = new Node(2, new ArrayList<Node>());
//		Node node3 = new Node(3, new ArrayList<Node>());
//		Node node4 = new Node(4, new ArrayList<Node>());
//
//		node1.neighbors.add(node2);
//		node1.neighbors.add(node4);
//		node2.neighbors.add(node1);
//		node2.neighbors.add(node3);
//		node3.neighbors.add(node2);
//		node3.neighbors.add(node4);
//		node4.neighbors.add(node1);
//		node4.neighbors.add(node3);
		
		System.out.println(nodelist.get(0));
		bfs(nodelist.get(0));
		Node cloneNode = new CloneGraph().cloneGraph(nodelist.get(0));
		System.out.println("cloneNode:" + cloneNode);

	}
}