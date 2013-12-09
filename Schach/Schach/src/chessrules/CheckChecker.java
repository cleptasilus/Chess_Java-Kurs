package chessrules;

import game.CurrentBoard;
import board.Square;

//Prüfe, ob  die gezogene Figur Schach gibt
public class CheckChecker {
	// TODO
	public boolean MoveChecks(CurrentBoard board, Square target) {
		switch (target.OccupiyingPiece.getColour()) {
		case "Black":
			switch (target.OccupiyingPiece.getName()) {
			case "Q":
				QueenMovement q = new QueenMovement();
				return q.CheckQueen(board, target, board.pieces.get(0)
						.getPosition());
			case "R":
				RookMovement r = new RookMovement();
				return r.CheckRook(board, target, board.pieces.get(0)
						.getPosition());
			case "N":
				KnightMovement n = new KnightMovement();
				return n.CheckKnight(board, target, board.pieces.get(0)
						.getPosition());
			case "":
				PawnMovement p = new PawnMovement();
				return p.CheckPawn(board, target, board.pieces.get(0)
						.getPosition());
			case "B":
				BishopMovement b = new BishopMovement();
				return b.CheckBishop(board, target, board.pieces.get(0)
						.getPosition());
			}
		case "White":
			switch (target.OccupiyingPiece.getName()) {
			case "Q":
				QueenMovement q = new QueenMovement();
				return q.CheckQueen(board, target, board.pieces.get(1)
						.getPosition());
			case "R":
				RookMovement r = new RookMovement();
				return r.CheckRook(board, target, board.pieces.get(1)
						.getPosition());
			case "N":
				KnightMovement n = new KnightMovement();
				return n.CheckKnight(board, target, board.pieces.get(1)
						.getPosition());
			case "":
				PawnMovement p = new PawnMovement();
				return p.CheckPawn(board, target, board.pieces.get(1)
						.getPosition());
			case "B":
				BishopMovement b = new BishopMovement();
				return b.CheckBishop(board, target, board.pieces.get(1)
						.getPosition());
			}
		}

		return false;
	}

}
