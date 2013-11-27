package pieces;

import game.CurrentBoard;
import chessrules.KnightMovement;
import board.Square;

public class Knight extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		KnightMovement move = new KnightMovement();
		if (move.MoveKnight(this.board, this.position, target) == true) {
			MovePiece movement = new MovePiece();
			movement.Move(this, target);
		} else {
			System.out.println("Ungültiger Zug!");
		}
	}

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
