package game;
import pieces.Piece;
import java.util.Scanner;
import pieces.Piece;
public class Game {
	
	static boolean testing = true;
	
	private static Scanner scanner;
	
	private static boolean promotionSet = false;
	
	private static boolean drawSet = false;

	
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
		ChessBoard board;
		if(testing) {
			 board = new ChessBoard(1);
		}else {
			 board = new ChessBoard();
		}

		while(true) {
			
			//lets not depend on some other part to set this back to false
			//might skip it if something has gone wrong and will be stuck at true
			//set back to false on next move
			if (promotionSet) {
				promotionSet = false;
			}
			
			System.out.println("heres the bool" + promotionSet);
			
			System.out.println("-------------------------");
			Scanner scanner = new Scanner(System.in).useDelimiter(" ");
			board.showChessBoard();
	
			if(board.whitesTurn) {
				System.out.println("White's Turn.");
			}else {
				System.out.println("Black's Turn.");
			}
			
			System.out.print("Enter your move: ");
			String startingPosition = scanner.nextLine();
			
			if (startingPosition.contains("resign")) {
				if (board.whitesTurn) {
					System.out.println("Black wins");
				} else {
					System.out.println("White wins");
				}
				break;
			} else if (startingPosition.contains("draw")) {
				if (!drawSet) {
					drawSet = true;
				} else {
					if (startingPosition.equals("draw")) {
						break;
					}
				}
			} else if (!startingPosition.contains("draw") && drawSet) {
				drawSet = false;
			}
			
			
			int startingColumn = board.convertFile(startingPosition.charAt(0));
			int startingRow = board.convertRank(startingPosition.charAt(1));	
			int endingColumn = board.convertFile(startingPosition.charAt(3));
			int endingRow =  board.convertRank(startingPosition.charAt(4));	
			if(startingColumn < 0 || startingRow < 0 ||endingColumn < 0 || endingRow < 0 ||startingColumn > 8 || startingRow > 8 ||endingColumn > 8 || endingRow > 8 ) {
				System.out.println("One of those positions doesn't exist");
			}else {	
		//		while (!board.checkmate) {
		//			System.out.println("playing game");
		//		}
				
				if (startingPosition.length() == 7) {
					char newPiece = Character.toLowerCase(startingPosition.charAt(6));
					
					if (newPiece == 'p' || newPiece == 'k') {
						System.out.println("Invalid Move. Can not promote pawn to king or pawn");
						continue;
					}
					
					if (board.chessBoard[startingRow][startingColumn].type != 'p') {
						System.out.println("Invalid Move. Can not promote piece that is not a pawn");
						continue;
					}
					
					if ((board.chessBoard[startingRow][startingColumn].color == 'w' && endingRow == 0) || (board.chessBoard[startingRow][startingColumn].color == 'b' && endingRow == 7)) {
						promotionSet = true;
					} else{
						System.out.print("Invalid attempt at promotion");
						continue;
					}
				}
				
				
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
							if(ending.color == 'w' && board.whitesTurn == false ) {
								if(!(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow))) {
									
								}else {
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									
									if (promotionSet) {
										board.promote(endingRow, endingColumn, Character.toLowerCase(startingPosition.charAt(6)));
									}
									if(board.check()) {		
										board.whitesTurn = !board.whitesTurn;
									}
									
								}
							}else if(ending.color == 'b' && board.whitesTurn == true) {
								if(!(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow))) {
									
								}else {
									board.chessBoard[endingRow][endingColumn]= board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									
									if (promotionSet) {
										board.promote(endingRow, endingColumn, Character.toLowerCase(startingPosition.charAt(6)));
									}
									
									if(board.check()) {		
										board.whitesTurn = !board.whitesTurn;
									}
									
									
								}
							}else {
								System.out.println("You cannot take your own piece");
							}
						}else {
							if(!(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow))) {
								
							}else {
								board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
								board.chessBoard[startingRow][startingColumn] = null;
								
								if (promotionSet) {
									board.promote(endingRow, endingColumn, Character.toLowerCase(startingPosition.charAt(6)));
								}
								
								if(board.check()) {		
									board.whitesTurn = !board.whitesTurn;
								}
								
								
							}
						
					}
				}
			}
			
		}
	}
}