package pieces;

public abstract class Piece {
	
	public char type;
	
	public char color;
	
	public int numberOfMoves;
	
	public String position;
	
	public boolean canSkipOver;
	
	public abstract boolean canDoMove(String curr, String fin, Piece[][] board);
	

	
	public String toString () {
		return "" + color + type;
	}
	
	

}
