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
			System.out.println("Invalid Move for Pawn "+ color);
			return false;
		}
	}

}