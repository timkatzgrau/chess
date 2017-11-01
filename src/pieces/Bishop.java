package pieces;

import game.ChessBoard;

public class Bishop extends Piece {
	
	public Bishop (char type, char color) {
		
		this.type = type;
		this.color = color;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		if(isDiagnal(board,startRow,startColumn,endRow,endColumn, false)) {
			return true;
		}else {
			System.out.println("Invalid Move for Bishop "+ color);
			return false;
		}
	}

}