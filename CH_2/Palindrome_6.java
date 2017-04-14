import java.util.*;

public class Palindrome_6{
	
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

		Palindrome_6.LinkedList linkedList = new Palindrome_6.LinkedList();		
		
		//for(int i=0;i<5;i++){
			linkedList.appendToTail(1);
			linkedList.appendToTail(2);
			linkedList.appendToTail(3);
			linkedList.appendToTail(3);
			linkedList.appendToTail(2);
			linkedList.appendToTail(1);
			
		//}	
		
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
	
	static Palindrome_6.LinkedList reversed_list;
	
	public static boolean isPalindrome(LinkedList.Node head1, LinkedList.Node head2){
		while(head1!= null){

			if(head1.data != head2.data){
				return false;
			}

			head1 = head1.next;
			head2 = head2.next;

		}
		return true;
	}
	public static void main(String[] args){
		
		reversed_list = make_list();
		reversed_list.print_list();
		reverse(reversed_list.head);
		System.out.println(isPalindrome(reversed_list.head, newHead));	
		

	}
}