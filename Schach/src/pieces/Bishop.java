package pieces;

import game.CurrentBoard;
import board.Square;
import chessrules.Movement;

public class Bishop extends Piece implements Moveable {

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		Movement move = new Movement();
		if (move.MoveBishop(this.board, this.position, target) == true) {
			this.position.setOccupied(false);
			this.setPosition(target);
			this.position.setOccupied(true);
			System.out.println("B" + (this.position.toString()));
		} else {
			System.out.println("Ungültiger Zug!");
		}
	}

	public Bishop(CurrentBoard board, String colour, Square position) {
		this.board=board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece=this;
	}

	// TODO

	@Override
	public String toString() {

		return colour + " Bishop on " + position.toString();
	}

}
