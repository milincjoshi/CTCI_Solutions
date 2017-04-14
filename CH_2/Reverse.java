import java.util.*;

public class Reverse{
	
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

		Reverse.LinkedList linkedList = new Reverse.LinkedList();		
		
		for(int i=0;i<5;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
		
		return linkedList;
	}

	static LinkedList.Node newHead;
	public static LinkedList.Node reverse(LinkedList.Node head){

		if(head.next == null){
			newHead = head;
			return head;
		}

		LinkedList.Node node = reverse(head.next);

		if(node == null){
			return null;
		}
		if(head == reversed_list.head){
			node.next = head;
			head.next = null;
			return head;
		}	
		else{

			node.next = head;
			return head;						
		}

	}
	
	static Reverse.LinkedList reversed_list ;
	
	public static void main(String[] args){
		
		reversed_list = make_list();
		reversed_list.print_list();

		Reverse.LinkedList.Node x = reverse(reversed_list.head);
		
		Reverse.LinkedList.Node newH = newHead; 
			
		while(newH!=null){
			System.out.print(newH.data+" -> ");
			newH = newH.next;
		}	


	}
}