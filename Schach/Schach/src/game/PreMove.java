package game;

import pieces.Piece;
import board.Square;
import chessrules.*;

public class PreMove {
	public boolean premove(CurrentBoard board, Square start, Square target) {
		boolean result = false;
		for (Piece piece : board.pieces) {
			if (result == true) {
				return result;
			}
			if (!(piece.getPosition() == board.Squares[0][0])
					&& !(piece.getColour() == start.OccupiyingPiece.getColour())
					&& (!(piece.getPosition() == target))) {
				switch (piece.getColour()) {
				case "Black":
					switch (piece.getName()) {
					case "K":
						KingMovement k = new KingMovement();
						result = k.MoveKing2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					case "Q":
						QueenMovement q = new QueenMovement();
						result = q.CheckQueen2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					case "R":
						RookMovement r = new RookMovement();
						result = r.CheckRook2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					case "N":
						KnightMovement n = new KnightMovement();
						result = n.CheckKnight2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					case "":
						PawnMovement p = new PawnMovement();
						result = p.CheckPawn2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					case "B":
						BishopMovement b = new BishopMovement();
						result = b.CheckBishop2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					}
					break;
				case "White":
					switch (piece.getName()) {
					case "K":
						KingMovement k = new KingMovement();
						result = k.MoveKing2(board, piece.getPosition(),
								board.pieces.get(0).getPosition(), start,
								target);
						break;
					case "Q":					
						QueenMovement q = new QueenMovement();
						result = q.CheckQueen2(board, piece.getPosition(),
								board.pieces.get(1).getPosition(), start,
								target);
						break;
					case "R":
						RookMovement r = new RookMovement();
						result = r.CheckRook2(board, piece.getPosition(),
								board.pieces.get(1).getPosition(), start,
								target);
						break;
					case "N":
						KnightMovement n = new KnightMovement();
						result = n.CheckKnight2(board, piece.getPosition(),
								board.pieces.get(1).getPosition(), start,
								target);
						break;
					case "":
						PawnMovement p = new PawnMovement();
						result = p.CheckPawn2(board, piece.getPosition(),
								board.pieces.get(1).getPosition(), start,
								target);
						break;
					case "B":
						BishopMovement b = new BishopMovement();
						result = b.CheckBishop2(board, piece.getPosition(),
								board.pieces.get(1).getPosition(), start,
								target);
						break;
					}
					break;
				}
			}

		}

		return result;
	}
}