public class SearchRotated_3{
	
	public static int returnIndex(int[] arr, int i){
		int start = 0;
		int end = arr.length-1;

		while(start<=end){

			int mid = (start+end)/2;
			
			if(arr[mid] == i){
				return mid;
			}
			else if(arr[start] == i){
				return start;
			}
			else if(arr[end] == i){
				return end;
			}
			else if( arr[mid] < arr[end]  ){ 		// right half is normally sorted
				if( arr[mid]<i && i < arr[end]){
					start = mid+1;
				}
				else{
					end = mid-1;
				}
			}
			else if( arr[start] < arr[mid] ){ // right half is normally sorted
				if( arr[start]<i && i < arr[mid]){
					end = mid - 1;
				}
				else{
					start = mid+1;
				}
			}



		}

		return -1;
	}

	public static void main(String[] args){
		int[] arr = {19,20,25,1,3,4,5, 7,10,14, 15,16};

		for(int j=0;j<arr.length;j++){
			int i = returnIndex(arr, arr[j]);
			System.out.println(i);
			

		}

	}
}