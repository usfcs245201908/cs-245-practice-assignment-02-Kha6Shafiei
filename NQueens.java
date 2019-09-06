public class NQueens{

	public int [][] board;
	public int n;
	public int row;
	public int col;
	

	public NQueens(int n){
		this.n = n;
		this.board = new int [n][n];
	}

	public boolean placeNQueens(){

		if (this.n <= 0){
			throw new IllegalArgumentException ("N can't be smaller than zero.");
		}
		 return placeNQueens(this.col);
	}

	public boolean placeNQueens(int col){

		if(col == this.n ) {
			return true;
		}
		
		for(int i = 0; i < this.n ; i++){
			if(CanQueenbeThere(i,col)){
				this.board[i][col] = 1;
				if(placeNQueens(col + 1)){ 
					printToConsole();
					return true;
				}
				this.board[i][col] = 0;
			}

		}

		return false;
}
	
	private boolean CanQueenbeThere(int row, int col){

		int i,j;
        for(i = 0; i < col ; i++){
            if (board[row][i]==1) return false;
        }
        for( i = row, j = col;(i >= 0) && (j >=0 ); i--,j--){
            if (board[i][j]==1) return false;
        }
        for(i = row, j = col ;(j >=0 ) && (i < this.n); i++,j--){
            if (board[i][j]==1) return false;
        }
        return true;
    }

	public void printToConsole(){

		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n; j++){
				if(this.board[i][j] == 1){
					System.out.print("Q ");
				}else{
					System.out.print("_ ");

				}
			}

			System.out.println();
		}
		System.out.println("\n");

	}

	
}
	




	
