package pieces;

import game.ChessBoard;

public class King extends Piece {
	
	public King (char type, char color) {
		
		this.type = type;
		this.color = color;
		numberOfMoves = 0;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		if(isHorizontal(board,startRow,startColumn,endRow,endColumn, true) || isVertical(board,startRow,startColumn,endRow,endColumn, true) || isDiagnal(board, startColumn, startRow, endColumn, endRow, true)) {
			return true;
		}else {
			System.out.println("Invalid Move");
			return false;
		}
	}

}
