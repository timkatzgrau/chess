package pieces;

import game.ChessBoard;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will represent the Knight piece
 **/

public class Knight extends Piece {
	
	/**
	 * @param type
	 * a char to represent the type of piece this is
	 * @param color
	 * a char to represent the color for the team this piece is on
	 **/
	public Knight (char type, char color) {
		
		this.type = type;
		this.color = color;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		
		if(startColumn+2 == endColumn && startRow+1 == endRow || startColumn-2 == endColumn && startRow+1 == endRow || startColumn+2 == endColumn && startRow-1 == endRow || startColumn-2 == endColumn && startRow-1 == endRow) {
			return true;
		}
		if(startColumn+1 == endColumn && startRow+2 == endRow || startColumn-1 == endColumn && startRow+2 == endRow || startColumn+1 == endColumn && startRow-2 == endRow || startColumn-1 == endColumn && startRow-2 == endRow) {
			return true;
		}
		

		
		return false;
	}
public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, int x) {
		
		if(startColumn+2 == endColumn && startRow+1 == endRow || startColumn-2 == endColumn && startRow+1 == endRow || startColumn+2 == endColumn && startRow-1 == endRow || startColumn-2 == endColumn && startRow-1 == endRow) {
			return true;
		}
		if(startColumn+1 == endColumn && startRow+2 == endRow || startColumn-1 == endColumn && startRow+2 == endRow || startColumn+1 == endColumn && startRow-2 == endRow || startColumn-1 == endColumn && startRow-2 == endRow) {
			return true;
		}
		

		
		return false;
	}

}