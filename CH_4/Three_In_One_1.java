public class Three_In_One_1{
	
	static int arr_size = 9;
	static int x = 3;
	static int no_of_stacks = arr_size/x;

	
	public static class Stack{
		
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
		
		public Node pop(int i) throws Exception{

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

	public static void push_to_stack(int val, int stack_num){
		
		if(stack_num == 1){
			if(three_in_one_stack1.isEmpty()){
				int push_at_this = 0;
				three_in_one_stack1.push(push_at_this);
				Three_In_One_1.Stack.Node n = three_in_one_stack1.new Node();
				n.data = val;
				arr[push_at_this] = n;
			}
			else{
				Three_In_One_1.Stack.Node peek_this = three_in_one_stack1.peek();
				int push_at_this = peek_this.data+no_of_stacks;
				three_in_one_stack1.push(push_at_this);
				Three_In_One_1.Stack.Node n = three_in_one_stack1.new Node();
				n.data = val;
				arr[push_at_this] = n;

			}
		}
		if(stack_num == 2){
			if(three_in_one_stack2.isEmpty()){
				int push_at_this = 1;
				three_in_one_stack2.push(push_at_this);
				Three_In_One_1.Stack.Node n = three_in_one_stack2.new Node();
				n.data = val;
				arr[push_at_this] = n;
			}
			else{
				Three_In_One_1.Stack.Node peek_this = three_in_one_stack2.peek();
				int push_at_this = peek_this.data+no_of_stacks;
				three_in_one_stack2.push(push_at_this);
				Three_In_One_1.Stack.Node n = three_in_one_stack2.new Node();
				n.data = val;
				arr[push_at_this] = n;

			}
		}
		if(stack_num == 3){
			if(three_in_one_stack3.isEmpty()){
				int push_at_this = 2;
				three_in_one_stack3.push(push_at_this);
				Three_In_One_1.Stack.Node n = three_in_one_stack3.new Node();
				n.data = val;
				arr[push_at_this] = n;
			}
			else{
				Three_In_One_1.Stack.Node peek_this = three_in_one_stack3.peek();
				int push_at_this = peek_this.data+no_of_stacks;
				three_in_one_stack3.push(push_at_this);
				Three_In_One_1.Stack.Node n = three_in_one_stack3.new Node();
				n.data = val;
				arr[push_at_this] = n;

			}
		}
			
	}

	static Three_In_One_1.Stack three_in_one_stack1;
	static Three_In_One_1.Stack three_in_one_stack2;
	static Three_In_One_1.Stack three_in_one_stack3;

	static Three_In_One_1.Stack.Node[] arr;
	
	public static void main(String[] args) throws Exception{

		arr = new Three_In_One_1.Stack.Node[arr_size];

		three_in_one_stack1 = new Three_In_One_1.Stack();
		three_in_one_stack2 = new Three_In_One_1.Stack();
		three_in_one_stack3 = new Three_In_One_1.Stack();

		push_to_stack(10, 1);
		push_to_stack(0, 2);
		push_to_stack(3, 3);
		push_to_stack(6, 1);
		push_to_stack(8, 2);
		push_to_stack(5, 3);
			
		three_in_one_stack1.print_stack();
		three_in_one_stack2.print_stack();
		three_in_one_stack3.print_stack();

		System.out.println();
		for(Three_In_One_1.Stack.Node n : arr){
			System.out.print(n.data);
		}
		System.out.println();
			
	}
		
}