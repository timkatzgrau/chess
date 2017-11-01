package pieces;

import game.ChessBoard;

public class King extends Piece {
	
	public King (char type, char color) {
		
		this.type = type;
		this.color = color;
	}

	@Override
	public boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow) {
		
		//change rows and columns to match others
		
		//attempting castle move
		//being blocked in game as attempting to take own piece
		//this is not fully implemented and working, pieces swapping is not there
		if (board.chessBoard[endRow][endColumn] != null && board.chessBoard[endRow][endColumn].type == 'N' && board.chessBoard[endRow][endColumn].color == color) {
			if (hasMoved == false && board.chessBoard[endRow][endColumn].hasMoved == false) {
				if (isHorizontal(board,startRow,startColumn,endRow,endColumn, false)) {
					return true;
				} else {
					System.out.println("Invalid castle first check");
					return false;
				}
			} else {
				System.out.println("Invalid castle second check");
				return false;
			}
		}
				
		if(isHorizontal(board,startRow,startColumn,endRow,endColumn, true) || isVertical(board,startRow,startColumn,endRow,endColumn, true) || isDiagnal(board,startRow,startColumn,endRow,endColumn, true)) {
			return true;
		}else {
			System.out.println("Invalid Move for king "+ color);
			return false;
		}
	}

}