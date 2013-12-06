package game;

import pieces.Piece;
import board.Square;
import chessrules.*;
public class PreMove {
	public boolean premove(CurrentBoard board, Square start, Square target){
		for(Piece piece: board.pieces){
			if (piece.getColour()!=start.OccupiyingPiece.getColour()){
				switch(piece.getColour()){
				case "Black":
					switch(piece.getName()){
					case"Q":
						QueenMovement q= new QueenMovement();
						return q.CheckQueen2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"R":
						RookMovement r= new RookMovement();
						return r.CheckRook2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"N":
						KnightMovement n = new KnightMovement();
						n.CheckKnight2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"":
						PawnMovement p = new PawnMovement();
						p.CheckPawn2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"B":
						BishopMovement b = new BishopMovement();
						return b.CheckBishop2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					}
				case "White":
					switch(piece.getName()){
					case"Q":
					QueenMovement q= new QueenMovement();			
					return q.CheckQueen2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"R":
					RookMovement r= new RookMovement();
					return r.CheckRook2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"N":
						KnightMovement n = new KnightMovement();
						n.CheckKnight2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"":
						PawnMovement p = new PawnMovement();
						p.CheckPawn2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					case"B":
						BishopMovement b = new BishopMovement();
						return b.CheckBishop2(board, piece.getPosition(), board.pieces.get(0).getPosition(), start, target);
					}
			}
		}
		
		
		
		
	}
		return false;
}
}