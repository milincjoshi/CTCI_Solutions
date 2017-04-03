/*
	In this program, we use 2 arrays
	One array is used to iterate over the original string containing spaces
	second array is used for replacing spaces with %20

	Time Complexity of this program is O(n) where n is the length of the string
	and Space Complexity of this program is also O(n) where n is the length of the string, as we use another array
	to fill in characters.

	There is also a second approach to this program where if you find a space,
	you insert %20 (3 characters) and push the rest of the characters 2 spaces away
	but this approach will O(n^2) time complexity
*/

import java.util.*;

public class URLify_3{

	public static void urlify(String str){

		char[] arr_original  = str.toCharArray();
		String to_return = str.trim();
		char[] arr_to_return = new char[arr_original.length];
		
		int j=0;
		for(int i=0; i<to_return.length();i++){

			if(arr_original[i] == ' '){
				arr_to_return[j] = '%';
				j++;
				arr_to_return[j] = '2';
				j++;
				arr_to_return[j] = '0';
			}
			else{
				arr_to_return[j] = arr_original[i];
			}
			j++;
			
		}

		System.out.println(arr_to_return);

	}
	public static void main(String[] args){
		String x = "Mr John Smith    ";
		urlify(x);
	}
}