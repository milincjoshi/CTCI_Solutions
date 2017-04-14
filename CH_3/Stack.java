public class Three_In_One_1{
	
	public static class Stack{
		int i;
		Node top;
		class Node{
			int data;
			Node next;
		}

		public void push(int val){
		
			Node node = new Node();
			node.data = val;

			if(top == null){
				top = node;
			}
			else{
				node.next = top;
				top = node;		
			}
		
		}
		
		public Node pop() throws Exception{

			if(top == null){
				throw new Exception("Stack Empty");
			}
			else{
				Node node = top;
				top = top.next;
				return node;
			}
		
		}

		public Node peek(){
			return top;
		}

		public boolean isEmpty(){
			if(top == null){
				return true;
			}
			else{
				return false;
			}
		}

		public void print_stack(){
			Node node = top;
			System.out.println();
			while(node!=null){
				System.out.print(node.data+"->");
				node = node.next;
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws Exception{
		Three_In_One_1.Stack three_in_one_stack = new Three_In_One_1.Stack();
		three_in_one_stack.push(3);
		three_in_one_stack.push(8);
		three_in_one_stack.push(1);
		three_in_one_stack.pop();
		three_in_one_stack.print_stack();

	}
}