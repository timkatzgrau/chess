package game;


import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class ChessBoard {
	
	public Piece[][] chessBoard = new Piece[8][8];
	
	public boolean checkmate = false;
	public boolean whitesTurn = true;
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
	public ChessBoard () {
		chessBoard[0][0] = new Rook('R', 'b');
		chessBoard[0][1] = new Knight('N', 'b');
		chessBoard[0][2] = new Bishop('B', 'b');
		chessBoard[0][3] = new Queen('Q', 'b');
		chessBoard[0][4] = new King('K', 'b');
		chessBoard[0][5] = new Bishop('B', 'b');
		chessBoard[0][6] = new Knight('N', 'b');
		chessBoard[0][7] = new Rook('R', 'b');
		
		chessBoard[1][0] = new Pawn('p', 'b');
		chessBoard[1][1] = new Pawn('p', 'b');
		chessBoard[1][2] = new Pawn('p', 'b');
		chessBoard[1][3] = new Pawn('p', 'b');
		chessBoard[1][4] = new Pawn('p', 'b');
		chessBoard[1][5] = new Pawn('p', 'b');
		chessBoard[1][6] = new Pawn('p', 'b');
		chessBoard[1][7] = new Pawn('p', 'b');
		
		chessBoard[7][0] = new Rook('R', 'w');
		chessBoard[7][1] = new Knight('N', 'w');
		chessBoard[7][2] = new Bishop('B', 'w');
		chessBoard[7][3] = new Queen('Q', 'w');
		chessBoard[7][4] = new King('K', 'w');
		chessBoard[7][5] = new Bishop('B', 'w');
		chessBoard[7][6] = new Knight('N', 'w');
		chessBoard[7][7] = new Rook('R', 'w');
		
		chessBoard[6][0] = new Pawn('p', 'w');
		chessBoard[6][1] = new Pawn('p', 'w');
		chessBoard[6][2] = new Pawn('p', 'w');
		chessBoard[6][3] = new Pawn('p', 'w');
		chessBoard[6][4] = new Pawn('p', 'w');
		chessBoard[6][5] = new Pawn('p', 'w');
		chessBoard[6][6] = new Pawn('p', 'w');
		chessBoard[6][7] = new Pawn('p', 'w');
	}
	
	public void showChessBoard () {
		for (int row = 0; row < chessBoard.length; row++) {
			for (int column = 0; column < chessBoard[row].length; column++) {
				if (chessBoard[row][column] == null && row % 2 == 0 && column % 2 == 0) {
					System.out.print("  " + " ");
				} else if (chessBoard[row][column] == null && row % 2 == 0 && column % 2 != 0) {
					System.out.print("##" + " ");
				} else if (chessBoard[row][column] == null && row % 2 != 0 && column % 2 == 0) {
					System.out.print("##" + " ");
				} else if (chessBoard[row][column] == null && row % 2 != 0 && column % 2 != 0) {
					System.out.print("  " + " ");
				} else {
					System.out.print(chessBoard[row][column] + " ");
				}
			}
			System.out.println(8-row + "");
		}
		System.out.println("a  b  c  d  e  f  g  h");
	}

}
