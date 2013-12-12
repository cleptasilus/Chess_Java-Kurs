package game;

import pieces.Piece;
import board.Square;
import chessrules.BishopMovement;
import chessrules.KnightMovement;
import chessrules.PawnMovement;
import chessrules.QueenMovement;
import chessrules.RookMovement;

public class PreEnPassante {
	public boolean premove(CurrentBoard board, Square start, Square target){
		boolean result = false;
		for(Piece piece: board.pieces){
			if (piece.getColour()!=start.OccupiyingPiece.getColour()){
				switch(piece.getColour()){
				case "Black":
					switch(piece.getName()){
					case"Q":
					QueenMovement q= new QueenMovement();
					result = q.CheckQueen3(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target, board.enPassanteSquare);
					case"R":
					RookMovement r= new RookMovement();
					result= r.CheckRook3(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target, board.enPassanteSquare);
					case"N":
					KnightMovement n = new KnightMovement();
					result = n.CheckKnight2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"":
					PawnMovement p = new PawnMovement();
					result = p.CheckPawn2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"B":
					BishopMovement b = new BishopMovement();
					result = b.CheckBishop3(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target, board.enPassanteSquare);
					}
				case "White":
					switch(piece.getName()){
					case"Q":
					QueenMovement q= new QueenMovement();			
					result = q.CheckQueen3(board, piece.getPosition(), board.pieces.get(1).getPosition(), start, target, board.enPassanteSquare);
					case"R":
					RookMovement r= new RookMovement();
					result = r.CheckRook3(board, piece.getPosition(), board.pieces.get(1).getPosition(), start, target, board.enPassanteSquare);
					case"N":
					KnightMovement n = new KnightMovement();
					result = n.CheckKnight2(board, piece.getPosition(), board.pieces.get(1).getPosition(), start, target);
					case"":
					PawnMovement p = new PawnMovement();
					result = p.CheckPawn2(board, piece.getPosition(), board.pieces.get(1).getPosition(), start, target);
					case"B":
					BishopMovement b = new BishopMovement();
					result = b.CheckBishop3(board, piece.getPosition(), board.pieces.get(1).getPosition(), start, target, board.enPassanteSquare);
					}
			}
		}
		
		
		
		
	}
		return result;
}
}
