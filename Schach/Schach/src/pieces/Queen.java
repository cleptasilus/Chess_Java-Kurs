package pieces;

import game.CurrentBoard;

import board.Square;

public class Queen extends Piece {



	public Queen(CurrentBoard board, String colour, Square position) {
		this.board = board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece = this;
		this.name = "Q";
	}

	@Override
	public String toString() {
		if (this.position == null) {
			return "Captured Queen";
		}

		return colour + " Queen on " + position.toString();
	}
	// TODO
}
