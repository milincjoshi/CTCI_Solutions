public class Animal_Shelter_6{

	public static class Queue{
		
		class Node{
	
			char data;
			Node next;
			
			public Node(char data){
				this.data = data;
			}
		}

		Node first;
		Node last;
	
		public void enqueue(char chr){
			if(first == null || last == null){
				last = new Node(chr);
				first = last;
			}
			else{
				Node n = new Node(chr);
				last.next = n;
				last = n;
			}
		}

		public char dequeueDog() throws Exception{
			Node n = first;
			if(n.data == 'd'){
				char c = dequeueAny();
				return c;
			}
			else{
				while(n.next.data != 'd'){
					n = n.next;
				}

				Node node_to_return = n.next;
				n.next = n.next.next;

				return node_to_return.data;
			}
		}

		public char dequeueCat() throws Exception{
			Node n = first;
			if(n.data == 'c'){
				char c = dequeueAny();
				return c;
			}
			else{
				while(n.next.data != 'c'){
					n = n.next;
				}

				Node node_to_return = n.next;
				n.next = n.next.next;

				return node_to_return.data;
			}
	
		}
		public char dequeueAny() throws Exception{
			if(isEmpty()){
				throw new Exception();
			}

			Node n = first;
			first = first.next;
			return n.data;	
		}

		public boolean isEmpty(){
			if(first == null || last ==  null){
				return true;
			}
			else{
				return false;
			}
		}

		public char peek(){
			return first.data;
		}

		public void print_queue(){
			Node node = first;
			while(node!= null){
				System.out.print(node.data);
				node = node.next;
			}
			System.out.println();
		}
		

	}
	public static void main(String[] args) throws Exception{
		Queue q = new Queue();

		q.enqueue('c');
		q.enqueue('d');
		q.enqueue('c');
		q.enqueue('d');

		q.dequeueDog();
		q.dequeueDog();
		q.dequeueCat();
		q.dequeueCat();
		
		q.print_queue();

	}
}	
