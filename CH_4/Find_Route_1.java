import java.util.*;

public class Find_Route_1{
	
	static class Graph{

		public Node[] nodes;

		class Node{
			public Node(int data){
				this.data = data;
			}
			public int data;
			boolean visited;
			public Node[] children;
		}
	}

	public static Graph make_Graph(int graph_size){

		int[][] arr = new int[][]{

		// for(int i=0;i<graph_size;i++){
		// 	for(int j=0;j<graph_size;j++){
		// 		arr[i][j] = new Random().nextInt(2);
		// 	}
		// }

		{0,1,0,0,1,1},
		{0,0,0,1,1,0},
		{0,1,0,0,0,0},
		{0,0,1,0,1,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0}
		};

		for(int i=0;i<graph_size;i++){
			for(int j=0;j<graph_size;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

		//

		//creating graph
		Graph graph = new Graph();
		graph.nodes = new Graph.Node[graph_size];
		Graph.Node[] nodes = graph.nodes;
		//creating all nodes
		for(int i=0;i<graph_size;i++){
			nodes[i] = graph.new Node(i);
		}

		for(int i=0;i<graph_size;i++){
			Graph.Node current_node = nodes[i];

			//get child count
			int child_count = 0;
			for(int j=0;j<graph_size;j++){
				if(arr[i][j] == 1){
					child_count++;
				}
			}
			
			current_node.children = new Graph.Node[child_count];
		
			int current_child = 0;
			for(int j=0;j<graph_size;j++){
				if(arr[i][j] == 1){
					current_node.children[current_child] = nodes[j];
					current_child++;
				}
			}
		}

		return graph;
	}

	public static void print_graph_bfs(Graph.Node node){
		ArrayList<Graph.Node> arr = new ArrayList<Graph.Node>();
		arr.add(node);
		node.visited = true;
		int i=0;
		System.out.println(node.data);
		while(i<arr.size() && arr.get(i) != null){
			Graph.Node cur = arr.get(i);
			for(Graph.Node n : cur.children){
				if(n.visited == false){
					n.visited = true;
					arr.add(n);
					System.out.println(n.data);					
				}
			}
			i++;
		}
	}

	public static boolean isConnected(Graph.Node n1, Graph.Node n2){
		//go bfs, its faster
		ArrayList<Graph.Node> arr = new ArrayList<Graph.Node>();
		arr.add(n1);
		n1.visited = true;
		int i=0;
 		while(i<arr.size() && arr.get(i) != null){
			Graph.Node cur = arr.get(i);
			for(Graph.Node n : cur.children){
				if(n == n2 && n.visited == false){
					return true;
				}
				if(n.visited == false){
					n.visited = true;
					arr.add(n);
				}
			}
			i++;
		}

		return false;
	}

	public static void main(String[] args){

		Graph graph = make_Graph(6);
		//print_graph_bfs(graph.nodes[0]);
		System.out.println(isConnected(graph.nodes[2], graph.nodes[4]));
	}
}