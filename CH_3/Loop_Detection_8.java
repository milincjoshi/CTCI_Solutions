import java.util.*;

public class Loop_Detection_8{
	
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

		Loop_Detection_8.LinkedList linkedList = new Loop_Detection_8.LinkedList();		
		
		for(int i=0;i<5;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
			
		LinkedList.Node node = linkedList.head;

		while(node.next != null){
			node = node.next;
		}
		node.next = linkedList.head.next.next;

		return linkedList;
	}

	public static void isLooped(LinkedList linkedList){

		Loop_Detection_8.LinkedList.Node node_slow = linkedList.head;
		Loop_Detection_8.LinkedList.Node node_fast = linkedList.head.next;


		while(true){
		
			if(node_slow == node_fast){
				print_looped_node(linkedList);
				break;
			}
			if(node_slow.next == null || node_fast.next.next == null){
				System.out.println("No Loop occurs");
				break;
			}

			node_slow = node_slow.next;
			node_fast = node_fast.next.next;
		}
	}
	public static void print_looped_node(LinkedList linkedList){

		HashMap<Loop_Detection_8.LinkedList.Node, Boolean> node_list = new HashMap<Loop_Detection_8.LinkedList.Node, Boolean>();

		Loop_Detection_8.LinkedList.Node node_slow = linkedList.head;
		Loop_Detection_8.LinkedList.Node node_fast = linkedList.head.next;
		
		while(true){
			if(node_list.containsKey(node_slow)){
				System.out.println("Loop occurs at "+node_slow.data);
				break;
			}
			else{
				node_list.put(node_slow,false);
			}
			
			node_slow = node_slow.next;
			node_fast = node_fast.next.next;
		}
	}
	
	public static void main(String[] args){
		//Make a Looped LinkedList
		Loop_Detection_8.LinkedList linkedList = make_list();

		Loop_Detection_8.LinkedList.Node node1 = linkedList.head;		
		for(int i=0;i<5;i++){
			System.out.print(node1.data+" -> ");
			node1 = node1.next;
		}

		System.out.println();

		isLooped(linkedList);


	}
}