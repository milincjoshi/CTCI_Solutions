public class SortedMerge_1{
	
	public static int[] sortedMerge(int[] arr1, int[] arr2){

		int indexB = arr2.length-1;
		int indexFiller = arr1.length-1;
		int indexA = indexFiller - indexB-1;

		while(indexB>=0){

			if(arr1[indexA]> arr2[indexB] ){
				arr1[indexFiller] = arr1[indexA];
				indexFiller--;
				indexA--;
			}
			else{
				arr1[indexFiller] = arr2[indexB];
				indexFiller--;
				indexB--;
			}
		}

		return arr1;

	} 
	public static void main(String[] args){

		int[] arr1 = new int[12];
		int[] arr2 = {2,4,7,10,12,15};
		
		arr1[0] = 1;
		arr1[1] = 3;
		arr1[2] = 5;
		arr1[3] = 6;
		arr1[4] = 8;
		arr1[5] = 9;
		
		int[] arr = sortedMerge(arr1, arr2);

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}					
	}
}