public class MagicIndex_3{
	static int[] arr = {-1,1,3,4,5,7,9,12,13};

	public static Integer magicIndex(int[] array, int start, int end){
		
		if(start>end){
			return null;
		}

		int mid = (start+end)/2;
		
		if(array[mid] == mid){
			return mid;
		}
		else if(array[mid]<mid){
			return magicIndex(array, mid+1, end);
		}
		else{
			return magicIndex(array, start, mid-1);
		}
		


	}
	public static void main(String[] args){
		
		int i = magicIndex(arr, 0, arr.length-1);
		System.out.println(i);
	}
}