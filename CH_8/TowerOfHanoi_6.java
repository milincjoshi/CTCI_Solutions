class TowerOfHanoi_6{

    static class Stack{
        Node top;

        class Node{
            int i;
            Node next;

            public Node(int i){
                this.i = i;
            }
        }

        public void push(int i){
            if(top == null){
                top = new Node(i);
            }
            else{
                Node node = new Node(i);
                node.next = top;
                top = node;
            }
        }

        public int pop(){
            int i = top.i;
            top = top.next;
            return i;
        }

        public int peek(){
            return top.i;
        }

        public boolean isEmpty(){
            if(top == null){
                return true;
            }

            return false;
        }
    }

    static Stack src = new Stack();
    static Stack bfr = new Stack();
    static Stack dest = new Stack();
    
    public static void setUpPegs(int n){
        for(int i=n;i>=1;i--){
            src.push(i);
        }
    }

    public static void printStack(Stack stck){
        int size = 0;
        Stack.Node srcTop = stck.top;
        
        //get size
        while(srcTop != null){
            srcTop = srcTop.next;
            size++;
        }
        int[] arr = new int[size];
        
        int i = 0;

        srcTop = stck.top;
        while(srcTop != null){
            arr[i] = srcTop.i;
            i++;
            srcTop = srcTop.next;
        }
        System.out.print("  ");
        for(int j = 0;j<size;j++){
            System.out.print(arr[j]+",");
        }
        System.out.println();
    }
    public static void printPegs(){
        System.out.println("source");
        printStack(src);
        System.out.println("buffer");
        printStack(bfr);
        System.out.println("destination");
        printStack(dest);
    }

    public static void moveTop(Stack source, Stack destination){
        
        int i = source.pop();
        destination.push(i);
    }
    public static void processHanoiPegs(Stack source, Stack buffer, Stack destination, int n){
           
            if(n == 1){
                moveTop(source, destination);
                return;
            }
            if(n == 2){
                
                moveTop(source, buffer);
                moveTop(source, destination);
                moveTop(buffer,destination);


                return;
            }

            processHanoiPegs(source, destination, buffer, n-1);
            moveTop(source, destination);
            System.out.println("halfway");
            printPegs();
            processHanoiPegs(buffer, source, destination, n-1);

    }
    public static void main(String[] args){

        int n = 10;

        setUpPegs(n);
        printPegs();

        processHanoiPegs(src, bfr, dest, n);
        System.out.println("new");
        printPegs();


    }
}