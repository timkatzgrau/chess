import java.util.Scanner;

public class Game {
	
	private static Scanner scanner;

	public static boolean attemptMove(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow){		
		if(board.chessBoard[startRow][startColumn] == null){
			System.out.println("This is not a valid piece.");
			return false;
		}else if(board.chessBoard[startRow][startColumn].color == 'b' && board.whitesTurn == true){
			System.out.print(board.chessBoard[startRow][startColumn].color);
			System.out.print(board.whitesTurn);
			System.out.println("Invalid Move. It is white's turn.");
			return false;
		}else if(board.chessBoard[startRow][startColumn].color == 'w' && board.whitesTurn == false) {
			System.out.println("Invalid Move. It is black's turn.");
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
			}
			if(attemptMove(board,startingColumn,startingRow, endingColumn, endingRow)) {
				board.whitesTurn = !board.whitesTurn;
			}
		}
	}
}
