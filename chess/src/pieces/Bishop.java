package pieces;

import game.ChessBoard;

public class Bishop extends Piece {
	
	public Bishop (char type, char color) {
		
		this.type = type;
		this.color = color;
		numberOfMoves = 0;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		if(isDiagnal(board, startColumn, startRow, endColumn, endRow, false)) {
			return true;
		}else {
			System.out.println("Invalid Move");
			return false;
		}
	}

}
