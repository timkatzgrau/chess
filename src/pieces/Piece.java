package pieces;

import game.ChessBoard;
import java.lang.*;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will represent the Piece superclass that other pieces are based off of
 **/

public abstract class Piece {
	
	/**
	 * a character used to denote the type of piece the piece is
	 **/
	public char type;
	
	/**
	 * a character used to represent the color for the team this piece is on
	 **/
	public char color;
	
	/**
	 * a boolean specifying whether this piece jumped 2 spaces
	 **/
	public boolean doubleFlag = false;
	
	/**
	 * a character used to represent the color for the team this piece is on
	 **/
	public boolean hasMoved = false;;
	
	/**
	 * a String used to mark the position of the piece
	 **/
	public String position;
	
	/**
	 * a boolean specifying whether this piece can jump over others or not
	 **/
	public boolean canSkipOver;
	
	/**
	 * @param board
	 * the chess board that is being used to play
	 * @param startColumn
	 * index for the column the piece is starting at
	 * @param startRow
	 * index for the row the piece is starting at
	 * @param endColumn
	 * index for the column the piece is ending at
	 * @param endRow
	 * index for the row the piece is ending at
	 * @return whether the move can occur
	 **/
	public abstract boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow);
	public abstract boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, int x);
	
	/**
	 * @param board
	 * the chess board that is being used to play
	 * @param startColumn
	 * index for the column the piece is starting at
	 * @param startRow
	 * index for the row the piece is starting at
	 * @param endColumn
	 * index for the column the piece is ending at
	 * @param endRow
	 * index for the row the piece is ending at
	 * @param singleStep
	 * whether the piece can only move one piece at a time or not
	 * @return whether the move is valid
	 **/
	public static boolean isVertical(ChessBoard board, int startColumn,int startRow, int endColumn, int endRow,  boolean singleStep  ) {
		//Will need to check whether there are pieces in the way.
		
		boolean isPawn = false;
		
		if (board.chessBoard[startColumn][startRow] != null) {
			if (board.chessBoard[startColumn][startRow].type == 'p') {
				isPawn = true;
			}
		}
		
		if(startRow == endRow) {
			
			//SHOULD IT BE <= or just <? How do different pieces capture pieces, probably < since a piece other than pawns can capture this way
			//I think pawns may change whether it is < or <=
			//if its a pawn it needs to check all the way because it only takes diagonal, but another piece may take the one it lands on but this would return false when its checking
			//since it wouldnt be null
			if (startColumn < endColumn) {
				
				if (isPawn) {
					for (int i = startColumn+1; i <= endColumn; i++) {
						if (board.chessBoard[i][startRow] != null) {
							return false;
						}
					}
					
				} else {
					for (int i = startColumn+1; i < endColumn; i++) {
						if (board.chessBoard[i][startRow] != null) {
							return false;
						}
					}
				}
			} else if (startColumn > endColumn) {
				
				if (isPawn) {
					for (int i = startColumn-1; i >= endColumn; i--) {
						if (board.chessBoard[i][startRow] != null) {
							return false;
						}
					}
				} else {
					for (int i = startColumn-1; i > endColumn; i--) {
						if (board.chessBoard[i][startRow] != null) {
							return false;
						}
					}
				}
			}

			if(singleStep) {
				int diff = Math.abs(startColumn-endColumn);


				if(diff == 1) {
					if(board.chessBoard[startColumn][startRow] != null) {
						board.chessBoard[startColumn][startRow].hasMoved = true;				
					}
					board.chessBoard[startColumn][startRow].doubleFlag = false;
					
					
					return true;
					
					
					
				}else {
					if(isPawn) {
						if(diff == 2 && board.chessBoard[startColumn][startRow].hasMoved == false) {
							board.chessBoard[startColumn][startRow].hasMoved = true;
							board.chessBoard[startColumn][startRow].doubleFlag = true;
							if(board.chessBoard[startColumn][startRow].color != 'w') {
								board.whiteEnpass = true;
							}else {
								board.blackEnpass = true;
							}
							return true;
						}
					}
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * @param board
	 * the chess board that is being used to play
	 * @param startColumn
	 * index for the column the piece is starting at
	 * @param startRow
	 * index for the row the piece is starting at
	 * @param endColumn
	 * index for the column the piece is ending at
	 * @param endRow
	 * index for the row the piece is ending at
	 * @param singleStep
	 * whether the piece can only move one piece at a time or not
	 * @return whether the move is valid
	 **/
	public static boolean isHorizontal(ChessBoard board, int startColumn,int startRow, int endColumn, int endRow,  boolean singleStep  ) {
		//Will need to check whether there are pieces in the way.

		
		if(startColumn == endColumn) {
			
			//SHOULD IT BE <= or just <? How do different pieces capture pieces, probably < since a piece other than pawns can capture this way
			//I think pawns may change whether it is < or <=
			if (startRow < endRow) {
				for (int i = startRow+1; i < endRow; i++) {
					if (board.chessBoard[startColumn][i] != null) {
						return false;
					}
				}
			} else if (startRow > endRow) {
				for (int i = startRow-1; i > endRow; i--) {
					if (board.chessBoard[startColumn][i] != null) {
						return false;
					}
				}
			}
			
			if(singleStep) {
				int diff = Math.abs(startRow - endRow);
				if(diff == 1) {
					return true;
				}else {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * @param board
	 * the chess board that is being used to play
	 * @param startColumn
	 * index for the column the piece is starting at
	 * @param startRow
	 * index for the row the piece is starting at
	 * @param endColumn
	 * index for the column the piece is ending at
	 * @param endRow
	 * index for the row the piece is ending at
	 * @param singleStep
	 * whether the piece can only move one piece at a time or not
	 * @return whether the move is valid
	 **/
	public static boolean isDiagnal(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, boolean singleStep)  {
		//Will need to check whether there are pieces in the way.
		int vertDirection = 0;
		int horDirection = 0;

		if(startColumn > endColumn) {
			vertDirection = -1;
		}else if(startColumn < endColumn){
			vertDirection = 1;
		}
		
		if(startRow < endRow) {
			horDirection = 1;
		}else if(startRow > endRow){
			horDirection = -1;
		}
		
		if (horDirection == 1 && vertDirection == 1){
			
			int tempColumn = startColumn + 1;
			int tempRow = startRow + 1;
			
			while (tempColumn < endColumn && tempRow < endRow) {
				if (board.chessBoard[tempColumn][tempRow] != null) {
					return false;
				}
				tempColumn++;
				tempRow++;
			}
			
			
		} else if (horDirection == 1 && vertDirection == -1) {
			
			int tempColumn = startColumn - 1;
			int tempRow = startRow + 1;
			
			while (tempColumn > endColumn && tempRow < endRow) {
				if (board.chessBoard[tempColumn][tempRow] != null) {
					return false;
				}
				
				tempColumn--;
				tempRow++;
			}
			
			
		} else if (horDirection == -1 && vertDirection == 1) {
			int tempColumn = startColumn + 1;
			int tempRow = startRow - 1;
			
			while (tempColumn < endColumn && tempRow > endRow) {
				if (board.chessBoard[tempColumn][tempRow] != null) {
					return false;
				}
				
				tempColumn++;
				tempRow--;
			}
			
		} else if (horDirection == -1 && vertDirection == -1) {
			int tempColumn = startColumn - 1;
			int tempRow = startRow - 1;
			
			while (tempColumn > endColumn && tempRow > endRow) {
				if (board.chessBoard[tempColumn][tempRow] != null) {
					return false;
				}
				tempColumn--;
				tempRow--;
			}
		}
		
		
		boolean diag = true;
		int tempx = startRow;
		int tempy = startColumn;
		
		
		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx++;
			tempy--;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else{
				diag = false;
			}
		}
		
		tempx = startRow;
		tempy = startColumn;
		diag = true;
		
		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx++;
			tempy++;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		tempx = startRow;
		tempy = startColumn;
		diag = true;

		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx--;
			tempy--;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		
		tempx = startRow;
		tempy = startColumn;
		diag = true;

		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx--;
			tempy++;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		return false;
	}
	
	/**
	 * @return a String representation of the piece for display purposes
	 **/
	public String toString () {
		return "" + color + type;
	}
	
	

}