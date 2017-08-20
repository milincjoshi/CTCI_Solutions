import java.util.*;

public class RobotGrid_2{
	
	public static boolean findPath(boolean[][] grid, int row, int column){		

		if(row < 0 || column < 0 || !grid[row][column]){
			return false;
		}

		boolean a = findPath(grid, row-1, column);
		boolean b = findPath(grid, row, column-1);

		if( (row == 0 && column==0) || a || b ){
			System.out.println(row+","+column);
			return true;
		}

		return false;
	}

	public static void main(String[] args){
		boolean[][] grid = new boolean[3][3];
		int row = 3;
		int column = 3;
		for(int i=0;i<row;i++){

			for(int j=0;j<column;j++){
				grid[i][j] = true;
			}
		}

		grid[1][1] = false;

		findPath(grid, 2,2);

	}
}