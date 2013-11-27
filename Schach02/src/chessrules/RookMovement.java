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

				// Pr�ft ob der Weg frei ist und er schlagen darf
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

				// Pr�ft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture(board, start, target);

			}
		}

		return false;

	}
}
