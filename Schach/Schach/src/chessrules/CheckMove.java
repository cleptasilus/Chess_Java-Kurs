package chessrules;

import pieces.Piece;
import game.CurrentBoard;
import board.Square;

public class CheckMove {
	public boolean canCapture(Square start, Square target) {
		if (target.OccupiyingPiece.getColour() == start.OccupiyingPiece
				.getColour()) {
			// System.out
			// .println("Du kannst keine eigene Figur schlagen!");
			return false;
		}
		return true;
	}

	public boolean MoveLegal(CurrentBoard board, Square start, Square target) {
		// Prüft ob der Weg frei ist
		PathClear clear = new PathClear();
		if (clear.isClear(board, start, target)) {

			// Wenn der Weg frei ist, prüfe ob Ziel belegt
			if (target.isOccupied()) {

				// Prüfung andere Farbe Ja/Nein
				CheckMove capture = new CheckMove();
				if (!capture.canCapture(start, target)) {
					return false;
				}
			}

			return true;
		}
		return false;

	}

	public boolean MoveLegalNoCapture(CurrentBoard board, Square start,
			Square target) {
		// Prüft ob der Weg frei ist
		PathClear clear = new PathClear();
		if (clear.isClear(board, start, target)) {
			// TODO
			// Wenn der Weg frei ist, prüfe ob Ziel belegt
			// if (target.isOccupied()) {
			//
			// //Prüfung andere Farbe Ja/Nein
			// CheckMove capture = new CheckMove();
			// if (!capture.canCapture(start, target)) {
			// return false;
			// }
			// }

			return true;
		}
		return false;

	}
	public boolean MoveLegalNoCapture2(CurrentBoard board, Square start,
			Square target, Square movedpiecestart, Square movedpiecetarget) {
		// Prüft ob der Weg frei ist
		PathClear clear = new PathClear();
		if (clear.isClear2(board, start, target, movedpiecestart, movedpiecetarget)) {
			// TODO
			// Wenn der Weg frei ist, prüfe ob Ziel belegt
			// if (target.isOccupied()) {
			//
			// //Prüfung andere Farbe Ja/Nein
			// CheckMove capture = new CheckMove();
			// if (!capture.canCapture(start, target)) {
			// return false;
			// }
			// }

			return true;
		}
		return false;

	}
	public boolean MoveLegalNoCapture3(CurrentBoard board, Square start,
			Square target, Square movedpiecestart, Square movedpiecetarget, Square epsquare) {
		// Prüft ob der Weg frei ist
		PathClear clear = new PathClear();
		if (clear.isClear3(board, start, target, movedpiecestart, movedpiecetarget, epsquare)) {
			// TODO
			// Wenn der Weg frei ist, prüfe ob Ziel belegt
			// if (target.isOccupied()) {
			//
			// //Prüfung andere Farbe Ja/Nein
			// CheckMove capture = new CheckMove();
			// if (!capture.canCapture(start, target)) {
			// return false;
			// }
			// }

			return true;
		}
		return false;

	}

	public boolean DiscoveredCheck(CurrentBoard board, Square start) {
		for (Piece i : board.pieces) {
			if (i.getColour() == start.OccupiyingPiece.getColour()) {
				if (i.getColour() == "White") {
					switch (i.getName()) {
					case "N":
						continue;
					case "K":
						continue;
					case "":
						continue;
					case "R":
						RookMovement rookmove = new RookMovement();
						if (rookmove.CheckRook(board, i.getPosition(),
								board.pieces.get(1).getPosition())) {
							return true;
						} else {
							continue;
						}
					case "Q":
						QueenMovement queenmove = new QueenMovement();
						if (queenmove.CheckQueen(board, i.getPosition(),
								board.pieces.get(1).getPosition())) {
							return true;
						} else {
							continue;
						}
					case "B":
						BishopMovement bishopmove = new BishopMovement();
						if (bishopmove.CheckBishop(board, i.getPosition(),
								board.pieces.get(1).getPosition())) {
							return true;
						} else {
							continue;
						}
					}
				}
				if (i.getColour() == "Black") {
					switch (i.getName()) {
					case "N":
						continue;
					case "K":
						continue;
					case "":
						continue;
					case "R":
						RookMovement rookmove = new RookMovement();
						if (rookmove.CheckRook(board, i.getPosition(),
								board.pieces.get(0).getPosition())) {
							return true;
						} else {
							continue;
						}
					case "Q":
						QueenMovement queenmove = new QueenMovement();
						if (queenmove.CheckQueen(board, i.getPosition(),
								board.pieces.get(0).getPosition())) {
							return true;
						} else {
							continue;
						}
					case "B":
						BishopMovement bishopmove = new BishopMovement();
						if (bishopmove.CheckBishop(board, i.getPosition(),
								board.pieces.get(0).getPosition())) {
							return true;
						} else {
							continue;
						}
					}
				}
			}
		}
		return false;
	}
}
