package pieces;

import game.ChessBoard;
import java.lang.*;

public abstract class Piece {
	
	public char type;
	
	public char color;
	
	public int numberOfMoves;
	
	public String position;
	
	public boolean canSkipOver;
	
	public abstract boolean canDoMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow);
	
	public static boolean isVertical(ChessBoard board, int startColumn,int startRow, int endColumn, int endRow,  boolean singleStep  ) {
		//Will need to check whether there are pieces in the way.
		if(startRow == endRow) {

			if(singleStep) {
				int diff = Math.abs(startColumn-endColumn);

				if(diff == 1) {
					return true;
				}else {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	public static boolean isHorizontal(ChessBoard board, int startColumn,int startRow, int endColumn, int endRow,  boolean singleStep  ) {
		//Will need to check whether there are pieces in the way.
		if(startRow == endRow) {
			if(singleStep) {
				int diff = Math.abs(startColumn-endColumn);
				if(diff == 1) {
					return true;
				}else {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	//Works only for bottom left right now
	public static boolean isDiagnal(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow, boolean singleStep)  {
		//Will need to check whether there are pieces in the way.
		int vertDirection = 0;
		int horDirection = 0;

		if(startColumn > endColumn) {
			horDirection = -1;
		}else if(startColumn < endColumn){
			horDirection = 1;
		}
		
		if(startRow < endRow) {
			vertDirection = -1;
		}else if(startColumn < endColumn){
			vertDirection = 1;
		}
		
		boolean diag = true;
		int tempx = startRow;
		int tempy = startColumn;
		
		
		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx++;
			tempy--;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else{
				diag = false;
			}
		}
		
		tempx = startRow;
		tempy = startColumn;
		diag = true;
		
		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx++;
			tempy++;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		tempx = startRow;
		tempy = startColumn;
		diag = true;

		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx--;
			tempy--;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		
		tempx = startRow;
		tempy = startColumn;
		diag = true;

		while(diag) {
			if(singleStep) {
				diag = false;
			}

			tempx--;
			tempy++;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		return false;
	}
	
	public String toString () {
		return "" + color + type;
	}
	
	

}
