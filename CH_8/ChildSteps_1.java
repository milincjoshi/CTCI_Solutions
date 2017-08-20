import java.util.*;

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

    static HashMap<Integer, Integer> hashMap;

    public static int countStepsOptimizedTime(int n){
        
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2 ){
            return n;
        }

        if(hashMap.containsKey(n)){
            return hashMap.get(n);
        }
        else{
            int a = countStepsOptimizedTime(n-1);
            int b = countStepsOptimizedTime(n-2);

            hashMap.put(n, a+b);

            return a+b;
        }

    }
    public static void main(String[] args){
        
        int n = 5;

        hashMap = new HashMap<Integer, Integer>();

        System.out.println(countSteps(n));
        System.out.println(countStepsOptimizedTime(n));
        
        
    }
}