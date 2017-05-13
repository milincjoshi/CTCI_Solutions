import java.util.*;

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

	public static List<List<Integer>> getSequences(Tree.Node root){
		List<Tree.Node> nodeList = new ArrayList<Tree.Node>();
		nodeList.add(root);
		int i=0;
		
		while(nodeList.get(i) != null){
			Tree.Node node = nodeList.get(i);
			if(node.left != null){
				nodeList.add(node.left);
			}
			if(node.right != null){
				nodeList.add(node.right);
			}
			i++;
		}//end while

		

	}

	public static void main(String[] args){
		Tree tree = new Tree();
		tree.push(tree.root, 5);
		tree.push(tree.root, 1);
		tree.push(tree.root, 8);
		tree.push(tree.root, 0);
		tree.push(tree.root, 2);
		tree.push(tree.root, 7);
		tree.push(tree.root, 10);
		
		
		print_Inorder(tree.root);
	}	
}