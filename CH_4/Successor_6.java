public class Successor_6{
	public static class Tree{
		Node root;
		class Node{
			int data;
			Node left;
			Node right;
			public Node(int data){
				this.data = data;
			}
		}

		public static void push(Node node, int data){
			if(tree.root == null){
				tree.root = tree.new Node(data);
				return;
			}
			if(node.left == null && data<node.data){
				node.left = tree.new Node(data);
			}
			if(node.right == null && data>node.data){
				node.right = tree.new Node(data);
			}
			if (node.left != null && data<node.data) {
				push(node.left, data);
			}
			if (node.right != null && data>node.data) {
				push(node.right, data);
			}
		}
	}


	public static void find_successor(Tree.Node node){
		if(node.left == null){
			successor = node.data;
			return;
		}

		find_successor(node.left);
	}

	public static void find_node(Tree.Node node){
		if(node == null){
			return;
		}
		find_node(node.left);
		if(node.data == my_successor){
			if(node.right != null){
				find_successor(node.right);
				successor_exists = true;
			}
		}
		find_node(node.right);
			
	}

	static int my_successor;
	static int successor;
	static Tree tree;
	static boolean successor_exists;

	public static void main(String[] args){
		successor_exists = false;	
		tree = new Tree();
		tree.root = tree.new Node(35);
		int[] x = {21,23,22,16,45,5,4,12,38,27,40,41};
		for(int i=0;i<x.length;i++){
			tree.push(tree.root, x[i]);
		}

		my_successor = 45;
		find_node(tree.root);
		if(successor_exists){
			System.out.println(successor);
		}
		else{
			System.out.println("No successor_exists for "+my_successor);
		}
	}
}