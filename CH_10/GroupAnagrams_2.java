import java.util.*;

public class GroupAnagrams_2{
	public static HashMap<String, ArrayList<String>> groupAnagrams(ArrayList<String> arr){

		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

		for(String str : arr){
			
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = new String(chars);

			if(hashMap.containsKey(sortedStr)){
				ArrayList<String> list  = hashMap.get(sortedStr);
				list.add(str);
				hashMap.put(sortedStr, list);
			}
			else{
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				hashMap.put(sortedStr, list);				
			}
		}

		return hashMap;

	}
	public static void main(String[] args){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("hgj");
		list.add("atr");
		list.add("bac");
		list.add("gjh");
		list.add("rat");
		list.add("abc");
		
		HashMap<String, ArrayList<String>> hashMap = groupAnagrams(list);

		for(String str : hashMap.keySet()){
			ArrayList<String> l = hashMap.get(str);
			for(String s : l){
				System.out.print(s+",");
			}
			System.out.println();
		}
	}
}