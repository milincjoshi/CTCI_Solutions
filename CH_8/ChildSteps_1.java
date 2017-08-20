public class ChildSteps_1{
    
    public static int countSteps(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2 ){
            return n;
        }

        int a = countSteps(n-1);
        int b = countSteps(n-2);

        return a+b;

    }
    public static void main(String[] args){
        System.out.println(countSteps(3));
    }
}