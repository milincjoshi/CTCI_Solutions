import java.util.*;

public class Is_unique_1{

	public static boolean is_unique(String str){

		//convert string to char array for sorting
		char[] arr = str.toCharArray();
		Arrays.sort(arr);

		//checking consecutive characters
		for(int i=0; i<arr.length-1;i++){
			if(arr[i] == arr[i+1]){
				return false;
			}
		}

		return true;
	}
	public static void main(String[] args){
		String x = "miln";
		System.out.println(is_unique(x));
	}
}