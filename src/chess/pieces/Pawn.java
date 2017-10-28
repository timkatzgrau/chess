package chess.pieces;

public class Pawn extends Piece {
	
	public Pawn (char type, char color) {
		
		this.type = type;
		this.color = color;
		numberOfMoves = 0;
		canSkipOver = false;
	}
	
	//MAKE SURE TO INCREMENT NUMBER OF MOVES WHEN MOVING PIECE

	@Override
	public boolean canDoMove(String curr, String fin, Piece[][] board) {
		
		int currFile = convertFile(curr.charAt(0));
		int currRank = convertRank(curr.charAt(1));
		
		int finFile = convertFile(fin.charAt(0));
		int finRank = convertRank(fin.charAt(1));
		
		int rankChange = Math.abs(finRank - currRank);
		int fileChange = Math.abs(finFile - currFile);
			
		if (rankChange == 1 && fileChange == 1 && board[finRank][finFile] != null && board[finRank][finFile].color != color) {
			return true;
		} else if (rankChange == 2 && numberOfMoves == 0 && board[finRank][finFile] == null && board[finRank-1][finFile] == null) {
			return true;
		} else if (rankChange == 1 && fileChange == 0 && board[finRank][finFile] == null) {
			return true;
		}
		
		return false;
	}

}
