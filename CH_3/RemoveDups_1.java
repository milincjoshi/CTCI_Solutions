
import java.util.*;

public class RemoveDups_1{
	
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

		RemoveDups_1.LinkedList linkedList = new RemoveDups_1.LinkedList();		
		
		//for(int i=0;i<5;i++){
			linkedList.appendToTail(1);
			linkedList.appendToTail(1);
			linkedList.appendToTail(2);
			linkedList.appendToTail(1);
			linkedList.appendToTail(2);
			linkedList.appendToTail(1);
			linkedList.appendToTail(2);
			linkedList.appendToTail(1);
		
		//}	
		
		return linkedList;
	}

	public static LinkedList remove_dup(LinkedList linkedList){

		HashSet<Integer> hash_set = new HashSet<Integer>();

		LinkedList.Node node1 = linkedList.head;
		LinkedList.Node node2 = linkedList.head;
		hash_set.add(node1.data);
		while(node1 != null){
			node2 = node1.next;			
			while(node2 != null){
				if(hash_set.contains(node2.data)){
					node1.next = node2.next;
				}
				else{
					hash_set.add(node2.data);
					node1 = node1.next;
				}
				node2 = node2.next;
			}

			node1 = node1.next;
		}
				
		return linkedList;

	}
	
	public static void main(String[] args){

		
		RemoveDups_1.LinkedList linkedList = make_list();

		linkedList.print_list();
		RemoveDups_1.LinkedList linkedList_ = remove_dup(linkedList);
		linkedList_.print_list();

	
	
	}
}