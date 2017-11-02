package pieces;

import game.ChessBoard;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will represent the King piece
 **/

public class King extends Piece {
	
	/**
	 * @param type
	 * a char to represent the type of piece this is
	 * @param color
	 * a char to represent the color for the team this piece is on
	 **/
	public King (char type, char color) {
		
		this.type = type;
		this.color = color;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		
		//change rows and columns to match others
		//attempting castle move
		//being blocked in game as attempting to take own piece
		//this is not fully implemented and working, pieces swapping is not there
		if (board.chessBoard[endRow][endColumn] != null && board.chessBoard[endRow][endColumn].type == 'R' && board.chessBoard[endRow][endColumn].color == color) {
			if(color == 'b' && board.isInCheck() == 2) {
				return false;
			}else if( color == 'w' && board.isInCheck() == 1) {
				return false;
			}
			if (hasMoved == false && board.chessBoard[endRow][endColumn].hasMoved == false) {
				
				if (isHorizontal(board,startRow,startColumn,endRow,endColumn, false)) {
					System.out.println("looks good here");
					
					if(board.chessBoard[endRow][endColumn].hasMoved == false && board.chessBoard[startRow][startColumn].hasMoved == false ) {
						return true;
					}else {
						return false;
					}
				} else {
					System.out.println("Invalid castle first check");
					return false;
				}
			} else {
				System.out.println("Invalid castle second check");
				return false;
			}
		}
				
		if(isHorizontal(board,startRow,startColumn,endRow,endColumn, true) || isVertical(board,startRow,startColumn,endRow,endColumn, true) || isDiagnal(board,startRow,startColumn,endRow,endColumn, true)) {
			return true;
		}else {
			System.out.println("Invalid Move for king "+ color);
			return false;
		}
	}
public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, int x) {
		
		//change rows and columns to match others
		//attempting castle move
		//being blocked in game as attempting to take own piece
		//this is not fully implemented and working, pieces swapping is not there
		if (board.chessBoard[endRow][endColumn] != null && board.chessBoard[endRow][endColumn].type == 'R' && board.chessBoard[endRow][endColumn].color == color) {
			if(color == 'b' && board.isInCheck() == 2) {
				return false;
			}else if( color == 'w' && board.isInCheck() == 1) {
				return false;
			}
			if (hasMoved == false && board.chessBoard[endRow][endColumn].hasMoved == false) {
				
				if (isHorizontal(board,startRow,startColumn,endRow,endColumn, false)) {
					System.out.println("looks good here");
					
					if(board.chessBoard[endRow][endColumn].hasMoved == false && board.chessBoard[startRow][startColumn].hasMoved == false ) {
						return true;
					}else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
				
		if(isHorizontal(board,startRow,startColumn,endRow,endColumn, true) || isVertical(board,startRow,startColumn,endRow,endColumn, true) || isDiagnal(board,startRow,startColumn,endRow,endColumn, true)) {
			return true;
		}else {
			return false;
		}
	}
	

}