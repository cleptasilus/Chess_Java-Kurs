package pieces;

import board.Square;

public class MovePiece {
	public void Move(Piece p, Square target) {
		boolean captures = false;
		if (target.isOccupied()) {
			captures = true;
		}
		p.position.setOccupied(false);
		p.setPosition(target);
		p.position.setOccupied(true);
		p.position.setOccupiyingPiece(p);
		p.board.enPassanteSquare = null;
		String movestring = captures == true ? "x" + p.position.toString()
				: (p.position.toString());
		System.out.println(p.name + movestring);
	}
}
