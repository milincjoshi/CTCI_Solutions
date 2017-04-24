public class Sort_Stack_5{
	static class Stack{
		class Node{
			int data;
			Node next;
			
			public Node(int data){
				this.data = data;
			}
		}

		Node top;

		public void push(int data){
			if(top == null){
				top = new Node(data);
			}
			else{
				Node node = new Node(data);
				node.next = top;
				top = node;
			}
		}

		public int pop() throws Exception{
			if(isEmpty()){
				throw new Exception("Stack Empty");
			}
			Node n = top;
			top = top.next;
			return n.data;
		}

		public int peek(){
			return top.data;
		}

		public boolean isEmpty(){
			if(top == null){
				return true;
			}
			else{
				return false;
			}
		}
	}


	public static void sort_Stack(Sort_Stack_5.Stack stack) throws Exception{
		
		Stack sorted_stack  = new Stack();
		Stack original_stack = stack;

		while(original_stack.isEmpty() == false){

			while( (!original_stack.isEmpty()) && (sorted_stack.isEmpty() || (sorted_stack.peek() < original_stack.peek())) ){
				int i = original_stack.pop();
				sorted_stack.push(i);
				//System.out.println(i+" popped from original_stack and pushed sorted_stack");
			}
			if(original_stack.isEmpty()){
				break;
			}

			int temp = original_stack.pop();

			//System.out.println("sorted_stack");
			//print_stack(sorted_stack);
			//System.out.println("original_stack");
			//print_stack(original_stack);
			//System.out.println("temp "+temp);
			//System.out.println(sorted_stack.isEmpty());
			//System.out.println(sorted_stack.peek()+" - "+temp);
			//System.out.println(true == sorted_stack.isEmpty());
			while( (false == sorted_stack.isEmpty()) &&  sorted_stack.peek() > temp  ){
				int i = sorted_stack.pop();
				original_stack.push(i);
			}
			sorted_stack.push(temp);


			// System.out.println("After pushing temp");
			//System.out.println("sorted_stack");
			//print_stack(sorted_stack);
			//System.out.println("original_stack");
			//x`print_stack(original_stack);
		
		}

		while(!sorted_stack.isEmpty()){
			original_stack.push(sorted_stack.pop());
		}



	}

	public static void print_stack(Sort_Stack_5.Stack stack) throws Exception {
		Sort_Stack_5.Stack.Node node = stack.top;
		while(node!= null){
			System.out.print(node.data+" -> ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {

		Stack stack = new Stack();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(12);
		stack.push(12);
		stack.push(1);
		stack.push(9);
		stack.push(6);

		print_stack(stack);
		sort_Stack(stack);
	
		System.out.println("final ans");		
		print_stack(stack);

	}
}
