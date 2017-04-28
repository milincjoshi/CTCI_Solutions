public class Minimal_Tree_2{
	
	static class Tree{

		public Node root;

		class Node{
			public Node(int data){
				this.data = data;
			}
			public int data;
			public Node left;
			public Node right;
		}
	}

	public static Tree.Node create_tree(int start, int end){
		if(end<start){
			return null;
		}
		int mid = (start+end)/2;
		Tree.Node node = tree.new Node(arr[mid]);
		node.left = create_tree(start, mid-1);
		node.right = create_tree(mid+1, end);
		return node;
		
	} 
	static Tree tree;
	static int[] arr = {1,3,4,5,8,10,12,15,45};

	public static int print_height(Tree.Node root){
		if(root == null){
			return 0;
		}
		return 1+Math.max(print_height(root.left), print_height(root.right));
	}
	public static void print_inorder(Tree.Node root){
		if(root != null){
			print_inorder(root.left);
			System.out.println(root.data);
			print_inorder(root.right);
		}
	}
	public static void main(String[] args){
		tree = new Tree();
		tree.root = create_tree(0,arr.length-1);		
		print_inorder(tree.root);
		System.out.println("height "+print_height(tree.root));
	}
}