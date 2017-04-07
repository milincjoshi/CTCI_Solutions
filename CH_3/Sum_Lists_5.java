import java.util.*;

public class Sum_Lists_5{
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

		Sum_Lists_5.LinkedList linkedList = new Sum_Lists_5.LinkedList();		
		
		for(int i=0;i<new Random().nextInt(3)+1;i++){
			linkedList.appendToTail(new Random().nextInt(10)+1);
		}	
		
		return linkedList;
	}

	public static LinkedList sum_lists(LinkedList linkedList1, LinkedList linkedList2){

		LinkedList.Node node1 = linkedList1.head;
		LinkedList.Node node2 = linkedList2.head;
		
		LinkedList summed_list = new LinkedList();

		int carry = 0;
		while(node1 != null && node2 != null){
			
			int sum = node1.data + node2.data + carry;
			
			if(sum>9){
				carry = sum/10;
				sum = sum%10;
			}

			summed_list.appendToTail(sum);

			node1 = node1.next;
			node2 = node2.next;

		}

		if(node1 != null){
			while(node1 != null){
				int sum = node1.data+carry;
				if(sum>9){
					carry = sum/10;
					sum = sum%10;
				}
				summed_list.appendToTail(sum);
				node1 = node1.next;
			}
		}
		if(node2 != null){
			while(node2 != null){
				int sum = node2.data+carry;
				if(sum>9){
					carry = sum/10;
					sum = sum%10;
				}
				summed_list.appendToTail(sum);
				node2 = node2.next;
			}
		}

		if(carry != 0){
			if(carry>9){
				int sum = carry/10;
				carry = carry%10;
				summed_list.appendToTail(carry);
				summed_list.appendToTail(sum);
			}
			else{
				summed_list.appendToTail(carry);
			}
		}


		return summed_list;

	}
	
	public static void main(String[] args){
		
		Sum_Lists_5.LinkedList linkedList1 = make_list();
		linkedList1.print_list();

		Sum_Lists_5.LinkedList linkedList2 = make_list();
		linkedList2.print_list();

		LinkedList summed_list = Sum_Lists_5.sum_lists(linkedList1, linkedList2);
		summed_list.print_list();
	
	}	
}