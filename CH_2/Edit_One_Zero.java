/*
	In this program we check for less than 2 edits
	There are 3 cases
	1. str1 is less than str2
	2. str1 has 1 character more than str2
	3. both strings are of equal length and there is only 1 character different
*/

public class Edit_One_Zero{
	public static boolean is_one_or_zero_edit_away(String str1, String str2){
		
		if(Math.abs(str1.length() - str2.length())>2){
			return false;
		}


		if(str1.length()<str2.length()){
			
			for(int i=0;i<str1.length();i++){
				if(!str2.contains(str1.charAt(i)+"")){
					return false;
				}
			}

			return true;
		}
		if(str2.length()<str1.length()){
			for(int i=0;i<str2.length();i++){
				if(!str1.contains(str2.charAt(i)+"")){
					return false;
				}
			}

			return true;
		
		}	

		int diff_count = 0;
		if(str1.length() == str2.length()){
			for(int i=0;i<str2.length();i++){
				if(!str1.contains(str2.charAt(i)+"")){
					diff_count++;
				}
			}
		}	

		if(diff_count<2){
			return true;
		}
		return false;
	}
	public static void main(String[] args){

		System.out.println(is_one_or_zero_edit_away("pale","ple"));
		System.out.println(is_one_or_zero_edit_away("pales","pale"));
		System.out.println(is_one_or_zero_edit_away("pale","bale"));
		System.out.println(is_one_or_zero_edit_away("pale","bake"));

	}
}