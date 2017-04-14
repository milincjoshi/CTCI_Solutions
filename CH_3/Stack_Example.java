public class Stack_Example{
    static class Stack{
        class Node{
            int data;
            Node next;
        }

        public void push(int data){
            Node node = new Node();
            node.data = data;
            if(head == null){
                head = node;
            }
            else{
                node.next = top;
                top = node;
            }
        }

        public int pop(){
            if(top == null){
                throw new Exception("Stack Empty");
            }
            else{
                Node node = top;
                top = top.next;
                return node.data;
            }
        }
    }
    public static void main(String[] args){

    }
}