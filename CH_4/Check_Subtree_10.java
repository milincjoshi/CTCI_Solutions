import java.util.*;

public class Check_Subtree_10{
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
			System.out.print(node.data+",");
			print_Inorder(node.right);
		}
	}
	
	public static void find_tree2_root(Tree.Node node, Tree.Node tree2_root){
		if(node == null){
			return;
		}
		if(node.data == tree2_root.data){
			//found root
			System.out.println("found");
			iterate_subtrees(node, tree2_root);
			System.out.println("subtree_are_same "+subtree_are_same);
		}
		find_tree2_root(node.left, tree2_root);
		find_tree2_root(node.right, tree2_root);
			
	}

	static boolean subtree_are_same = true;

	public static void iterate_subtrees(Tree.Node node1, Tree.Node node2){
		if(node1 == null || node2 == null){
			return;
		}

		if(node1.data != node2.data){
			subtree_are_same = false;
		}
				
		iterate_subtrees(node1.left, node2.left);
		iterate_subtrees(node1.right, node2.right);	

	}


	public static void main(String[] agrs){
		
		Tree tree1 = new Tree();
		Tree tree2 = new Tree();

		for(int i=0;i<10;i++){
			int j = new Random().nextInt(100)+25;
			tree1.push(tree1.root,j);
		}		

		tree1.push(tree1.root, 10);
		tree1.push(tree1.root, 5);
		tree1.push(tree1.root, 15);
		tree1.push(tree1.root, 2);
		tree1.push(tree1.root, 7);
		tree1.push(tree1.root, 13);
		tree1.push(tree1.root, 20);
		
		tree2.push(tree2.root, 10);
		tree2.push(tree2.root, 5);
		tree2.push(tree2.root, 15);
		tree2.push(tree2.root, 2);
		tree2.push(tree2.root, 7);
		tree2.push(tree2.root, 13);
		tree2.push(tree2.root, 20);

		// tree1.print_Inorder(tree1.root);
		// System.out.println();
		// tree2.print_Inorder(tree2.root);
		// System.out.println();
		
		find_tree2_root(tree1.root, tree2.root);

	}
}