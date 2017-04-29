public class Validate_BST_5{
	
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

	static boolean isBST;
	public static void traverse_inorder(Tree.Node node){
		if(node == null){
			return;
		}
		
		traverse_inorder(node.left);


		if( (node.left != null && node.left.data>node.data) || (node.right !=null && node.right.data<node.data) ){
			isBST = false;
		}	

		traverse_inorder(node.right);
			
	}
	static Tree tree;
	public static void main(String[] args){
		
		tree = new Tree();
		
		tree.root = tree.new Node(35);
		isBST = true;
		int[] x = {21,23,22,16,45,5,4,12,38,27,40,41};
		for(int i=0;i<x.length;i++){
			tree.push(tree.root, x[i]);
		}

		traverse_inorder(tree.root);
		if(isBST){
			System.out.println("Given Binary tree is a Binary Search Tree");
		}
		else{
			System.out.println("Given Binary tree is not a Binary Search Tree");			
		}
	}
}