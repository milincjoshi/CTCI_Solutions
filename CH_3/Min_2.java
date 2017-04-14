import java.util.*;

public class Min_2{

    public static class Stack{
        
        Node top;

        class Node{
            public Node(int data){
                this.data = data;
            }
            int data;
            Node next;
        }

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

        public int pop(){
            Node node = top;
            top = top.next;
            return node.data;
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

    public static void add_to_stack(int data){
        
        if(dataStack.isEmpty()){
            dataStack.push(data);
            minStack.push(data);
        }
        else{
            if(data<minStack.peek()){
                dataStack.push(data);
                minStack.push(data);
            }
            else{
                dataStack.push(data);
                minStack.push(minStack.peek());
            }   
        }

    }

    public static Min_2.Stack minStack;
    public static Min_2.Stack dataStack;

    public static void print_stack(Min_2.Stack stack1, Min_2.Stack stack2){
        Min_2.Stack.Node n1 = stack1.top;
        Min_2.Stack.Node n2 = stack2.top;

        System.out.println();
        while(n1 != null){
            System.out.print(n1.data);
            n1 = n1.next;
        }
        System.out.println();
        System.out.println();
        while(n2 != null){
            System.out.print(n2.data);
            n2 = n2.next;
        }
        System.out.println();
    }
    public static void pop(){
        dataStack.pop();
        minStack.pop();
    }
    public static void main(String[] args){
        
        dataStack = new Min_2.Stack();
        minStack = new Min_2.Stack();

        for(int i=0;i<10;i++){
            int j = new Random().nextInt(10)+1;
            add_to_stack(j);
            System.out.println(j+" added to Stack");
            System.out.println("min - "+minStack.peek());
        }
        pop();
        System.out.println("pop");
        System.out.println("min - "+minStack.peek());
        pop();
        System.out.println("pop");
        System.out.println("min - "+minStack.peek());
       

    }
}
