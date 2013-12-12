package pieces;

import game.CurrentBoard;
import board.Square;

public class MovePiece {
	public void Move(CurrentBoard board, Piece piece, Square target) {

		piece.position.setOccupied(false);
		piece.position.setOccupiyingPiece(null);
		piece.setPosition(target);
		piece.position.setOccupied(true);
		piece.position.setOccupiyingPiece(piece);
		piece.board.enPassanteSquare = null;
		piece.hasmoved=true;

	}
	public void movepawntwosquares(CurrentBoard board, Piece piece, Square target){
		piece.position.setOccupied(false);
		piece.position.setOccupiyingPiece(null);
		piece.setPosition(target);
		piece.position.setOccupied(true);
		piece.position.setOccupiyingPiece(piece);
		piece.board.enPassanteSquare = piece.getPosition();
		piece.hasmoved=true;
	}
	public void moveenpassante(CurrentBoard board, Piece piece, Square target){
		piece.position.setOccupied(false);
		piece.position.setOccupiyingPiece(null);
		piece.setPosition(target);
		piece.position.setOccupied(true);
		piece.position.setOccupiyingPiece(piece);
		piece.board.enPassanteSquare.OccupiyingPiece.setPosition(board.Squares[0][0]);
		piece.board.enPassanteSquare.setOccupiyingPiece(null);
		piece.board.enPassanteSquare.setOccupied(false);
		piece.hasmoved=true;
		
	}
}
