package boardGame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		super();
		this.board = board;
		this.position = null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) {
		// Calling a possible implementation of a Piece subclass
		// Template Method - depends on abstract method
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean[][] matrix = possibleMoves();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
