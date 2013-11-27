package pieces;

import game.CurrentBoard;
import board.Square;
import chessrules.BishopMovement;

public class Bishop extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		BishopMovement move = new BishopMovement();
		if (move.MoveBishop(this.board, this.position, target) == true) {
			MovePiece movement = new MovePiece();
			movement.Move(this, target);
		} else {
			System.out.println("Ungültiger Zug!");
		}
	}

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
