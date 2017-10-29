import java.util.Scanner;

public class Game {
	
	private static Scanner scanner;

	public static boolean isVertical(ChessBoard board, int startColumn, int endColumn  ) {
		if(startColumn == endColumn) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isHorizontal(ChessBoard board, int startRow, int endRow  ) {
		if(startRow == endRow) {
			return true;
		}else {
			return false;
		}
	}
	//Works only for bottom left right now
	public static boolean isDiagnal(ChessBoard board, int startColumn, int startRow, int endColumn, int endRow)  {
		
		int vertDirection = 0;
		int horDirection = 0;
		System.out.println("startCol = "+ startColumn);
		System.out.println("startRow = "+ startRow);
		System.out.println("endCol = "+ endColumn);
		System.out.println("endRow = "+ endRow);
		
		if(startColumn > endColumn) {
			horDirection = -1;
		}else if(startColumn < endColumn){
			horDirection = 1;
		}
		
		if(startRow < endRow) {
			vertDirection = -1;
		}else if(startColumn < endColumn){
			vertDirection = 1;
		}
		
		boolean diag = true;
		int tempx = startRow;
		int tempy = startColumn;
		
		
		while(diag) {
			System.out.println("test 0");
			System.out.println(tempx);
			System.out.println(tempy);
			
			tempx++;
			tempy--;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else{
				diag = false;
			}
		}
		
		tempx = startRow;
		tempy = startColumn;
		diag = true;
		
		while(diag) {
			System.out.println("test 1");
			System.out.println(tempx);
			System.out.println(tempy);
			

			tempx++;
			tempy++;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		tempx = startRow;
		tempy = startColumn;
		diag = true;

		while(diag) {
			System.out.println("test 2");

			System.out.println(tempx);
			System.out.println(tempy);
			

			tempx--;
			tempy--;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		
		tempx = startRow;
		tempy = startColumn;
		diag = true;

		while(diag) {
			System.out.println("test 3");

			System.out.println(tempx);
			System.out.println(tempy);
			

			tempx--;
			tempy++;
			if(!(tempx < 0 || tempy < 0 || tempx > 7 || tempy > 7)) {
				if(tempx == endRow && tempy == endColumn) {
					return true;
				}
			}else {
				diag = false;
			}
		}
		return false;
	}
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
					System.out.println(isDiagnal(board,startingColumn,startingRow, endingColumn, endingRow));
					if(board.chessBoard[endingRow][endingColumn] != null) {
						if(board.chessBoard[endingRow][endingColumn].color == 'w' && board.whitesTurn == true) {
							board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
							board.chessBoard[startingRow][startingColumn] = null;
							board.whitesTurn = !board.whitesTurn;
						}else if(board.chessBoard[endingRow][endingColumn].color == 'b' && board.whitesTurn == false) {
							board.chessBoard[endingRow][endingColumn] = board.chessBoard[startingRow][startingColumn];	
							board.chessBoard[startingRow][startingColumn] = null;
							board.whitesTurn = !board.whitesTurn;
						}
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
