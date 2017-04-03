/*
	This program creates all permutations of a String
	and checks if each permutation is a palindrome or not
*/

import java.util.*;

public class Permutation_Palindrome_4{

	public static ArrayList<String> permute(String s){
		
		if(s.length() == 2){
			String s_start = s.substring(0,1);
			String s_end = s.substring(1);
			ArrayList<String> permutations_of_2 = new ArrayList<String>();
			permutations_of_2.add(s);
			permutations_of_2.add(s.charAt(1)+""+s.charAt(0));
			return permutations_of_2;				
		}

		ArrayList<String> list_received = permute(s.substring(0,s.length()-1));
		ArrayList<String> list_to_send = new ArrayList<String>();
		char c = s.charAt(s.length()-1);
		for(String str : list_received){
			for(int i=0;i<=str.length();i++){
	            String s_start = str.substring(0,i);
	            String s_end = str.substring(i);
	            
	        	list_to_send.add(s_start+c+s_end);
	        }
		}


		return list_to_send;


	}

	public static boolean is_palindrome(String str){
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i) != str.charAt(str.length()-1-i)){
				return false;
			}
		}

		return true;
	}
	public static boolean check(String str){
		//get all permutations of str1

		ArrayList<String> permutations_list = permute(str);
		
		boolean flag = false;
		for(String s : permutations_list){
			if(is_palindrome(s)){
				return true;
			} 
		}

		return false;

	}
	public static void main(String[] args){
		String str1 = "tacocat";
		System.out.println(check(str1));
	}
}