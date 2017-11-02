package pieces;

import game.ChessBoard;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will represent the Pawn piece
 **/

public class Pawn extends Piece {
	
	/**
	 * @param type
	 * a char to represent the type of piece this is
	 * @param color
	 * a char to represent the color for the team this piece is on
	 **/
	public Pawn (char type, char color) {
		
		this.type = type;
		this.color = color;
		this.doubleFlag = false;
	}
	
	//MAKE SURE TO INCREMENT NUMBER OF MOVES WHEN MOVING PIECE

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		if(isVertical(board,startRow,startColumn,endRow,endColumn, true)) {
			if(color == 'b') {
				if(startRow < endRow) {
					return true;
				}else {
					return false;
				}
			}else {
				if(endRow < startRow) {
					return true;
				}else {
					return false;
				}
			}
		}else if(board.chessBoard[endRow][endColumn] != null && isDiagnal(board,startRow,startColumn,endRow,endColumn, true) && board.chessBoard[endRow][endColumn].color != color){
			if(color == 'b') {
				if(startRow < endRow) {
					return true;
				}else {
					return false;
				}
			}else {
				if(endRow < startRow) {
					return true;
				}else {
					return false;
				}
			}
		}else {

			if(isDiagnal(board,startRow,startColumn,endRow,endColumn, true) && board.chessBoard[startRow][startColumn].doubleFlag ) {
				
				if(color == 'b') {
					if(board.chessBoard[startRow][endColumn] != null && board.chessBoard[startRow][endColumn].color == 'w' && board.blackEnpass) {
						board.chessBoard[startRow][endColumn] = null;
						
						return true;
					} 
				}else {
					if(board.chessBoard[startRow][endColumn] != null && board.chessBoard[startRow][endColumn].color == 'b' && board.whiteEnpass) {
						board.chessBoard[startRow][endColumn] = null;
						return true;
					} 
				}
			System.out.println("Invalid Move for Pawn "+ color);
			return false;
		}
	}
		return false;
	}
	
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, int x) {
		if(isVertical(board,startRow,startColumn,endRow,endColumn, true)) {
			if(color == 'b') {
				if(startRow < endRow) {
					return true;
				}else {
					return false;
				}
			}else {
				if(endRow < startRow) {
					return true;
				}else {
					return false;
				}
			}
		}else if(board.chessBoard[endRow][endColumn] != null && isDiagnal(board,startRow,startColumn,endRow,endColumn, true) && board.chessBoard[endRow][endColumn].color != color){
			if(color == 'b') {
				if(startRow < endRow) {
					return true;
				}else {
					return false;
				}
			}else {
				if(endRow < startRow) {
					return true;
				}else {
					return false;
				}
			}
		}else {

			if(isDiagnal(board,startRow,startColumn,endRow,endColumn, true) && board.chessBoard[startRow][startColumn].doubleFlag ) {
				
				if(color == 'b') {
					if(board.chessBoard[startRow][endColumn] != null && board.chessBoard[startRow][endColumn].color == 'w' && board.blackEnpass) {
						board.chessBoard[startRow][endColumn] = null;
						
						return true;
					} 
				}else {
					if(board.chessBoard[startRow][endColumn] != null && board.chessBoard[startRow][endColumn].color == 'b' && board.whiteEnpass) {
						board.chessBoard[startRow][endColumn] = null;
						return true;
					} 
				}
			return false;
		}
	}
		return false;
	}
}

