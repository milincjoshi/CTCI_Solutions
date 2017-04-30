public class First_Common_Ancestor_8{
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

	}

	public static boolean in_subtree(Tree.Node root, Tree.Node n1){

		if(root == null){
			return false;
		}

		boolean x = in_subtree(root.left, n1);
		boolean y = in_subtree(root.right, n1);
		if(root == n1 || x == true || y == true){
			return true;
		}else{
			return false;
		}
	}

	public static Tree.Node find_common_ancestor(Tree.Node node, Tree.Node n1, Tree.Node n2){
		
		System.out.println(node.data+" "+n1.data+" "+n2.data);
		boolean n1_in_left = in_subtree(node.left, n1);
		boolean n2_in_right = in_subtree(node.right, n2);

		boolean n2_in_left = in_subtree(node.left, n2);
		boolean n1_in_right = in_subtree(node.right, n1);

		if(  (n1_in_left && n2_in_right) ||  (n2_in_left && n1_in_right)){
			return node;
		}
		if(n1_in_left && n2_in_left){
			return find_common_ancestor(node.left, n1,n2);
		}
		if(n1_in_right && n2_in_right){
			return find_common_ancestor(node.right, n1, n2);
		}
		if(node == n1 || node == n2){
			return node;
		}

		return null;
	}
	public static void main(String[] agrs){
		Tree tree = new Tree();
		Tree.Node n3 = tree.new Node(3);
		Tree.Node n5 = tree.new Node(5);
		Tree.Node n9 = tree.new Node(9);
		Tree.Node n17 = tree.new Node(17);
		Tree.Node n1 = tree.new Node(1);
		Tree.Node n0 = tree.new Node(0);
		Tree.Node n27 = tree.new Node(27);
		Tree.Node n4 = tree.new Node(4);
		Tree.Node n93 = tree.new Node(93);
		Tree.Node n48 = tree.new Node(48);
		Tree.Node n67 = tree.new Node(67);
		Tree.Node n55= tree.new Node(55);
		
		n3.left = n5;
		n3.right = n9;
		n5.left = n17;
		n5.right = n1;
		n1.left = n4;
		n9.left = n0;
		n9.right = n27;
		n27.left = n67;
		n0.left = n93;
		n0.right = n48;
		n48.left = n55;

		Tree.Node common_ancestor = find_common_ancestor(n3, n55, n27);
		if(common_ancestor != null){
			System.out.println(common_ancestor.data);
		}
		
			
	}
}