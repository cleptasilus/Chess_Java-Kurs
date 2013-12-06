package chessrules;

import board.Square;
import game.CurrentBoard;

public class QueenMovement {
	public boolean MoveQueen(CurrentBoard board, Square start, Square target) {
		for (int n = 0; n < 8; n++) {
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony() + n || target
					.getPositiony() == start.getPositiony() - n))
					|| (((target.getPositionx() == start.getPositionx() + n || target
							.getPositionx() == start.getPositionx() - n) && (target
							.getPositiony() == start.getPositiony())) || ((target
							.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx())))) {

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegal(board, start, target);

			}

		}
		return false;
	}
	public boolean CheckQueen(CurrentBoard board, Square start, Square target) {
		for (int n = 0; n < 8; n++) {
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony() + n || target
					.getPositiony() == start.getPositiony() - n))
					|| (((target.getPositionx() == start.getPositionx() + n || target
							.getPositionx() == start.getPositionx() - n) && (target
							.getPositiony() == start.getPositiony())) || ((target
							.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx())))) {

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture(board, start, target);

			}

		}
		return false;
	}
	public boolean CheckQueen2(CurrentBoard board, Square start, Square target, Square movedpiecestart,Square movedpiecetarget) {
		for (int n = 0; n < 8; n++) {
			if (((target.getPositionx() == start.getPositionx() + n || target
					.getPositionx() == start.getPositionx() - n) && (target
					.getPositiony() == start.getPositiony() + n || target
					.getPositiony() == start.getPositiony() - n))
					|| (((target.getPositionx() == start.getPositionx() + n || target
							.getPositionx() == start.getPositionx() - n) && (target
							.getPositiony() == start.getPositiony())) || ((target
							.getPositiony() == start.getPositiony() + n || target
							.getPositiony() == start.getPositiony() - n) && (target
							.getPositionx() == start.getPositionx())))) {

				CheckMove movecheck = new CheckMove();
				return movecheck.MoveLegalNoCapture2(board, start, target, movedpiecestart, movedpiecetarget);

			}

		}
		return false;
	}
}