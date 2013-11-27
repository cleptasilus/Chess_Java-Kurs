package pieces;

import chessrules.PawnMovement;
import game.CurrentBoard;
import board.Square;

public class Pawn extends Piece implements Moveable {

	public void enPassante(Square target) {
		this.board.enPassanteSquare = null;
		if ((this.board.enPassanteSquare.getPositionx() == this.position
				.getPositionx() + 1 || this.board.enPassanteSquare
				.getPositionx() == this.position.getPositionx() - 1)
				&& (this.board.enPassanteSquare.getPositiony() == this.position
						.getPositiony())) {
			this.position.setOccupied(false);
			this.setPosition(target);
			this.position.setOccupied(true);
			this.position.setOccupiyingPiece(this);
			this.board.enPassanteSquare.OccupiyingPiece
					.setPosition(this.board.Squares[0][0]);
			this.board.enPassanteSquare = null;
			;
			String movestring = this.position.toString();
			System.out.println("x" + movestring);

		}
	}

	public void Transform() {
		String wantedpiece="";
		board.transform(wantedpiece, this, this.position);
		//TODO WANTEDPIECE MIT NUTZERAUSWAHL

	}

	// TODO

	@Override
	public void Move(Square target) {
		// TODO Auto-generated method stub
		PawnMovement move = new PawnMovement();
		if (move.MovePawn(this.board, this.position, target) == true) {
			MovePiece movement = new MovePiece();
			movement.Move(this, target);
			if ((this.colour == "White" && this.position.getPositiony() == 8)
					|| this.colour == "Black"
					&& this.position.getPositiony() == 1) {
				Transform();
			}
		} else {
			System.out.println("Ungültiger Zug!");
		}

	}

	public void Move2(Square target) {
		// TODO Auto-generated method stub
		PawnMovement move = new PawnMovement();
		if (move.MovePawn2(this.board, this.position, target) == true) {
			this.position.setOccupied(false);
			this.setPosition(target);
			this.position.setOccupied(true);
			this.position.setOccupiyingPiece(this);
			this.board.enPassanteSquare = this.position;
			String movestring = this.position.toString();
			System.out.println(movestring);

		} else {
			System.out.println("Ungültiger Zug!");
		}
	}

	public Pawn(CurrentBoard board, String colour, Square position) {
		this.board = board;
		this.colour = colour;
		this.position = position;
		this.position.setOccupied(true);
		this.position.OccupiyingPiece = this;
		this.name = "";
	}

	@Override
	public String toString() {
		if (this.position == null) {
			return "Captured Pawn";
		}
		return colour + " Pawn on " + position.toString();
	}
}
