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

	public boolean CheckQueen2(CurrentBoard board, Square start, Square target,
			Square movedpiecestart, Square movedpiecetarget) {
		for (int n = 0; n < 8; n++) {
			CheckMove movecheck = new CheckMove();
			if (!(movedpiecestart.OccupiyingPiece.getName() == "K")) {

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

					return movecheck.MoveLegalNoCapture2(board, start, target,
							movedpiecestart, movedpiecetarget);
				}
			} else if (((movedpiecetarget.getPositionx() == start
					.getPositionx() + n || movedpiecetarget.getPositionx() == start
					.getPositionx() - n) && (movedpiecetarget.getPositiony() == start
					.getPositiony() + n || movedpiecetarget.getPositiony() == start
					.getPositiony() - n))
					|| (((movedpiecetarget.getPositionx() == start
							.getPositionx() + n || movedpiecetarget
							.getPositionx() == start.getPositionx() - n) && (movedpiecetarget
							.getPositiony() == start.getPositiony())) || ((movedpiecetarget
							.getPositiony() == start.getPositiony() + n || movedpiecetarget
							.getPositiony() == start.getPositiony() - n) && (movedpiecetarget
							.getPositionx() == start.getPositionx())))) {
				return movecheck.MoveLegalNoCapture2(board, start,
						movedpiecetarget, movedpiecestart, null);
			}
		}

		return false;
	}

	public boolean CheckQueen3(CurrentBoard board, Square start, Square target,
			Square movedpiecestart, Square movedpiecetarget, Square epsquare) {
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
				return movecheck.MoveLegalNoCapture3(board, start, target,
						movedpiecestart, movedpiecetarget, epsquare);

			}

		}
		return false;
	}
}