public class SelectionSort{
	
	public static int[] selectionSort(int[] arr){

		for(int i=0;i<arr.length;i++){

			int min = i;

			for(int j=i;j<arr.length;j++){

				if(arr[j]<arr[min]){
					min = j;
				}
			}

			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}

	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");

		}
	}

	public static void main(String[] args){
		int[] arr = {3,1,6,9,4,5,7};
		arr = selectionSort(arr);	
		printArr(arr);

	}
}