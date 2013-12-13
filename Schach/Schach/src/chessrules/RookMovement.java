package chessrules;

import game.CurrentBoard;
import board.Square;

public class RookMovement {
	public boolean MoveRook(CurrentBoard board, Square start, Square target) {
		for (int n = 0; n < 8; n++) {
			// Turm bewegt sich nur auf einer Achse, daher:
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony()))
					|| ((target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx()))) {

				// Prüft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegal(board, start, target);

			}
		}

		return false;

	}
	public boolean CheckRook(CurrentBoard board, Square start, Square target) {
		for (int n = 0; n < 8; n++) {
			// Turm bewegt sich nur auf einer Achse, daher:
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony()))
					|| ((target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx()))) {

				// Prüft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture(board, start, target);

			}
		}

		return false;

	}
	public boolean CheckRook2(CurrentBoard board, Square start, Square target, Square movedpiecestart, Square movedpiecetarget) {
		for (int n = 0; n < 8; n++) {
			// Turm bewegt sich nur auf einer Achse, daher:
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony()))
					|| ((target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx()))) {

				// Prüft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				
				if(!(movedpiecestart.OccupiyingPiece.getName()=="K")){
					return movecheck.MoveLegalNoCapture2(board, start, target, movedpiecestart, movedpiecetarget);
				}
				else if (((movedpiecetarget.getPositionx() == start.getPositionx() + n || movedpiecetarget
										.getPositionx() == start.getPositionx() - n) && (movedpiecetarget
										.getPositiony() == start.getPositiony())) || ((movedpiecetarget
										.getPositiony() == start.getPositiony() + n || movedpiecetarget
										.getPositiony() == start.getPositiony() - n) && (movedpiecetarget
										.getPositionx() == start.getPositionx()))){
				return movecheck.MoveLegalNoCapture2(board, start, movedpiecetarget, movedpiecestart, target);
				}
			}
		}

		return false;

	}
	public boolean CheckRook3(CurrentBoard board, Square start, Square target, Square movedpiecestart, Square movedpiecetarget, Square epsquare) {
		for (int n = 0; n < 8; n++) {
			// Turm bewegt sich nur auf einer Achse, daher:
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony()))
					|| ((target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx()))) {

				// Prüft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture3(board, start, target, movedpiecestart, movedpiecetarget, epsquare);

			}
		}

		return false;

	}
}
