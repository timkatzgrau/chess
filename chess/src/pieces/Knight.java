package pieces;

import game.ChessBoard;

public class Knight extends Piece {
	
	public Knight (char type, char color) {
		
		this.type = type;
		this.color = color;
		numberOfMoves = 0;
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

}
