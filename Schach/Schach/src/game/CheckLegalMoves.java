package game;

import chessrules.*;

import pieces.Piece;
import players.Player;

public class CheckLegalMoves {
	public boolean LegalMoves(CurrentBoard board, String colour) {

		PreMove pre = new PreMove();
		boolean result = false;
		for (Piece piece : board.pieces) {
			if (result == true){
				return result;
			}
			if (!(piece.getPosition()== board.Squares[0][0]) && !(piece.getColour() == colour) ) { // spieler der dran ist: GIBT
													// ES LEGALE ZÜGE
				switch (piece.getName()) {
				case "K":
					KingMovement king = new KingMovement();
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							if (i == 0 && j == 0) {
								continue;
							}
							if (piece.getPosition().getPositionx() + i > 8
									|| piece.getPosition().getPositionx() + i <= 0
									|| piece.getPosition().getPositiony() + j > 8
									|| piece.getPosition().getPositiony() + j <= 0) {
								continue;
							}
							if (king.MoveKing(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;

								}

							}

						}
					}
					break;
				case "Q":
					QueenMovement queen = new QueenMovement();
					for (int i = -7; i <= 7; i++) {
						for (int j = -7; j <= 7; j++) {
							if (!(i == j) || !(i == -j) || (i == 0 && j == 0)
									|| !(i == 0 && j != 0)
									|| !(i != 0 && j == 0)) {
								continue;
							}
							if (piece.getPosition().getPositionx() + i > 8
									|| piece.getPosition().getPositionx() + i <= 0
									|| piece.getPosition().getPositiony() + j > 8
									|| piece.getPosition().getPositiony() + j <= 0) {
								continue;
							}
							if (queen.MoveQueen(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;

								}

							}
						}
					}
					break;
				case "R":
					RookMovement rook = new RookMovement();
					for (int i = -7; i <= 7; i++) {
						for (int j = -7; j <= 7; j++) {
							if (!(i == 0 && j != 0) || !(i != 0 && j == 0)) {
								continue;
							}
							if (piece.getPosition().getPositionx() + i > 8
									|| piece.getPosition().getPositionx() + i <= 0
									|| piece.getPosition().getPositiony() + j > 8
									|| piece.getPosition().getPositiony() + j <= 0) {
								continue;
							}
							if (rook.MoveRook(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;
								}

							}
						}
					}
					break;
				case "N":
					KnightMovement knight = new KnightMovement();
					for (int i = -2; i <= 2; i++) {
						for (int j = -2; j <= 2; j++) {
							if ((i == j) || (i == -j) || (i == 0) || (j == 0)) {
								continue;
							}
							if (piece.getPosition().getPositionx() + i > 8
									|| piece.getPosition().getPositionx() + i <= 0
									|| piece.getPosition().getPositiony() + j > 8
									|| piece.getPosition().getPositiony() + j <= 0) {
								continue;
							}
							if (knight.MoveKnight(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;
								}

							}
						}
					}
					break;
				case "B":
					BishopMovement bishop = new BishopMovement();
					for (int i = -7; i <= 7; i++) {
						for (int j = -7; j <= 7; j++) {
							if (((i != j) && (i != -j)) || (i == 0) || (j == 0)) {
								continue;
							}
							if (piece.getPosition().getPositionx() + i > 8
									|| piece.getPosition().getPositionx() + i <= 0
									|| piece.getPosition().getPositiony() + j > 8
									|| piece.getPosition().getPositiony() + j <= 0) {
								continue;
							}
							if (bishop.MoveBishop(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;
								}

							}
						}
					}
					break;
				case "":
					PawnMovement pawn = new PawnMovement();
					for (int i = -1; i <= 1; i++) {
						for (int j = -2; j <= 2; j++) {
							if ((j == 0) || ((j == 2) || (j == -2) && (i != 0))) {
								continue;
							}
							if (piece.getPosition().getPositionx() + i > 8
									|| piece.getPosition().getPositionx() + i <= 0
									|| piece.getPosition().getPositiony() + j > 8
									|| piece.getPosition().getPositiony() + j <= 0) {
								continue;
							}
							if (pawn.MovePawn(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;
								}

							}
							if (pawn.MovePawn2(board, piece.getPosition(),
									board.Squares[piece.getPosition()
											.getPositionx() + i][piece
											.getPosition().getPositiony() + j])) {
								if (!pre.premove(board, piece.getPosition(),
										board.Squares[piece.getPosition()
												.getPositionx() + i][piece
												.getPosition().getPositiony()
												+ j])) {
									result = true;
								}

							}
						}
					}
					break;
				}
			}
		}

		return false;
	}

}
