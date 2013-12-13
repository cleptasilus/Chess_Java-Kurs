package pieces;

import game.CurrentBoard;
import board.Square;

public class Knight extends Piece  {



	public Knight(CurrentBoard board, String colour, Square position) {
		this.board = board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece = this;
		this.name = "N";
	}

	@Override
	public String toString() {
		if (this.position == null) {
			return "Captured Knight";
		}
		return colour + " Knight on " + position.toString();
	}
	// TODO

}
