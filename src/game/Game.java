package game;
import pieces.Piece;
import java.util.Scanner;
import pieces.Piece;

/**
 * @author Asad Dar
 * @author Tim Katzgrau
 * This class will handle starting up the chess game
 **/

public class Game {
	
	/**
	 * whether the program is in testing mode or not
	 **/
	static boolean testing = false;
	
	/**
	 * the scanner instance that will be used for user input
	 **/
	private static Scanner scanner;
	
	/**
	 * whether or not a user has indicated they would like to promote a pawn
	 **/
	private static boolean promotionSet = false;
	
	/**
	 * whether or not a user has indicated they would like to draw the game
	 **/
	private static boolean drawSet = false;

	/**
	 * @param board
	 * the chess board that is being used to play
	 * @param startColumn
	 * index for the column the piece is starting at
	 * @param startRow
	 * index for the row the piece is starting at
	 * @param endColumn
	 * index for the column the piece is ending at
	 * @param endRow
	 * index for the row the piece is ending at
	 * @return whether the move is still valid after a series of checks
	 **/
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
	
	/**
	 * the game loop
	 **/
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
					
						if(board.chessBoard[startingRow][startingColumn] == null) {
							System.out.println("Invalid Piece Selection");
						}else if(startingColumn == endingColumn && startingRow == endingRow) {
							System.out.println("Cannot move to same spot.");
						}else if((board.chessBoard[startingRow][startingColumn] != null && board.chessBoard[endingRow][endingColumn] != null && board.chessBoard[startingRow][startingColumn].type == 'K' && board.chessBoard[endingRow][endingColumn].type == 'R') && (board.chessBoard[startingRow][startingColumn].color == board.chessBoard[endingRow][endingColumn].color)){
							if(!(board.chessBoard[startingRow][startingColumn].canDoMove(board, startingColumn, startingRow, endingColumn, endingRow))) {
								System.out.println("Invalid Castle");
							}else {
								Piece temp = board.chessBoard[endingRow][endingColumn];
								board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
								board.chessBoard[startingRow][startingColumn] = temp;
								board.chessBoard[endingRow][endingColumn].hasMoved = true;
								board.chessBoard[startingRow][startingColumn].hasMoved = true;
							}
						}else if(board.chessBoard[endingRow][endingColumn] != null) {
							if(board.chessBoard[startingRow][startingColumn].color == board.chessBoard[endingRow][endingColumn].color) {
								System.out.println("You cannot take your own piece!");
							}else if(current.color == 'w' && board.whitesTurn != true) {
								System.out.print("It's not your turn");
							}else if(current.color == 'b' && board.whitesTurn == true) {
								System.out.print("It's not your turn");
							}else {
								if(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow)) {
								
								
								if(board.isInCheck() == 0) {
									if(board.isInCheck() != 0) {
										if(board.isCheckMate()) {
											
										}else {
											System.out.print("Check");
										}
									}
									if (promotionSet) {
										board.promote(startingRow, startingColumn, Character.toLowerCase(startingPosition.charAt(6)));
									}
									
									Piece temp = board.chessBoard[endingRow][endingColumn];
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									
									if(board.isInCheck() == 1 && board.whitesTurn) {
										board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
										board.chessBoard[endingRow][endingColumn] = temp;
										System.out.println("You cannot put yourself in check!");
									}else if(board.isInCheck() == 2 && !board.whitesTurn) {
										board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
										board.chessBoard[endingRow][endingColumn] = temp;
										System.out.println("You cannot put yourself in check!");
									}else {
										board.chessBoard[endingRow][endingColumn].hasMoved = true;
										board.whitesTurn = ! board.whitesTurn;
										board.isInCheck();
										
										if(board.chessBoard[endingRow][endingColumn] != null) {
											if(board.chessBoard[endingRow][endingColumn].color != 'w') {
												board.whiteEnpass = false;
											}else {

												board.blackEnpass = false;
											}
										}
									}
									if(board.isInCheck() != 0) {
										
										if(board.isCheckMate()) {
											
										}else {
											System.out.print("Check");
										}
									}
									
								}else if(board.isInCheck() == 1) {
									if(board.isInCheck() != 0) {
										if(board.isCheckMate()) {
											
										}else {
											System.out.print("Check");
										}
									}

									if (promotionSet) {
										board.promote(startingRow, startingColumn, Character.toLowerCase(startingPosition.charAt(6)));
									}
									
									if(board.whitesTurn == false) {
										board.whitesTurn = !board.whitesTurn;
										board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
										board.chessBoard[startingRow][startingColumn] = null;
										System.out.println("White is in Check!-----");
									}else {
										Piece temp = board.chessBoard[endingRow][endingColumn];
										board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
										board.chessBoard[startingRow][startingColumn] = null;
										
										if(board.isInCheck() == 1) {
											board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
											board.chessBoard[endingRow][endingColumn] = temp;
										}else {
											board.chessBoard[endingRow][endingColumn].hasMoved = true;
											board.whitesTurn = !board.whitesTurn;
											board.isInCheck();
											if(board.chessBoard[endingRow][endingColumn] != null) {
												if(board.chessBoard[endingRow][endingColumn].color != 'w') {
													board.whiteEnpass = false;
												}else {

													board.blackEnpass = false;
												}
											}
										}
									}
									if(board.isInCheck() != 0) {
										if(board.isCheckMate()) {
											
										}else {
											System.out.print("Check");
										}
									}		
								}else if(board.isInCheck() == 2) {
									if(board.isInCheck() != 0) {
										if(board.isCheckMate()) {
											
										}else {
											System.out.print("Check");
										}
									}	
									if (promotionSet) {
										board.promote(startingRow, startingColumn, Character.toLowerCase(startingPosition.charAt(6)));
									}
									
									if(board.whitesTurn == true) {
										board.whitesTurn = !board.whitesTurn;
										board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
										board.chessBoard[startingRow][startingColumn] = null;
										System.out.print("Black is in Check!");
									}else {
										Piece temp = board.chessBoard[endingRow][endingColumn];
										board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
										board.chessBoard[startingRow][startingColumn] = null;
										
										if(board.isInCheck() == 2) {
											board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
											board.chessBoard[endingRow][endingColumn] = temp;
										}else {
											board.chessBoard[endingRow][endingColumn].hasMoved = true;
											board.whitesTurn = !board.whitesTurn;
											board.isInCheck();
											if(board.chessBoard[endingRow][endingColumn] != null) {
												if(board.chessBoard[endingRow][endingColumn].color != 'w') {
													board.whiteEnpass = false;
												}else {

													board.blackEnpass = false;
												}
											}
										}
									}
									if(board.isInCheck() != 0) {
										if(board.isCheckMate()) {
											
										}else {
											System.out.print("Check");
										}
									}	
												
								}
							
								}}
							
						}else {
							if(current.canDoMove(board,startingColumn,startingRow, endingColumn, endingRow)) {
							
							
							if(board.isInCheck() == 0) {

								if (promotionSet) {
									board.promote(startingRow, startingColumn, Character.toLowerCase(startingPosition.charAt(6)));
								}
								
								Piece temp = board.chessBoard[endingRow][endingColumn];
								board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
								board.chessBoard[startingRow][startingColumn] = null;
								
								if(board.isInCheck() == 1 && board.whitesTurn) {
									board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
									board.chessBoard[endingRow][endingColumn] = temp;
									System.out.println("You cannot put yourself in check!");
								}else if(board.isInCheck() == 2 && !board.whitesTurn) {
									board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
									board.chessBoard[endingRow][endingColumn] = temp;
									System.out.println("You cannot put yourself in check!");
								}else {
									board.chessBoard[endingRow][endingColumn].hasMoved = true;
									board.whitesTurn = ! board.whitesTurn;
									board.isInCheck();
									if(board.chessBoard[endingRow][endingColumn] != null) {
										if(board.chessBoard[endingRow][endingColumn].color != 'w') {
											board.whiteEnpass = false;
										}else {

											board.blackEnpass = false;
										}
									}
								}
								if(board.isInCheck() != 0) {
									if(board.isCheckMate()) {
										
									}else {
										System.out.print("Check");
									}
								}
							}else if(board.isInCheck() == 1) {
								board.isCheckMate();
								

								if (promotionSet) {
									board.promote(startingRow, startingColumn, Character.toLowerCase(startingPosition.charAt(6)));
								}
								
								if(board.whitesTurn == false) {
									board.whitesTurn = !board.whitesTurn;
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									System.out.println("White is in Check!---");
								}else {
									Piece temp = board.chessBoard[endingRow][endingColumn];
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									
									if(board.isInCheck() == 1) {
										board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
										board.chessBoard[endingRow][endingColumn] = temp;
									}else {
										board.chessBoard[endingRow][endingColumn].hasMoved = true;
										board.whitesTurn = !board.whitesTurn;
										board.isInCheck();
										if(board.chessBoard[endingRow][endingColumn] != null) {
											if(board.chessBoard[endingRow][endingColumn].color != 'w') {
												board.whiteEnpass = false;
											}else {

												board.blackEnpass = false;
											}
										}
									}
								}
								if(board.isInCheck() != 0) {
									if(board.isCheckMate()) {
										
									}else {
										System.out.print("Check");
									}
								}
											
							}else if(board.isInCheck() == 2) {
								board.isCheckMate();
								if (promotionSet) {
									board.promote(startingRow, startingColumn, Character.toLowerCase(startingPosition.charAt(6)));
								}
								
								if(board.whitesTurn == true) {
									board.whitesTurn = !board.whitesTurn;
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									System.out.print("Black is in Check!");
									System.out.print(board.isInCheck());
								}else {
									Piece temp = board.chessBoard[endingRow][endingColumn];
									board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
									board.chessBoard[startingRow][startingColumn] = null;
									
									if(board.isInCheck() == 2) {
										board.chessBoard[startingRow][startingColumn] = board.chessBoard[endingRow][endingColumn];
										board.chessBoard[endingRow][endingColumn] = temp;
									}else {
										board.chessBoard[endingRow][endingColumn].hasMoved = true;
										board.whitesTurn = !board.whitesTurn;
										if(board.chessBoard[endingRow][endingColumn] != null) {
											if(board.chessBoard[endingRow][endingColumn].color != 'w') {
												board.whiteEnpass = false;
											}else {

												board.blackEnpass = false;
											}
										}
										board.isInCheck();
									}
								}
								if(board.isInCheck() != 0) {
									if(board.isCheckMate()) {
										
									}else {
										System.out.print("Check");
									}
								}
							}
						}
						

						
					}
						
				}
	
		}
	
}}}