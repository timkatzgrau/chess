package pieces;

import game.ChessBoard;

public class Queen extends Piece {
	
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


}