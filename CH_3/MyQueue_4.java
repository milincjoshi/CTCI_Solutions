public class MyQueue_4{

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
            if(isEmpty()){
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


    static int flag = 0;
    public static void push_(int data){
        if(flag == 0){
            stackOut.push(data);
            flag++;
        }
        else if(flag == 1){
            stackIn.push(data);
            flag++;
            stackIn.top.next = stackOut.top;
        }
        else{
            stackIn.push(data);
        }
    }

    public static int pop_(){

        Stack.Node n = stackIn.top;
        if(n.next == null){
            stackOut = new Stack();
            stackIn = new Stack();
            return n.data;            
        }
        while(n.next.next != null){
            n = n.next;
        }
        Stack.Node node_to_return = n.next;
        n.next = null;
        return node_to_return.data;
    }

    public static MyQueue_4.Stack stackIn;
    public static MyQueue_4.Stack stackOut;

    public static void print_stack(){
        Stack.Node n = stackIn.top;
       
        while(n!= null){
            System.out.println(n.data);
            n = n.next;
        }
    
    }
    public static void main(String[] agrs){

        stackIn = new MyQueue_4.Stack();
        stackOut = new MyQueue_4.Stack();
        
        push_(5);
        push_(1);
        push_(3);



        print_stack();


    }
}