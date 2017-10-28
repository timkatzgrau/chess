

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
