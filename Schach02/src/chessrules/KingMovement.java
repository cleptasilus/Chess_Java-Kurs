package chessrules;

import game.CurrentBoard;
import board.Square;

public class KingMovement {
	public boolean MoveKing(CurrentBoard board, Square start, Square target) {

		if (((target.getPositionx() == start.getPositionx() + 1)
				|| (target.getPositionx() == start.getPositionx()) || (target
				.getPositionx() == start.getPositionx()))
				&& ((target.getPositiony() == start.getPositiony() + 1)
						|| (target.getPositiony() == start.getPositiony()) || (target
						.getPositiony() == start.getPositiony()))) {

			if (target.isOccupied()) {
				CheckMove check = new CheckMove();
				return check.canCapture(start, target);

			}
			return true;
		}
		return false;
	}
}
