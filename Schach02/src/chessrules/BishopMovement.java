package chessrules;

import game.CurrentBoard;
import board.Square;

public class BishopMovement {
	public boolean MoveBishop(CurrentBoard board, Square start, Square target) {

		for (int n = 0; n < 8; n++) {
			// Läufer bewegt sich diagaonal, Achsen verhalten sich also wie f(x)
			// = x oder f(x) = -x
			if ((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n)
					&& (target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n)) {

				// Prüft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegal(board, start, target);

			}
		}
		return false;

	}
}
