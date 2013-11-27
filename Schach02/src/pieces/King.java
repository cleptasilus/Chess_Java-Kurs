package pieces;

import chessrules.KingMovement;
import game.CurrentBoard;
import board.Square;

public class King extends Piece implements Moveable {
	boolean ischecked;

	@Override
	public void Move(Square target) {
		KingMovement move = new KingMovement();
		if (move.MoveKing(this.board, this.position, target) == true) {
			MovePiece movement = new MovePiece();
			movement.Move(this, target);
		} else {
			System.out.println("Ungültiger Zug!");
		}
		hasmoved = true;
	}

	public void Castle(CurrentBoard board, Square target) {
		if (target.getPositionx() == 7) {
			if (this.hasmoved == false
					&& board.Squares[8][this.position.getPositiony()]
							.getOccupiyingPiece().name == "R"
					&& board.Squares[8][this.position.getPositiony()]
							.getOccupiyingPiece().hasmoved == false) {
				if (board.Squares[6][this.position.getPositiony()].isOccupied() == false
						&& board.Squares[7][this.position.getPositiony()]
								.isOccupied() == false) {
					this.setPosition(target);
					board.Squares[8][this.position.getPositiony()]
							.getOccupiyingPiece().setPosition(
									board.Squares[6][this.position
											.getPositiony()]);
					System.out.println("0-0");

				} else {
					System.out.println("Ungültiger Zug!");
				}

			}
		}
		if (target.getPositionx() == 3) {
			if (this.hasmoved == false
					&& board.Squares[1][this.position.getPositiony()]
							.getOccupiyingPiece().name == "R"
					&& board.Squares[1][this.position.getPositiony()]
							.getOccupiyingPiece().hasmoved == false) {
				if (board.Squares[2][this.position.getPositiony()].isOccupied() == false
						&& board.Squares[3][this.position.getPositiony()]
								.isOccupied() == false
						&& board.Squares[4][this.position.getPositiony()]
								.isOccupied() == false) {
					this.setPosition(target);
					board.Squares[1][this.position.getPositiony()]
							.getOccupiyingPiece().setPosition(
									board.Squares[4][this.position
											.getPositiony()]);
					System.out.println("0-0-0");

				} else {
					System.out.println("Ungültiger Zug!");
				}

			}
		}
	}

	public King(CurrentBoard board, String colour, Square position) {
		this.board = board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece = this;
		this.name = "K";
	}

	@Override
	public String toString() {

		return colour + " King on " + position.toString();
	}
	// TODO
}
