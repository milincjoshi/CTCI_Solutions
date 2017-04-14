import java.util.*;

public class Kth_to_last_2_2{
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

		Kth_to_last_2_2.LinkedList linkedList = new Kth_to_last_2_2.LinkedList();		
		
		for(int i=0;i<10;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
		
		return linkedList;
	}

	public static int kth_to_last(LinkedList.Node node, int k){

		LinkedList.Node node1 = node;
		LinkedList.Node node2 = node;
		
		int i=0;
		while(i!=k){
			node1 = node1.next;
			i++;
		}

		while(node1 != null){
			node1 = node1.next;
			node2 = node2.next;
		}

		return node2.data;

	}
	
	public static void main(String[] args){
		
		Kth_to_last_2_2.LinkedList linkedList = make_list();

		linkedList.print_list();
		int i = kth_to_last(linkedList.head, 5);
		System.out.println(i);
	
	
	}	
}