
/*
	In this program we take 1st element of the top row and shift the rest of elements to left
	then we shift right column elements to 1 position upward
	then bottom row elements to right
	then left column elements to 1 position down
	
	Above process is repeated n/2 times for inner matrix

	and above whole process is repeated n-1 times as we need to rotate matrix by 90 degrees
*/
	
public class Rotate_Matrix_7{

	static int n = 3;
	static int[][] matr;
	public static void rotate_matrix(){

		
		for(int r = 0;r<n-1;r++){

			for(int i = 0; i<n/2;i++){

				int temp = matr[i][i];

				//top row
				for(int j=i;j<n-i-1;j++){
					matr[i][j] = matr[i][j+1];
				}

				//right column
				for(int j=i;j<n-i-1;j++){
					matr[j][n-1-i] = matr[j+1][n-1-i];
				}

				//bottom row
				for(int j=n-1-i;j>i;j--){
					matr[n-1-i][j] = matr[n-1-i][j-1];
				}

				//left column
				for(int j=n-1-i;j>i;j--){
					matr[j][i] = matr[j-1][i];
				}

				matr[i+1][i] = temp;

			}
		}


	
	}

	public static void print_matrix(){
		
		System.out.println("New Matrix");
		for(int i=0; i<n;i++){
			for(int j=0; j<n;j++){
				System.out.print(matr[i][j]+" ");
			}
			System.out.println();
		}		
	}	
	public static void main(String[] args){

		int c = 0;
		matr = new int[n][n];	
		for(int i=0; i<n;i++){
			for(int j=0; j<n;j++){
				matr[i][j] = c;
				c++;
			}
		}
		print_matrix();
		rotate_matrix();
		print_matrix();
			
	}
}