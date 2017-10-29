package game;
import pieces.Piece;
import java.util.Scanner;
import pieces.Piece;
public class Game {
	
	private static Scanner scanner;

	
	public static boolean attemptMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow){		
		if(board.chessBoard[startRow][startColumn] == null){
			return false;
		}else if(board.chessBoard[startRow][startColumn].color == 'b' && board.whitesTurn == true){
			System.out.print(board.chessBoard[startRow][startColumn].color);
			System.out.print(board.whitesTurn);
			System.out.println("Invalid Move. It is white's turn.");
			return false;
		}else if(board.chessBoard[startRow][startColumn].color == 'w' && board.whitesTurn == false) {
			System.out.println("Invalid Move. It is black's turn.");
			return false;
		}else if(startColumn == endColumn && startRow == endRow) {
			System.out.println("Invalid Move. You cannot move to the same space.");
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();

		while(true) {
			Scanner scanner = new Scanner(System.in).useDelimiter(" ");
			board.showChessBoard();
	
			if(board.whitesTurn) {
				System.out.println("White's Turn.");
			}else {
				System.out.println("Black's Turn.");
			}
			
			System.out.print("Enter your move: ");
			String startingPosition = scanner.nextLine();
			int startingColumn = board.convertFile(startingPosition.charAt(0));
			int startingRow = board.convertRank(startingPosition.charAt(1));	
			int endingColumn = board.convertFile(startingPosition.charAt(3));
			int endingRow =  board.convertRank(startingPosition.charAt(4));	
			if(startingColumn < 0 || startingRow < 0 ||endingColumn < 0 || endingRow < 0 ||startingColumn > 8 || startingRow > 8 ||endingColumn > 8 || endingRow > 8 ) {
				System.out.println("One of those positions doesn't exist");
				System.out.println(startingColumn);
				System.out.println(startingRow);
				System.out.println(endingColumn);
				System.out.println(endingRow);
				System.out.println(startingPosition);
			}else {
				System.out.println(startingColumn);
				System.out.println(startingRow);
				System.out.println(endingColumn);
				System.out.println(endingRow);
				System.out.println(startingPosition);
		
				
		//		while (!board.checkmate) {
		//			System.out.println("playing game");
		//		}
				if(attemptMove(board,startingColumn,startingRow, endingColumn, endingRow)) {
					Piece current = board.chessBoard[startingRow][startingColumn];
					Piece ending = board.chessBoard[endingRow][endingColumn];
						if(board.chessBoard[startingRow][startingColumn] == null) {
							if(board.chessBoard[startingRow][startingColumn].color == 'w' && (board.chessBoard[endingRow][endingColumn].color == 'w')){
								System.out.println("Invalid Move. You cannot take your own piece.");
							}else if(board.chessBoard[startingRow][startingColumn].color == 'b' && (board.chessBoard[endingRow][endingColumn].color == 'b')){
								System.out.println("Invalid Move. You cannot take your own piece.");
							}else {
								System.out.println("Invalid Piece Selection");
							}
							
						}else if(board.chessBoard[endingRow][endingColumn] != null) {
							System.out.println("hits");
							if(ending.color == 'w' && board.whitesTurn == false ) {
								if(!(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow))) {
									
								}else {
									System.out.println("0");
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									board.whitesTurn = !board.whitesTurn;
								}
							}else if(ending.color == 'b' && board.whitesTurn == true) {
								if(!(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow))) {
									
								}else {
									System.out.println("1");
									board.chessBoard[endingRow][endingColumn]= board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									board.whitesTurn = !board.whitesTurn;
								}
							}else {
								System.out.println("You cannot take your own piece");
							}
						}else {
							if(!(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow))) {
								
							}else {
								board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
								board.chessBoard[startingRow][startingColumn] = null;
								board.whitesTurn = !board.whitesTurn;
							}
						
					}
				}
			}
			
		}
	}
}
