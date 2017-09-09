import java.util.*;

public class PowerSet_4{
	
	static ArrayList<Integer> arr;
	
	public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> arr){
		
		if(arr.size()<=1){
			ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> sub_x = new ArrayList<Integer>();

			sub_x.add(arr.get(0));
			x.add(sub_x);
			return x;
		}
		
		ArrayList<Integer> sub_arr = new ArrayList<Integer>();

		for(int i=0;i<arr.size()-2;i++){
			sub_arr.add(arr.get(i));
		}

		ArrayList<ArrayList<Integer>> sub_sets = getSubSets(sub_arr);

		ArrayList<ArrayList<Integer>> new_sub_sets = new ArrayList<ArrayList<Integer>>();
		
		for(ArrayList<Integer> set : sub_sets){
			new_sub_sets.add(set);
		}

		for(ArrayList<Integer> set : sub_sets){
			set.add(arr.get(arr.size()-1));
			new_sub_sets.add(set);
		}

		return new_sub_sets;
		
	}

	

	public static void main(String[] args){
		
		arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);


		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for(int i=0;i<arr.size();i++){
			int x = arr.get(i);

			if(i == 0){
				ArrayList<Integer> sarr = new ArrayList<Integer>();
				sarr.add(x);

				list.add(sarr);
			}
			else{

				ArrayList<ArrayList<Integer>> das = new ArrayList<ArrayList<Integer>>();

				for(ArrayList<Integer> arrList : list){
					arrList.add(x);
					das.add(arrList);
				}


				for(ArrayList<Integer> arrList : das){
					list.add(arrList);
				}
			}
				
		}

		ArrayList<ArrayList<Integer>> sub_sets = list;

		for(ArrayList<Integer> set : sub_sets){
			System.out.print("[");
			for(Integer x : set){
				System.out.print(x+",");
			}
			System.out.print("]");
			System.out.println();
		}
			
	}
		
}