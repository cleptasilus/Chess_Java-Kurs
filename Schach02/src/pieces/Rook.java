package pieces;

import game.CurrentBoard;
import chessrules.RookMovement;
import board.Square;

public class Rook extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub

		RookMovement move = new RookMovement();
		if (move.MoveRook(this.board, this.position, target) == true) {
			MovePiece movement = new MovePiece();
			movement.Move(this, target);
			hasmoved = true;
		} else {
			System.out.println("Ungültiger Zug!");
		}
	}

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
