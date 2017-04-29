public class Check_Balanced_4{
	
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
	
		public void push(Node node, int data){
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
	public static Tree tree;
	public static int height_diff;
	public static int get_height(Tree.Node node){
		if(node == null){
			return 0;
		}

		int i = Math.max( get_height(node.left) , get_height(node.right) );
		int h = Math.abs(get_height(node.left) - get_height(node.right));
		if(h>height_diff){
			height_diff = h;
		}
		return i+1;
	}
	public static void main(String[] args){
		tree = new Tree();
		tree.root = tree.new Node(35);
		//int[] x = {21,23,22,16,45,5,4,12,38,27};
		int[] x = {21,23,22,16,45,5,38,27};
		
		for(int i=0;i<x.length;i++){
			tree.push(tree.root, x[i]);
		}

		int i = get_height(tree.root);
		System.out.println(height_diff);
		if(height_diff>1){
			System.out.println("Given tree is not balanced");
		}
		else{
			System.out.println("Given tree is balanced");			
		}

	}
}