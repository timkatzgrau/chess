package pieces;

public class Queen extends Piece {
	
	public Queen (char type, char color) {
		
		this.type = type;
		this.color = color;
		numberOfMoves = 0;
	}

	@Override
	public boolean canDoMove(String curr, String fin, Piece[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

}
