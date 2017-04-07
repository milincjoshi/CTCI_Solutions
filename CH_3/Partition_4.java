import java.util.*;

public class Partition_4{

	public LinkedList getLinkedList(){
		return new LinkedList();
	}
	public static class LinkedList{

		class Node{
			int data;
			Node next;	

			public Node(int data){
				this.data = data;
			}
		}

		Node head;

		public void appendToTail(int data){
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

		public void appendToTail_node(Node node_to_append){
			if(head == null){
				head = node_to_append;
			}
			else{
				Node node = head;
				while(node.next != null){
					node = node.next;
				}
				node.next = node_to_append;
			}
		}
		
		public void print_list(){
			Node node = head;
			while(node != null){
				System.out.print(node.data+" -> ");
				node = node.next;
			}
			System.out.println();
		}
	}

	public static LinkedList make_list(){

		Partition_4.LinkedList linkedList = new Partition_4.LinkedList();		
		
		for(int i=0;i<10;i++){
			LinkedList.Node node = linkedList.new Node(new Random().nextInt(10)+1);
			linkedList.appendToTail_node(node);
		}	
		
		return linkedList;
	}

	public static LinkedList partition(int d, LinkedList linkedList){
		
		LinkedList list_lesser = new LinkedList();
		LinkedList list_greater_or_equal = new LinkedList();
		
		LinkedList.Node node = linkedList.head;
		
		while(node != null){

			if(node.data<d){
				list_lesser.appendToTail(node.data);				
			}
			else{
				list_greater_or_equal.appendToTail(node.data);
			}

			node = node.next;
		}


		node = list_lesser.head;
		while(node.next != null){
			node = node.next;
		}		

		node.next = list_greater_or_equal.head;

		return list_lesser;

	}
	public static void main(String[] args){
		
		// Partition_4 p_lesser = new Partition_4();
		// Partition_4 p_greater_or_equal = new Partition_4();
		// Partition_4 p_ = new Partition_4();

		// Partition_4.LinkedList list_made = p_.make_list();
		// Partition_4.LinkedList list_lesser = p_lesser.getLinkedList();
		// Partition_4.LinkedList list_greater_or_equal = p_greater_or_equal.getLinkedList();

		// list_made.print_list();

		// Partition_4.LinkedList.Node node;
		// node = list_made.head;

		Partition_4.LinkedList linkedList = make_list();
		linkedList.print_list();
		linkedList = partition(5, linkedList);
		linkedList.print_list();

		/*
		while(node != null){

			if(node.data<d){

				list_lesser.appendToTail(node.data);
				// System.out.println();
				// System.out.print("lesser ");
				// list_lesser.print_list();
				// System.out.println();
				
			}
			else{
				
				list_greater_or_equal.appendToTail(node.data);
				// System.out.println();
				// System.out.print("greater ");
				// list_greater_or_equal.print_list();
				// System.out.println();
			}

			node = node.next;
		}

		list_lesser.print_list();
		list_greater_or_equal.print_list();
		*/

	}	
}