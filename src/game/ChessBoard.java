package game;


import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will handle creating and maintaining the chess board
 **/

public class ChessBoard {
	
	/**
	 * the game board
	 **/
	public Piece[][] chessBoard = new Piece[8][8];
	
	public boolean whiteEnpass = false;
	public boolean blackEnpass = false;
	
	/**
	 * whether or not the game has seen a checkmate
	 **/
	public boolean checkmate = false;
	
	/**
	 * whether or not it is white's turn to make a move
	 **/
	public boolean whitesTurn = true;
	
	/**
	 * @param file
	 * the file for a space on the board
	 * @return the index for the file in the array
	 **/
	public int convertFile (char file) {
		
		if (file == 'a') {
			return 0;
		} else if (file == 'b') {
			return 1;
		} else if (file == 'c') {
			return 2;
		} else if (file == 'd') {
			return 3;
		} else if (file == 'e') {
			return 4;
		} else if (file == 'f') {
			return 5;
		} else if (file == 'g') {
			return 6;
		} else if (file == 'h') {
			return 7;
		}
		
		return -1;
		
	}
	
	/**
	 * @param rank
	 * the rank for a space on the board
	 * @return the index for the rank in the array
	 **/
	public int convertRank (char rank) {
		
		if (rank == '8') {
			return 0;
		} else if (rank == '7') {
			return 1;
		} else if (rank == '6') {
			return 2;
		} else if (rank == '5') {
			return 3;
		} else if (rank == '4') {
			return 4;
		} else if (rank == '3') {
			return 5;
		} else if (rank == '2') {
			return 6;
		} else if (rank == '1') {
			return 7;
		}
		
		return -1;
		
	}
	
	/**
	 * @param index
	 * the index for a file in the array
	 * @return the file for a space on the board
	 **/
	public char convertIndexToFile (int index) {
		
		if (index == 0) {
			return 'a';
		} else if (index == 1) {
			return 'b';
		} else if (index == 2) {
			return 'c';
		} else if (index == 3) {
			return 'd';
		} else if (index == 4) {
			return 'e';
		} else if (index == 5) {
			return 'f';
		} else if (index == 6) {
			return 'g';
		} else if (index == 7) {
			return 'h';
		}
		
		
		return '0';
	}
	
	/**
	 * @param index
	 * the index for a rank in the array
	 * @return the rank for a space on the board
	 **/
	public char convertIndexToRank (int index) {
		if (index == 0) {
			return '8';
		} else if (index == 1) {
			return '7';
		} else if (index == 2) {
			return '6';
		} else if (index == 3) {
			return '5';
		} else if (index == 4) {
			return '4';
		} else if (index == 5) {
			return '3';
		} else if (index == 6) {
			return '2';
		} else if (index == 7) {
			return '1';
		}
		
		return '0';
	}
	
	/**
	 * constructor for the chess board to initialize the board for the start of the game
	 **/
	public ChessBoard () {
		chessBoard[0][0] = new Rook('R', 'b');
		chessBoard[0][1] = new Knight('N', 'b');
		chessBoard[0][2] = new Bishop('B', 'b');
		chessBoard[0][3] = new Queen('Q', 'b');
		chessBoard[0][4] = new King('K', 'b');
		chessBoard[0][5] = new Bishop('B', 'b');
		chessBoard[0][6] = new Knight('N', 'b');
		chessBoard[0][7] = new Rook('R', 'b');
		
		chessBoard[1][0] = new Pawn('p', 'b');
		chessBoard[1][1] = new Pawn('p', 'b');
		chessBoard[1][2] = new Pawn('p', 'b');
		chessBoard[1][3] = new Pawn('p', 'b');
		chessBoard[1][4] = new Pawn('p', 'b');
		chessBoard[1][5] = new Pawn('p', 'b');
		chessBoard[1][6] = new Pawn('p', 'b');
		chessBoard[1][7] = new Pawn('p', 'b');
		
		chessBoard[7][0] = new Rook('R', 'w');
		chessBoard[7][1] = new Knight('N', 'w');
		chessBoard[7][2] = new Bishop('B', 'w');
		chessBoard[7][3] = new Queen('Q', 'w');
		chessBoard[7][4] = new King('K', 'w');
		chessBoard[7][5] = new Bishop('B', 'w');
		chessBoard[7][6] = new Knight('N', 'w');
		chessBoard[7][7] = new Rook('R', 'w');
		
		chessBoard[6][0] = new Pawn('p', 'w');
		chessBoard[6][1] = new Pawn('p', 'w');
		chessBoard[6][2] = new Pawn('p', 'w');
		chessBoard[6][3] = new Pawn('p', 'w');
		chessBoard[6][4] = new Pawn('p', 'w');
		chessBoard[6][5] = new Pawn('p', 'w');
		chessBoard[6][6] = new Pawn('p', 'w');
		chessBoard[6][7] = new Pawn('p', 'w');
	}
	public ChessBoard (int test) {


		chessBoard[0][3] = new Queen('Q', 'b');
		chessBoard[0][4] = new King('K', 'b');

		chessBoard[1][0] = new Pawn('p', 'b');
		chessBoard[6][1] = new Pawn('p', 'b');
		chessBoard[1][2] = new Pawn('p', 'b');
		chessBoard[1][3] = new Pawn('p', 'b');
		chessBoard[1][4] = new Pawn('p', 'b');
		chessBoard[1][5] = new Pawn('p', 'b');
		chessBoard[1][6] = new Pawn('p', 'b');
		chessBoard[1][7] = new Pawn('p', 'b');
		

		chessBoard[7][3] = new Queen('Q', 'w');
		chessBoard[7][4] = new King('K', 'w');

		
		chessBoard[6][0] = new Pawn('p', 'w');
		chessBoard[1][1] = new Pawn('p', 'w');
		chessBoard[6][2] = new Pawn('p', 'w');
		chessBoard[6][3] = new Pawn('p', 'w');
		chessBoard[6][4] = new Pawn('p', 'w');
		chessBoard[6][5] = new Pawn('p', 'w');
		chessBoard[6][6] = new Pawn('p', 'w');
		chessBoard[6][7] = new Pawn('p', 'w');


	}
	
	/**
	 * displays the current status of the board to the user
	 **/
	public void showChessBoard () {
		for (int row = 0; row < chessBoard.length; row++) {
			for (int column = 0; column < chessBoard[row].length; column++) {
				if (chessBoard[row][column] == null && row % 2 == 0 && column % 2 == 0) {
					System.out.print("  " + " ");
				} else if (chessBoard[row][column] == null && row % 2 == 0 && column % 2 != 0) {
					System.out.print("##" + " ");
				} else if (chessBoard[row][column] == null && row % 2 != 0 && column % 2 == 0) {
					System.out.print("##" + " ");
				} else if (chessBoard[row][column] == null && row % 2 != 0 && column % 2 != 0) {
					System.out.print("  " + " ");
				} else {
					System.out.print(chessBoard[row][column] + " ");
				}
			}
			System.out.println(8-row + "");
		}
		System.out.println("a  b  c  d  e  f  g  h");
	}
	

	/**
	 * @param rowIndex
	 * the row index for the pawn to be promoted
	 * @param columnIndex
	 * the column index for the pawn to be promoted
	 * @param newPiece
	 * the piece that the pawn should be promoted to
	 **/
	public void promote(int rowIndex, int columnIndex, char newPiece) {
		char color = 'w';
		
		if (!whitesTurn) {
			color = 'b';
		}
		
		if (newPiece == 'q') {
			chessBoard[rowIndex][columnIndex] = new Queen('Q', color);
		} else if (newPiece == 'b') {
			chessBoard[rowIndex][columnIndex] = new Bishop('B', color);
		} else if (newPiece == 'n') {
			chessBoard[rowIndex][columnIndex] = new Knight('N', color);
		} else if (newPiece == 'r') {
			chessBoard[rowIndex][columnIndex] = new Rook('R', color);
		}
		
}
	
	/**
	 * @return whether or not check mate is found
	 **/
	public boolean isCheckMate(){
		
		 for(int x = 0; x <= 7; x++){
		        for(int y = 0; y <= 7; y++){
		            if(chessBoard[x][y] != null){
		            	 for(int a = 0; a <= 7; a++){
		     		        for(int b = 0; b <= 7; b++){
		     		        	if(chessBoard[x][y] == null) {
		     		        		continue;
		     		        	}else if(chessBoard[a][b] != null) {
		     		        		if (chessBoard[x][y].color == chessBoard[a][b].color) {
		     		        			continue;
		     		        		}
		     		        	}
		     		        	if(((chessBoard[x][y].color == 'w' && this.whitesTurn == true)||(chessBoard[x][y].color == 'b' && this.whitesTurn == false))  && chessBoard[x][y].canDoMove(this, y, x, b, a, 1)){
		     		        				Piece temp = this.chessBoard[a][b];
										this.chessBoard[a][b] = this.chessBoard[x][y];	
										this.chessBoard[x][y] = null;
										int check = this.isInCheck();
										if(check == 1 || check == 2) {

											this.chessBoard[x][y] = this.chessBoard[a][b];
											this.chessBoard[a][b] = temp;
										}else {
											if(this.chessBoard[a][b] != null) {
												this.chessBoard[x][y] = this.chessBoard[a][b];
												this.chessBoard[a][b] = temp;
												return false;
												
											}else {
												this.chessBoard[x][y] = this.chessBoard[a][b];
												this.chessBoard[a][b] = temp;
											}
											
										}
		     		        		}
		     		        }
		     		    }
		            }
		        }
		    }
		 System.out.println("---");
		System.out.println("CHECKMATE!");
	    return true;
	}
	
	/**
	 * @return 0 for not in check, 1 for white in check, 2 for black in check
	 **/
	public int isInCheck(){
		
		int blackRow = 0;
		int blackCol = 0;
		int whiteRow = 0;
		int whiteCol = 0;

		 for(int x = 0; x <= 7; x++){
		        for(int y = 0; y <= 7; y++){
		            if(chessBoard[x][y] != null){
		                if(chessBoard[x][y].type == 'K'){
		                		if(chessBoard[x][y].color == 'b') {
		                			blackRow = x;
		                			blackCol = y;
		                		}else {
		                			whiteRow = x;
		                			whiteCol = y;
			                }
		                }
		            }
		        }
		    }
	    for(int x = 0; x <= 7; x++){
	        for(int y = 0; y <= 7; y++){
	            if(chessBoard[x][y] != null){

	            		if(chessBoard[x][y].color == 'b') {
	            			if(chessBoard[x][y].canDoMove(this, y,x, whiteCol, whiteRow,1) ){
	            				
	            				System.out.print("White is in Check");
	            				return 1;
	    	                }	
	            		}else {
	            			if(chessBoard[x][y].canDoMove(this, y,x, blackCol, blackRow,1)){
	            				 System.out.print("Black is in Check");
	            				return 2;
	    	                }	
	            		}
	                
	            }
	        }
	    }
	
	    return 0;
	}
}