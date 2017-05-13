import java.util.*;

public class Random_Node_11{
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
		int randomNum,counter;
		public Node getRandomNode(){
			Node randomNode;
			counter = 0;
			randomNum = new Random().nextInt(treeSize);
			return getRandomNode_iterate(root);

		}
		public Node getRandomNode_iterate(Tree.Node node){
			if(node == null){
				return null;
			}
			if(counter == randomNum){
				return node;
			}
			counter++;
			Node n1 = getRandomNode_iterate(node.left);
			Node n2 = getRandomNode_iterate(node.right);
			if(n1 != null){
				return n1;
			}
			if(n2 != null){
				return n2;
			}
			return null;

		}
		static int treeSize=0;

		public void insert(Node node, int data){
			if(root == null){
				root = new Node(data);
				treeSize++;
			}
			else{
				if(data < node.data && node.left == null){
					node.left = new Node(data);
					treeSize++;
				}
				if(data > node.data && node.right == null){
					node.right = new Node(data);
					treeSize++;
				}
				if(data < node.data  && node.left != null){
					insert(node.left, data);
				}
				if(data > node.data  && node.right != null){
					insert(node.right, data);
				}
			}
		}

		public void find(Node node, int data){

			if(node == null){
				return;
			}
			if(node.data == data){
				System.out.println(node.data+" found");
			}
			else{
				find(node.left, data);
				find(node.right, data);				
			}

		}

		public void delete(Node node, int data){
			if(node == null){
				return;
			}
			if(node.left != null && node.left.data == data && node.left.left != null){
				node.left = node.left.left;
			}
			if(node.left != null && node.left.data == data && node.left.left == null){
				node.left = null;
			}
			if(node.right != null && node.right.data == data && node.right.right != null){
				node.right = node.right.right;
			}
			if(node.right != null && node.right.data == data && node.right.right == null){
				node.right = null;
			}
			if(node.left != null){
				delete(node.left, data);
			}
			if(node.right != null){
				delete(node.right, data);
			}
				
		}
		public void print_order(Node node){
			if(node == null){
				return;
			}	
			System.out.print(node.data+",");
			print_order(node.left);
			print_order(node.right);
				
		}
	}
	public static void main(String[] args){
		Tree tree = new Tree();

		tree.insert(tree.root, 10);
		tree.insert(tree.root, 4);
		tree.insert(tree.root, 3);
		tree.insert(tree.root, 2);
		tree.insert(tree.root, 9);
		tree.insert(tree.root, 6);
		
		// 	 tree.print_order(tree.root);
		// tree.delete(tree.root, 4);
		System.out.println();
		tree.print_order(tree.root);
		// tree.find(tree.root, 2);
		Tree.Node n = tree.getRandomNode();
		System.out.println("random node "+n.data);
	}
}