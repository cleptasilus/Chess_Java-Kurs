package pieces;


import game.CurrentBoard;
import board.Square;

public class Pawn extends Piece {

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
