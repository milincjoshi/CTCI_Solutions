import java.util.*;

public class Sum_Lists_5_2{
	
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

		int carry = 0;
		public Node add(Node node1, Node node2){
	
			if(node1 ==  null && node2 == null){
				return null;
			}

			Node received_node = add(node1.next, node2.next);
		
			int sum = node1.data+node2.data+carry;
			if(sum>9){
				carry = sum/10;
				sum = sum%10;
			}
			Node added_node = new Node(sum);
			added_node.next = received_node;
			return added_node;
		}
	
	}

	public static LinkedList make_list(){

		Sum_Lists_5_2.LinkedList linkedList = new Sum_Lists_5_2.LinkedList();		
		
		for(int i=0;i<5;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
		
		return linkedList;
	}

	public static LinkedList sum_lists(LinkedList linkedList1, LinkedList linkedList2){

		Sum_Lists_5_2.LinkedList.Node node1 = linkedList1.head;
		Sum_Lists_5_2.LinkedList.Node node2 = linkedList2.head;
		
		LinkedList summed_list = new LinkedList();

		Sum_Lists_5_2.LinkedList.Node node = summed_list.add(node1, node2);
		Sum_Lists_5_2.LinkedList.Node carry_node = null;
		if(summed_list.carry!=0){
			carry_node = summed_list.new Node(summed_list.carry);
			carry_node.next = node;
		}

		if(carry_node == null){
			while(node != null){
				System.out.print(node.data+" -> ");
				node = node.next;
			}
		}
		else{
			while(carry_node != null){
				System.out.print(carry_node.data+" -> ");
				carry_node = carry_node.next;
			}

		}

		return summed_list;

	}

	
	public static void main(String[] args){

		Sum_Lists_5_2.LinkedList linkedList1 = make_list();
		linkedList1.print_list();

		Sum_Lists_5_2.LinkedList linkedList2 = make_list();
		linkedList2.print_list();

		LinkedList summed_list = Sum_Lists_5_2.sum_lists(linkedList1, linkedList2);
		summed_list.print_list();
	}
}