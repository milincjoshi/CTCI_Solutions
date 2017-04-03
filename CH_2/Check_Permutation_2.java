/*
	With this program we check 
	how many times each character occurs in each String
	if the count does not match return false
	Thus this program checks if each character occurs same number of times in each string
*/

import java.util.*;

public class Check_Permutation_2{
	
	public static boolean check_permutation(String str1, String str2){
		HashMap<Character, Integer> hash_map = new HashMap<Character, Integer>();
		if(str1.length() != str2.length()){
			return false;
		}

		for(int i=0; i<str1.length();i++){
			if(hash_map.containsKey(str1.charAt(i))){
				hash_map.put(str1.charAt(i),hash_map.get(str1.charAt(i))+1);
			}
			else{
				hash_map.put(str1.charAt(i),1);
			}
		}

		for(int i=0; i<str2.length();i++){
			if(!hash_map.containsKey(str2.charAt(i))){
				return false;
			}

			int val = hash_map.get(str2.charAt(i));
			val--;
			if(val<0){
				return false;
			}

			hash_map.put(str2.charAt(i), val);
		}

		return true;

	}
	public static void main(String[] args){

		String x = "milin";
		String y = "ilinm";

		System.out.println(check_permutation(x,y));
	}
}