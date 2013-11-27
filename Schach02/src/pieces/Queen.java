package pieces;

import game.CurrentBoard;
import chessrules.QueenMovement;
import board.Square;

public class Queen extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		QueenMovement move = new QueenMovement();
		if (move.MoveQueen(this.board, this.position, target) == true) {
			MovePiece movement = new MovePiece();
			movement.Move(this, target);
		} else {
			System.out.println("Ungültiger Zug!");
		}
	}

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
