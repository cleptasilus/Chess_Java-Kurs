package pieces;

import game.CurrentBoard;
import board.Square;


public class Bishop extends Piece  {



	public Bishop(CurrentBoard board, String colour, Square position) {
		this.board = board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece = this;
		this.name = "B";
	}

	// TODO

	@Override
	public String toString() {
		if (this.position == null) {
			return "Captured Bishop";
		}
		return colour + " Bishop on " + position.toString();
	}

}
