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

	
	public static boolean intersects(LinkedList.Node head1, LinkedList.Node head2){

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
		System.out.println(intersects(list1.head, list2.head));
		
		list1 = make_list();
		list2 = make_list();
		System.out.println(intersects(list1.head, list2.head));
	}
}