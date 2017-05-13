public class BST_Sequences_9{
	static class Tree{
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
			if(root == null){
				root = new Node(data);
			}
			else{
				if(data < node.data && node.left == null){
					node.left = new Node(data);
				}
				if(data > node.data && node.right == null){
					node.right = new Node(data);
				}
				if(data < node.data  && node.left != null){
					push(node.left, data);
				}
				if(data > node.data  && node.right != null){
					push(node.right, data);
				}
			}
		}

		public void print_Inorder(Node node){
			if(node  == null){
				return;
			}
			print_Inorder(node.left);
			System.out.println(node.data);
			print_Inorder(node.right);
		}
	}

	public static void poss_1(Tree.Node node){
		if(node == null){
			return;
		}
		if(node.right != null && node.left != null){
			System.out.print(node.data+","+node.left.data+","+node.right.data+",");
		}
		System.out.println();
	}
	public static void poss_2(Tree.Node node){
		if(node == null){
			return;
		}
		if(node.right != null && node.left != null){
			System.out.print(node.data+","+node.right.data+","+node.left.data+",");
		}
		System.out.println();
	}

	public static void print_Inorder(Tree.Node node){
		if(node == null){
			return;
		}

		print_Inorder(node.left);

		poss_1(node);
		poss_2(node);

		print_Inorder(node.right);

	}


	public static void main(String[] args){
		Tree tree = new Tree();
		tree.push(tree.root, 10);
		tree.push(tree.root, 5);
		tree.push(tree.root, 15);
		
		print_Inorder(tree.root);
	}	
}