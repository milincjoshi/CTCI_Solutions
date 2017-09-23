public class QuickSort{
		public static void quickSort(int[] arr, int left, int right){

		int index = partition(arr, left, right);

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();

		if(left< index-1){
			quickSort(arr, left, index-1);
		}
		if(index< right){
			quickSort(arr, index, right);
		}
			
	}
	public static int partition(int[] arr, int left, int right){
		int pivot = (left+right)/2;

		while(left<=right){
			while(arr[left]<arr[pivot]){
				left++;
			}
			while(arr[right]>arr[pivot]){
				right--;
			}

			if(left<=right)
			{
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}	
		}

		return left;
	}
	
	public static int partition1(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
 
	public static void quickSort1(int arr[], int left, int right) {
	      int index = partition1(arr, left, right);
	      if (left < index - 1)
	            quickSort1(arr, left, index - 1);
	      if (index < right)
	            quickSort1(arr, index, right);
	}

	static int[] arr = {6,2,7,9,1,3,0};

	public static void main(String[] args){
		quickSort(arr, 0, arr.length-1);

		System.out.println("ans");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}

		quickSort1(arr, 0, arr.length-1);

		System.out.println("ans");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}

	}

}