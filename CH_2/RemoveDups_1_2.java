import java.util.*;

public class RemoveDups_1_2{
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

		RemoveDups_1_2.LinkedList linkedList = new RemoveDups_1_2.LinkedList();		
		
		for(int i=0;i<10;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
			
		return linkedList;
	}

	public static LinkedList remove_dup(LinkedList linkedList){

		LinkedList.Node node1 = linkedList.head;
		LinkedList.Node node2 = linkedList.head;
		LinkedList.Node node2_next = linkedList.head;
		
		while(node1 != null){
			
			node2 = node1;
			node2_next = node2.next;

			while(node2.next != null){
				if(node2_next.data == node1.data){
					node2.next = node2_next.next;
				//	node2_next = node2_next.next; 
				}
				else{
					node2 = node2.next;
				//	node2_next = node2_next.next;
				}
				node2_next = node2_next.next;
			}

			node1 = node1.next;
		}
				
		return linkedList;

	}
	
	public static void main(String[] args){

		RemoveDups_1_2.LinkedList linkedList = make_list();
		linkedList.print_list();
		linkedList = remove_dup(linkedList);
		linkedList.print_list();
			
	}
}