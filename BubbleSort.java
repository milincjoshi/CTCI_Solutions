public class BubbleSort{
	
	public static int[] bubbleSort(int[] arr){

		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){

				if(arr[j]>arr[j+1]){
					int k  = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = k;
				}
			}
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
		arr = bubbleSort(arr);	
		printArr(arr);

	}
}