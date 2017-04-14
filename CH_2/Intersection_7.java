import java.util.*;

public class Intersection_7{
	
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

		Intersection_7.LinkedList linkedList = new Intersection_7.LinkedList();		
		
		for(int i=0;i<5;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
		
		return linkedList;
	}

	
	public static boolean intersects_1(LinkedList.Node head1, LinkedList.Node head2){

		LinkedList.Node node1 = head1;
		LinkedList.Node node2 = head2;

		while(node1!= null){
			node2 = head2;
			while(node2 != null){
				if(node1 == node2){
					return true;
				}
				node2 = node2.next;
			}
			node1 = node1.next;
		}


		return false;
	}
	public static LinkedList.Node intersects_2(LinkedList.Node head1, LinkedList.Node head2){
		LinkedList.Node node1 = head1;
		LinkedList.Node node2 = head2;

		int n1 = 0;
		int n2 = 0;

		while(node1.next!= null){
			node1 = node1.next;
			n1++;
		}
		while(node2.next!= null){
			node2 = node2.next;
			n2++;
		}
		if(node1 == node2){


			node1 = head1;
			node2 = head2;

			if(n1>n2){
				int n = n1 - n2;
				System.out.println("n1");
				for(int i=0;i<n;i++){
					node1 = node1.next;
				}
			}
			if(n2>n1){
				System.out.println("n1");
				int n = n2 - n1;
				for(int i=0;i<n;i++){
					node2 = node2.next;
				}
			}

			while(node1.next!=null){
				if(node1 == node2){
					return node1;
				}
				node1 = node1.next;
				node2 = node2.next;
			}

		}
		else{
			return null;
		}

		return null;
		
	}

	

	public static void main(String[] args){
		Intersection_7.LinkedList list1 = new LinkedList();
		Intersection_7.LinkedList list2 = new LinkedList();

		Intersection_7.LinkedList.Node node1;
		node1 = list1.new Node(new Random().nextInt(10)+1);

		Intersection_7.LinkedList.Node node2;
		node2 = list1.new Node(new Random().nextInt(10)+1);

		Intersection_7.LinkedList.Node node3;
		node3 = list1.new Node(new Random().nextInt(10)+1);

		Intersection_7.LinkedList.Node node4;
		node4 = list1.new Node(new Random().nextInt(10)+1);

		Intersection_7.LinkedList.Node node5;
		node5 = list1.new Node(new Random().nextInt(10)+1);

		Intersection_7.LinkedList.Node node6;
		node6 = list1.new Node(new Random().nextInt(10)+1);

		node5.next = node6;

		list1.appendToTail_node(node1);
		list1.appendToTail_node(node2);
		list2.appendToTail_node(node3);
		list2.appendToTail_node(node4);
		list1.appendToTail_node(node5);
		list2.appendToTail_node(node5);

		list1.print_list();
		list2.print_list();
		
		Intersection_7.LinkedList.Node node_intersecting;
		node_intersecting = intersects_2(list1.head, list2.head);
			
		System.out.println(node_intersecting.data);
	}
}