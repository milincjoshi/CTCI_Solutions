
/*
	In this program we check for if a given string is rotation of the given string by
	concating the first string with itself and determining if the second string is 
	substring of the first string.	
*/

public class Is_Rotation_9{
	
	public static boolean isSubString(String str1, String str2){

		boolean is_sub_string = false;

		char[] str1_arr = str1.toCharArray();
		char[] str2_arr = str2.toCharArray();

		int str2_count = 0;
	
		for(int i=0; i<str1_arr.length;i++){
	
			if(str1_arr[i] == str2_arr[str2_count]){
				str2_count++;
				if(str2_count == str2.length()){
					return true;
				}
			}
			else{
				str2_count = 0;
			}
		}
			
		return false;


	}

	public static boolean isRotation(String str1, String str2){

		String str = str1+str1;
		return isSubString(str, str2);

	}

	public static void main(String[] args){

		String x = "bottlewater";
		String y = "erbottlewat";
		System.out.println(isRotation(x,y));

	}
}