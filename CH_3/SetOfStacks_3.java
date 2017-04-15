import java.util.*;

public class SetOfStacks_3{
	
	
	public static ArrayList<Stack> setOfStacks;

	public static void push_to_set_of_stacks(int data){


		if(setOfStacks.size() == 0){
			SetOfStacks_3.Stack newStack = new SetOfStacks_3.Stack();
			newStack.push(data);
			setOfStacks.add(newStack);
	
		}
		else{
			Stack lastStack = setOfStacks.get(setOfStacks.size()-1);
			if(lastStack.height>=lastStack.height_limit || lastStack == null){
				SetOfStacks_3.Stack newStack = new SetOfStacks_3.Stack();
				newStack.push(data);
				setOfStacks.add(newStack);
			}
			else{
				lastStack.push(data);
			}

		}
	}
	public static int pop_to_set_of_stacks(){
		Stack lastStack = setOfStacks.get(setOfStacks.size()-1);
		int i = lastStack.pop();
		if (lastStack.isEmpty()) {
			lastStack = null;
		}
		return i;
	}	

	public static class Stack{

		Node top;
		int height = 0;
		int height_limit = 5;
		
		class Node{
			public Node(int data){
				this.data = data;
			}
			int data;
			Node next;
		}

		public void push(int data){
			if(isEmpty()){
				top = new Node(data);
			}
			else{
				Node node = new Node(data);
				node.next = top;
				top = node;
			}

			this.height++;
		}

		public int pop(){
			Node node = top;
			top = top.next;
			return node.data;
		}

		public boolean isEmpty(){
			if(top == null){
				return true;
			}
			else{
				return false;
			}
		}

		public int peek(){
			return top.data;
		}
		
	}

	public static void print_all_data(){
		for(int i=setOfStacks.size()-1;i>=0;i--){
			Stack s = setOfStacks.get(i);
			Stack.Node t = s.top;
			System.out.println();
			while(t!= null){
				System.out.print(t.data+" | ");
				t = t.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		
		setOfStacks = new ArrayList<Stack>();
	
		for(int i=0;i<new Random().nextInt(20)+1;i++){
			int j = new Random().nextInt(10)+1;
			SetOfStacks_3.push_to_set_of_stacks(j);
		}
		print_all_data();
		
	}
}