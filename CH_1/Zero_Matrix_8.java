/*
	In this problem, we use two arrays of boolean to store boolean
	of which rows and columns are zero and then set all those rows and columns to zero
*/

public class Zero_Matrix_8{
	
	static int rows = 5;
	static int columns = 3;
	static int[][] matr = new int[rows][columns];
	
	static boolean[] zero_rows = new boolean[rows];
	static boolean[] zero_columns = new boolean[columns];

	public static void zero_matrix(){


		for(int i=0; i<rows;i++){
			for(int j=0; j<columns;j++){
				if(matr[i][j] == 0){
					zero_rows[i] = true;
					zero_columns[j] = true;
				}
			}
		}
		
		for(int i=0; i<zero_rows.length;i++){
			//for all columns
			if(zero_rows[i] == true){
				for(int j = 0;j<columns;j++){
					matr[i][j] = 0;
				}			
			}
		}
		for(int i=0; i<zero_columns.length;i++){
			//for all columns
			if(zero_columns[i] == true){
				for(int j = 0;j<rows;j++){
					matr[j][i] = 0;
				}
			}
		}


	}

	public static void print_matrix(){
		
		System.out.println("New Matrix");
		for(int i=0; i<rows;i++){
			for(int j=0; j<columns;j++){
				System.out.print(matr[i][j]+" ");
			}
			System.out.println();
		}		
	}	
	public static void main(String[] args){
		for(int i=0; i<rows;i++){
			for(int j=0; j<columns;j++){
				matr[i][j] = i+j;
			}
		}

		print_matrix();
		zero_matrix();
		print_matrix();
	}
}