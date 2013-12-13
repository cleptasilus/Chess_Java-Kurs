package chessrules;

import game.CurrentBoard;
import board.Square;

public class KnightMovement {
	public boolean MoveKnight(CurrentBoard board, Square start, Square target) {

		if (((target.getPositionx() == start.getPositionx() + 2) || (target
				.getPositionx() == start.getPositionx() - 2))
				&& ((target.getPositiony() == start.getPositiony() + 1) || (target
						.getPositiony() == start.getPositiony() - 1))
				|| (((target.getPositiony() == start.getPositiony() + 2) || (target
						.getPositiony() == start.getPositiony() - 2)) && ((target
						.getPositionx() == start.getPositionx() + 1) || (target
						.getPositionx() == start.getPositionx() - 1)))) {

			if (target.isOccupied()) {
				CheckMove check = new CheckMove();
				return check.canCapture(start, target);

			}
			return true;
		}
		return false;

	}

	public boolean CheckKnight(CurrentBoard board, Square start, Square target) {

		if (((target.getPositionx() == start.getPositionx() + 2) || (target
				.getPositionx() == start.getPositionx() - 2))
				&& ((target.getPositiony() == start.getPositiony() + 1) || (target
						.getPositiony() == start.getPositiony() - 1))
				|| (((target.getPositiony() == start.getPositiony() + 2) || (target
						.getPositiony() == start.getPositiony() - 2)) && ((target
						.getPositionx() == start.getPositionx() + 1) || (target
						.getPositionx() == start.getPositionx() - 1)))) {

			return true;
		}
		return false;
	}

	public boolean CheckKnight2(CurrentBoard board, Square start,
			Square target, Square movedpiecestart, Square movedpiecetarget) {
		if (!(movedpiecestart.OccupiyingPiece.getName() == "K")) {
			if (((target.getPositionx() == start.getPositionx() + 2) || (target
					.getPositionx() == start.getPositionx() - 2))
					&& ((target.getPositiony() == start.getPositiony() + 1) || (target
							.getPositiony() == start.getPositiony() - 1))
					|| (((target.getPositiony() == start.getPositiony() + 2) || (target
							.getPositiony() == start.getPositiony() - 2)) && ((target
							.getPositionx() == start.getPositionx() + 1) || (target
							.getPositionx() == start.getPositionx() - 1)))) {

				return true;
			}
		} else if (((movedpiecetarget.getPositionx() == start.getPositionx() + 2) || (movedpiecetarget
				.getPositionx() == start.getPositionx() - 2))
				&& ((movedpiecetarget.getPositiony() == start.getPositiony() + 1) || (movedpiecetarget
						.getPositiony() == start.getPositiony() - 1))
				|| (((movedpiecetarget.getPositiony() == start.getPositiony() + 2) || (movedpiecetarget
						.getPositiony() == start.getPositiony() - 2)) && ((movedpiecetarget
						.getPositionx() == start.getPositionx() + 1) || (movedpiecetarget
						.getPositionx() == start.getPositionx() - 1)))) {
			return true;

		}
		return false;
	}
}
