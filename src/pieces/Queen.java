package pieces;

import game.ChessBoard;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will represent the Queen piece
 **/

public class Queen extends Piece {
	
	/**
	 * @param type
	 * a char to represent the type of piece this is
	 * @param color
	 * a char to represent the color for the team this piece is on
	 **/
	public Queen (char type, char color) {
		
		this.type = type;
		this.color = color;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		
		
		if(isHorizontal(board,startRow,startColumn,endRow,endColumn, false) || isVertical(board,startRow,startColumn,endRow,endColumn, false) || isDiagnal(board,startRow,startColumn,endRow,endColumn, false)) {
			return true;
		}else {
			System.out.println("Invalid Move for Queen "+ color);
			return false;
		}
	}
public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, int x) {
		
		
		if(isHorizontal(board,startRow,startColumn,endRow,endColumn, false) || isVertical(board,startRow,startColumn,endRow,endColumn, false) || isDiagnal(board,startRow,startColumn,endRow,endColumn, false)) {
			return true;
		}else {
			return false;
		}
	}


}