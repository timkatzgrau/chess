package pieces;

import game.ChessBoard;
import java.lang.*;

public abstract class Piece {
	
	public char type;
	
	public char color;
	
	public boolean hasMoved = false;;
	
	public String position;
	
	public boolean canSkipOver;
	
	public abstract boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow);
	
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
				System.out.println("here");
				
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
				System.out.println("else");
				
				if (isPawn) {
					for (int i = startColumn-1; i >= endColumn; i--) {
						System.out.println(board.chessBoard[i][startRow]);
						if (board.chessBoard[i][startRow] != null) {
							return false;
						}
					}
				} else {
					for (int i = startColumn-1; i > endColumn; i--) {
						System.out.println(board.chessBoard[i][startRow]);
						if (board.chessBoard[i][startRow] != null) {
							return false;
						}
					}
				}
			}

			if(singleStep) {
				int diff = Math.abs(startColumn-endColumn);
				System.out.println("Diff: "+ diff);

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
	public static boolean isHorizontal(ChessBoard board, int startColumn,int startRow, int endColumn, int endRow,  boolean singleStep  ) {
		//Will need to check whether there are pieces in the way.
		System.out.println(startColumn);
		System.out.println(startRow);
		System.out.println(endColumn);
		System.out.println(endRow);
		
		
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
	//Works only for bottom left right now
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
		System.out.print("Gets here");;
		return false;
	}
	
	public String toString () {
		return "" + color + type;
	}
	
	

}