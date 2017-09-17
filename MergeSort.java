public class MergeSort{
	static int[] arr = {1,5,9,2,3,5,9,1,2,5,4,3,2,3,8,6};

	public static void mergeSort(int[] arr, int[] helper, int low, int high){
		if(low < high){
			
			int mid = (low+high)/2;
			mergeSort(arr, helper, low, mid);
			mergeSort(arr, helper, mid+1, high);
			merge(arr, helper, low, mid, high);
		}
	}
	public static void merge(int[] arr, int[] helper, int low, int mid, int high){

		//copy to helper that we want to sort
		for(int i=low;i<=high;i++){
			helper[i] = arr[i];
		}

		int helperLeft = low;
		int helperRight = mid+1;
		int cur = low;

		//iterate till one of the pointers end
		while(helperLeft<=mid && helperRight<= high){
			//compare
			if(helper[helperLeft]<=helper[helperRight]){
				arr[cur] = helper[helperLeft];
				helperLeft++;
			}
			else{
				arr[cur] = helper[helperRight];
				helperRight++;
			}
			cur++;
		}	

		/*if(helperLeft<mid){
			arr[cur] = helper[helperLeft];
			cur++;
			helperLeft++;
		}

		if(helperRight<high){
			arr[cur] = helper[helperRight];
			cur++;
			helperRight++;
		}*/

		//how does following work
		//do not copy right half as it is already there !!!
		int rem = mid - helperLeft;
		for(int i=0;i<=rem;i++){
			arr[cur+i] = helper[helperLeft+i];
		}

	}

	public static void printArr(){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}

	public static void main(String[] args){
		
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);

		printArr();

	}
}