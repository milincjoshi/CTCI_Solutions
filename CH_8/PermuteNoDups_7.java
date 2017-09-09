import java.util.*;

public class PermuteNoDups_7{
	
	public static ArrayList<String> permute(String str, int start, int end){
		if(start>end){
			return null;
		}

		if(start == end){
			ArrayList<String> list = new ArrayList<String>();
			list.add(str.charAt(start)+"");
			return list;
		}
		if(start+1 == end){
			ArrayList<String> list = new ArrayList<String>();
			list.add(str.charAt(start)+""+str.charAt(end));
			list.add(str.charAt(end)+""+str.charAt(start));
			return list;				
		}

		ArrayList<String> list = permute(str, start, end-1);
		ArrayList<String> list_to_return = new ArrayList<String>();
		for(String st : list){
			char c = str.charAt(end);
			for(int i=0;i<=st.length();i++){ // for each string
				String s = st.substring(0,i) + c+st.substring(i);
				list_to_return.add(s);
			}
		}

		return list_to_return;

	}

	public static void main(String[] args){
		String s = "abcd";
		ArrayList<String> arr = permute(s, 0, s.length()-1);

		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}

	}
}