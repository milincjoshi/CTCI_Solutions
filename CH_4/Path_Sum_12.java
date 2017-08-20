public class Path_Sum_12{
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
	public static void main(String[] args){
	
	}
}