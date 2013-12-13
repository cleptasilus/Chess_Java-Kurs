package pieces;

import game.CurrentBoard;
import board.Square;

public class Rook extends Piece {



	public Rook(CurrentBoard board, String colour, Square position) {
		this.board = board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece = this;
		this.name = "R";
	}

	@Override
	public String toString() {
		if (this.position == null) {
			return "Captured Rook";
		}
		return colour + " Rook on " + position.toString();
	}
	// TODO
}
