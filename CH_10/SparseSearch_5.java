public class SparseSearch_5{
	
	public static int sparseSearch(String[] arr, String str){

		int start = 0;
		int end = arr.length-1;

		while(start<=end){
			
			int mid = (start+end)/2;
			
			if(arr[mid].equals(str)){
				return mid;
			}

			int left = mid;
			int right = mid;

			while(arr[left].equals("")){
				left--;
			}

			while(arr[right].equals("")){
				right++;
			}

			if(str.equals(arr[left])){
				return left;
			}

			else if(str.equals(arr[right])){
				return right;
			}

			else if(str.compareTo(arr[left]) == -1){
				end = mid -1 ;
			}

			else if(str.compareTo(arr[right]) == 1){
				start = mid+1;
			}

		}

		return -1;

	}

	public static void main(String[] args){
		String[] arg = {"at","","","","","ball","","","","","","","","car","","","","dad","","","",};
		
		System.out.println(sparseSearch(arg, "at"));
		System.out.println(sparseSearch(arg, "ball"));
		System.out.println(sparseSearch(arg, "car"));
		System.out.println(sparseSearch(arg, "dad"));
	}
}