import java.util.*;

public class List_of_Depths_3{
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
		public static ArrayList<LinkedList> print_levels(Node node){
			ArrayList<Node> arr = new ArrayList<Node>();
			ArrayList<Integer> level = new ArrayList<Integer>();
			
			arr.add(node);
			level.add(0);

			int i=0;
			while(i<arr.size() && arr.get(i) != null){

				node = arr.get(i);
				if(level.get(i)<main_list.size()){
					LinkedList ll = main_list.get(level.get(i));
					ll.push(node.data);
					main_list.set(level.get(i),ll);
				}
				else{
					LinkedList ll = new LinkedList();
					ll.push(node.data);
					main_list.add(ll);
				}

				if(node.left != null){
					arr.add(node.left);
					level.add(level.get(i)+1);
				}
				if(node.right != null){
					arr.add(node.right);
					level.add(level.get(i)+1);
				}

				i++;	
			}

			return main_list;
		}
	}
	public static class LinkedList{
		Node head;
		class Node{
			int data;
			Node next;
			public Node(int data){
				this.data = data;
			}
		}

		public void push(int data){
			if(head == null){
				head = new Node(data);
			}
			else{
				Node node_to_append = new Node(data);
				Node node = head;
				while(node.next != null){
					node = node.next;
				}
				node.next = node_to_append;
			}
		}

		public boolean isEmpty(){
			if(head == null){
				return true;
			}
			else{
				return false;
			}
		}
	}

	static Tree tree;
	static LinkedList linkedList;
	static ArrayList<LinkedList> main_list;

	public static void main(String[] agrs){
		main_list = new ArrayList<LinkedList>();
		tree = new Tree();
		linkedList = new LinkedList();

		tree.root = tree.new Node(35);
		int[] x = {21,23,22,16,45,5,4,12,38,27};
		for(int i=0;i<x.length;i++){
			tree.push(tree.root, x[i]);
		}

		main_list = tree.print_levels(tree.root);
		for(int i=0;i<main_list.size();i++){
			LinkedList.Node head = main_list.get(i).head;
			System.out.print("List "+(i+1)+" - ");
			while(head != null){
				System.out.print(head.data+",");
				head = head.next;
			}
			System.out.println();
		}
	}
}