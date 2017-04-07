public class Delete_Middle_Node_3{

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

		public Node node_to_delete(int d){
			Node node = head;
			while(node != null && node.data != d){
				node = node.next;
			}
			return node;
		}
	}

	public static LinkedList make_list(){

		Delete_Middle_Node_3.LinkedList linkedList = new Delete_Middle_Node_3.LinkedList();		
		
		for(int i=0;i<10;i++){
			linkedList.appendToTail(1);
		}	
		
		return linkedList;
	}



	public static void main(String[] args){
		
		Delete_Middle_Node_3.LinkedList linkedList = make_list();
		Delete_Middle_Node_3.LinkedList.Node node_to_del = linkedList.node_to_delete(2);

		int data_of_next = node_to_del.next.data;
		node_to_del.data = data_of_next;
		node_to_del.next = node_to_del.next.next;

		linkedList.print_list();		
	}
}