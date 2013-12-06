package chessrules;

import game.CurrentBoard;
import board.Square;

public class BishopMovement {
	public boolean MoveBishop(CurrentBoard board, Square start, Square target) {

		for (int n = 0; n < 8; n++) {
			// L�ufer bewegt sich diagaonal, Achsen verhalten sich also wie f(x)
			// = x oder f(x) = -x
			if ((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n)
					&& (target.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n)) {

				// Pr�ft ob der Weg frei ist und er schlagen darf
				// Return false wenn weg nicht frei oder Zielfeld eigene Figur
				// Return true wenn Zug legal

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegal(board, start, target);

			}
		}
		return false;

	}
	public boolean CheckBishop(CurrentBoard board, Square start, Square target) {
		for (int n = 0; n < 8; n++) {
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony() + n || target
					.getPositiony() == start.getPositiony() - n)))
			{

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture(board, start, target);

			}

		}
		return false;
	}
	public boolean CheckBishop2(CurrentBoard board, Square start, Square target, Square movedpiecestart, Square movedpiecetarget) {
		for (int n = 0; n < 8; n++) {
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony() + n || target
					.getPositiony() == start.getPositiony() - n)))
			{

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture2(board, start, target, movedpiecestart, movedpiecetarget);

			}

		}
		return false;
	}
}
