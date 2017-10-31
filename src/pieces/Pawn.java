package pieces;

import game.ChessBoard;

public class Pawn extends Piece {
	
	public Pawn (char type, char color) {
		
		this.type = type;
		this.color = color;
		numberOfMoves = 0;
		canSkipOver = false;
	}
	
	//MAKE SURE TO INCREMENT NUMBER OF MOVES WHEN MOVING PIECE

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		if(isVertical(board,startRow,startColumn,endRow,endColumn, true)) {
			return true;
		}else {
			System.out.println("Invalid Move for Pawn");
			return false;
		}
	}

}