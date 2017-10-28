package pieces;

public abstract class Piece {
	
	public char type;
	
	public char color;
	
	public int numberOfMoves;
	
	public String position;
	
	public boolean canSkipOver;
	
	public abstract boolean canDoMove(String curr, String fin, Piece[][] board);
	
	public int convertFile (char file) {
		
		if (file == 'a') {
			return 0;
		} else if (file == 'b') {
			return 1;
		} else if (file == 'c') {
			return 2;
		} else if (file == 'd') {
			return 3;
		} else if (file == 'e') {
			return 4;
		} else if (file == 'f') {
			return 5;
		} else if (file == 'g') {
			return 6;
		} else if (file == 'h') {
			return 7;
		}
		
		return -1;
		
	}
	
	public int convertRank (char rank) {
		
		if (rank == '8') {
			return 0;
		} else if (rank == '7') {
			return 1;
		} else if (rank == '6') {
			return 2;
		} else if (rank == '5') {
			return 3;
		} else if (rank == '4') {
			return 4;
		} else if (rank == '3') {
			return 5;
		} else if (rank == '2') {
			return 6;
		} else if (rank == '1') {
			return 7;
		}
		
		return -1;
		
	}
	
	public char convertIndexToFile (int index) {
		if (index == 0) {
			return 'a';
		} else if (index == 1) {
			return 'b';
		} else if (index == 2) {
			return 'c';
		} else if (index == 3) {
			return 'd';
		} else if (index == 4) {
			return 'e';
		} else if (index == 5) {
			return 'f';
		} else if (index == 6) {
			return 'g';
		} else if (index == 7) {
			return 'h';
		}
		
		return '0';
	}
	
	public char convertIndexToRank (int index) {
		if (index == 0) {
			return '8';
		} else if (index == 1) {
			return '7';
		} else if (index == 2) {
			return '6';
		} else if (index == 3) {
			return '5';
		} else if (index == 4) {
			return '4';
		} else if (index == 5) {
			return '3';
		} else if (index == 6) {
			return '2';
		} else if (index == 7) {
			return '1';
		}
		
		return '0';
	}
	
	public String toString () {
		return "" + color + type;
	}
	
	

}
